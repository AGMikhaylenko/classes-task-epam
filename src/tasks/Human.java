package tasks;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Human {
    private String firstName;
    private String lastName;
    private String patronymic;
    private Address address;
    private Date dateOfBirth;

    public Human() {
        this.firstName = "";
        this.lastName = "";
        this.patronymic = "";
        this.dateOfBirth = new Date(0);
        this.address = new Address();
    }

    public Human(String firstName, String lastName, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = "";
        this.dateOfBirth = dateOfBirth;
        this.address = new Address();
    }

    public Human(String firstName, String lastName, Address address, Date dateOfBirth) {
        this(firstName, lastName, dateOfBirth);
        this.address = address;
    }

    public Human(String firstName, String lastName, String patronymic, Date dateOfBirth) {
        this(firstName, lastName, dateOfBirth);
        this.patronymic = patronymic;
    }

    public Human(String firstName, String lastName, String patronymic, Address address, Date dateOfBirth) {
        this(firstName, lastName, patronymic, dateOfBirth);
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Address getAddress() {
        return address;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int compareTo(Human human) {
        return human == null ? 1 : dateOfBirth.compareTo(human.dateOfBirth);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(firstName, human.firstName) &&
                Objects.equals(lastName, human.lastName) &&
                Objects.equals(patronymic, human.patronymic) &&
                Objects.equals(address, human.address) &&
                Objects.equals(dateOfBirth, human.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, patronymic, address, dateOfBirth);
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + " " + patronymic + " " +
                new SimpleDateFormat("dd/MM/YYYY").format(dateOfBirth).toString() +"\n"+ address.toString();
    }
}
