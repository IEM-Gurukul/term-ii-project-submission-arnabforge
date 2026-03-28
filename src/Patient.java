//Represents a patient in the hospital
class Patient extends User {
    int age;
    String contact;

    Patient(int id, String name, int age, String contact) {
        super(id, name);
        this.age = age;
        this.contact = contact;
    }
}