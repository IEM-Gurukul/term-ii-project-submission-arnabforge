//Entry point of the Hospital Management System
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HospitalManager hm = new HospitalManager();

        // Sample doctors
        hm.addDoctor(new Doctor(101, "Dr. Sharma", "Cardiology"));
        hm.addDoctor(new Doctor(102, "Dr. Roy", "Dermatology"));
        
        int choice;

        do {
            System.out.println("\n===== Hospital Management System =====");
            System.out.println("1. Add Patient");
            System.out.println("2. View Doctors");
            System.out.println("3. Book Appointment");
            System.out.println("4. View Appointments");
            System.out.println("5. Cancel Appointment");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            if (choice < 0 || choice > 5) {
                System.out.println("Invalid choice! Try again.");
                continue;
            }

            switch (choice) {

                case 1:
                    System.out.print("Enter Patient ID: ");
                    int pid = sc.nextInt();
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
                    int age = sc.nextInt();

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
                    int aid = sc.nextInt();

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
