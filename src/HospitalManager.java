//Manages patients, doctors, and appointments
    import java.util.ArrayList;
    public class HospitalManager {



    ArrayList<Patient> patients = new ArrayList<>();
    ArrayList<Doctor> doctors = new ArrayList<>();
    ArrayList<Appointment> appointments = new ArrayList<>();

    void addPatient(Patient p) {
        patients.add(p);
        System.out.println("Patient added successfully!");
    }

    void addDoctor(Doctor d) {
        doctors.add(d);
        System.out.println("Doctor added successfully!");
    }

    void viewDoctors() {
        System.out.println("\n--- Doctor List ---");
        for (Doctor d : doctors) {
            System.out.println(d.id + " - " + d.name + " (" + d.specialization + ")");
        }
    }

    void bookAppointment(Appointment a) {
        appointments.add(a);
        System.out.println("Appointment booked successfully!");
    }

    void viewAppointments() {
        System.out.println("\n--- Appointments ---");
        for (Appointment a : appointments) {
            System.out.println(
                a.appointmentId + " | " +
                a.patient.name + " -> " +
                a.doctor.name + " at " + a.time
            );
        }
    }

    void cancelAppointment(int id) {
        boolean found = false;
        for (Appointment a : appointments) {
            if (a.appointmentId == id) {
                appointments.remove(a);
                System.out.println("Appointment cancelled!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Appointment not found!");
        }
    }
}
    

