//Represents a doctor with specialization
public class Doctor extends User {
    String specialization;

    Doctor(int id, String name, String specialization) {
        super(id, name);
        this.specialization = specialization;
    }
}
    


