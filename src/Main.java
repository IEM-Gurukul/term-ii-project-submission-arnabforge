//Entry point of the Hospital Management System
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HospitalManager hm = new HospitalManager();

        // Sample doctors
        hm.addDoctor(new Doctor(101, "Dr. Sharma", "Cardiology"));
        hm.addDoctor(new Doctor(102, "Dr. Roy", "Dermatology"));
        hm.addDoctor(new Doctor(103, "Dr. Sen", "Neurology"));
        hm.addDoctor(new Doctor(104, "Dr. Gupta", "Orthopedics"));
        hm.addDoctor(new Doctor(105, "Dr. Das", "Pediatrics"));
        hm.addDoctor(new Doctor(106, "Dr. Banerjee", "General Medicine"));
        
        int choice =-1;

        do {
            System.out.println("\n===== Hospital Management System =====");
            System.out.println("1. Add Patient");
            System.out.println("2. View Doctors");
            System.out.println("3. Book Appointment");
            System.out.println("4. View Appointments");
            System.out.println("5. Cancel Appointment");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            try {
                choice = sc.nextInt();
            }catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine();
                continue;
            }
            if (choice < 0 || choice > 5) {
                System.out.println("Invalid choice! Try again.");
                continue;
            }

            switch (choice) {

                case 1:
                    System.out.print("Enter Patient ID: ");
                    int pid;
                try {
                    pid = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("Invalid Patient ID!");
                    sc.nextLine();
                    break;
                }
                    if (pid <= 0) {
                        System.out.println("Invalid Patient ID!");
                        break;
                    }
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String pname = sc.nextLine();
                    
                    if (pname.trim().isEmpty()) {
                       System.out.println("Name cannot be empty!");
                       break;
                    }

                    System.out.print("Enter Age: ");
                    
                    int age;
                    try {
                        age = sc.nextInt();
                    }catch (Exception e) {
                        System.out.println("Invalid age input!");
                        sc.nextLine();
                        break;
                    }

                    if (age <= 0) {
                        System.out.println("Invalid age!");
                        break;
                    }
                    sc.nextLine();

                    System.out.print("Enter Contact: ");
                    String contact = sc.nextLine();

                    hm.addPatient(new Patient(pid, pname, age, contact));
                    break;

                case 2:
                    hm.viewDoctors();
                    break;

                case 3:
                    System.out.print("Enter Appointment ID: ");
                    int aid;
                try {
                    aid = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("Invalid Appointment ID!");
                    sc.nextLine();
                    break;
                }

                    System.out.print("Enter Patient ID: ");
                    int patientId = sc.nextInt();

                    System.out.print("Enter Doctor ID: ");
                    int doctorId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Time: ");
                    String time = sc.nextLine();

                    Patient selectedPatient = null;
                    Doctor selectedDoctor = null;

                    for (Patient p : hm.patients) {
                        if (p.id == patientId) {
                            selectedPatient = p;
                        }
                    }

                    for (Doctor d : hm.doctors) {
                        if (d.id == doctorId) {
                            selectedDoctor = d;
                        }
                    }

                    if (selectedPatient == null || selectedDoctor == null) {
                        System.out.println("Invalid Patient or Doctor ID!");
                        break;
                    }
                     hm.bookAppointment(new Appointment(aid, selectedPatient, selectedDoctor, time));
                     break;

                case 4:
                    hm.viewAppointments();
                    break;

                case 5:
                    System.out.print("Enter Appointment ID to cancel: ");
                    int cancelId = sc.nextInt();
                    hm.cancelAppointment(cancelId);
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        sc.close();
    }
}
