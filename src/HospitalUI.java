import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class Patient {
    int id;
    String name;

    Patient(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Doctor {
    int id;
    String name;
    String specialization;

    Doctor(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }
}

class Appointment {
    int appointmentId;
    Patient patient;
    Doctor doctor;
    String time;

    Appointment(int appointmentId, Patient patient, Doctor doctor, String time) {
        this.appointmentId = appointmentId;
        this.patient = patient;
        this.doctor = doctor;
        this.time = time;
    }
}

public class HospitalUI {

    static ArrayList<Patient> patients = new ArrayList<>();
    static ArrayList<Doctor> doctors = new ArrayList<>();
    static ArrayList<Appointment> appointments = new ArrayList<>();

    static int patientCounter = 1;
    static int appointmentCounter = 1;

    public static void main(String[] args) {

        // Add some doctors
        doctors.add(new Doctor(1, "Dr. Sharma", "Cardiology"));
        doctors.add(new Doctor(2, "Dr. Roy", "Neurology"));
        doctors.add(new Doctor(3, "Dr. Sen", "Orthopedics"));
        doctors.add(new Doctor(4, "Dr. Gupta", "Dermatology"));
        doctors.add(new Doctor(5, "Dr. Das", "Pediatrics"));
        doctors.add(new Doctor(6, "Dr. Mehta", "General Medicine"));
        doctors.add(new Doctor(7, "Dr. Banerjee", "ENT"));
        doctors.add(new Doctor(8, "Dr. Verma", "Gynecology"));
        JFrame frame = new JFrame("Hospital Management System");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JButton addPatientBtn = new JButton("Add Patient");
        JButton viewDoctorsBtn = new JButton("View Doctors");
        JButton bookBtn = new JButton("Book Appointment");
        JButton viewBtn = new JButton("View Appointments");

        JTextArea output = new JTextArea(20, 40);
        output.setEditable(false);

        frame.add(addPatientBtn);
        frame.add(viewDoctorsBtn);
        frame.add(bookBtn);
        frame.add(viewBtn);
        frame.add(new JScrollPane(output));


        // Add Patient
        addPatientBtn.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Enter patient name:");

            if (name == null || name.trim().isEmpty()) {
                output.setText("Invalid name!");
                return;
            }

            Patient p = new Patient(patientCounter++, name);
            patients.add(p);

            output.setText("Patient added: " + p.name);
        });

        // View Doctors
        viewDoctorsBtn.addActionListener(e -> {
            output.setText("Doctors List:\n");

            for (Doctor d : doctors) {
                output.append(d.id + " - " + d.name + " (" + d.specialization + ")\n");
            }
        });

        // Book Appointment
        bookBtn.addActionListener(e -> {

            if (patients.isEmpty()) {
                output.setText("No patients available!");
                return;
            }

            String pIdStr = JOptionPane.showInputDialog("Enter Patient ID:");
            String dIdStr = JOptionPane.showInputDialog("Enter Doctor ID:");
            String time = JOptionPane.showInputDialog("Enter Time:");

            try {
                int pId = Integer.parseInt(pIdStr);
                int dId = Integer.parseInt(dIdStr);

                Patient selectedPatient = null;
                Doctor selectedDoctor = null;

                for (Patient p : patients) {
                    if (p.id == pId) {
                        selectedPatient = p;
                        break;
                    }
                }

                for (Doctor d : doctors) {
                    if (d.id == dId) {
                        selectedDoctor = d;
                        break;
                    }
                }

                if (selectedPatient == null || selectedDoctor == null) {
                    output.setText("Invalid Patient/Doctor ID!");
                    return;
                }

                Appointment a = new Appointment(appointmentCounter++, selectedPatient, selectedDoctor, time);
                appointments.add(a);

                output.setText("Appointment booked successfully!");

            } catch (Exception ex) {
                output.setText("Invalid input!");
            }
        });

        // View Appointments
        viewBtn.addActionListener(e -> {

            if (appointments.isEmpty()) {
                output.setText("No appointments available!");
                return;
            }

            output.setText("Appointments:\n");

            for (Appointment a : appointments) {
                output.append("ID: " + a.appointmentId + "\n");
                output.append("Patient: " + a.patient.name + "\n");
                output.append("Doctor: " + a.doctor.name + "\n");
                output.append("Time: " + a.time + "\n");
                output.append("---------------------\n");
            }
        });

        frame.setVisible(true);
    }
}
