//Represents an appointment between a patient and a doctor
public class Appointment {
    
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
    

