package tasks.three;

import tasks.Address;
import tasks.Human;

import java.util.Objects;

public class Patient extends Human {

    private static int currentId = 0;

    private int id;
    private long phone;
    private int numberOfCard;
    private Diagnosis diagnosis;

    public Patient(String firstName, String lastName, String patronymic, Address address) {
        super(firstName, lastName, patronymic, address);
        this.id = currentId++;
        this.diagnosis = Diagnosis.NONE;
    }

    public Patient(String firstName, String lastName, String patronymic, Address address, long phone) {
        this(firstName, lastName, patronymic, address);
        this.phone = phone;
    }

    public Patient(String firstName, String lastName, String patronymic, Address address, long phone, int numberOfCard) {
        this(firstName, lastName, patronymic, address, phone);
        this.numberOfCard = numberOfCard;
    }

    public Patient(String firstName, String lastName, String patronymic, Address address, long phone, int numberOfCard, Diagnosis diagnosis) {
        this(firstName, lastName, patronymic, address, phone, numberOfCard);
        this.diagnosis = diagnosis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Patient patient = (Patient) o;
        return phone == patient.phone &&
                numberOfCard == patient.numberOfCard &&
                diagnosis == patient.diagnosis;
    }

    public int getId() {
        return id;
    }

    public long getPhone() {
        return phone;
    }

    public int getNumberOfCard() {
        return numberOfCard;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public void setNumberOfCard(int numberOfCard) {
        if (this.numberOfCard == 0)
            this.numberOfCard = numberOfCard;
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), phone, numberOfCard, diagnosis);
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "ID: " + id + " " +
                (phone != 0 ? "Phone: " + phone + " " : "") +
                (numberOfCard != 0 ? "Card: " + numberOfCard + " " : "") +
                diagnosis.getFullName();
    }
}
