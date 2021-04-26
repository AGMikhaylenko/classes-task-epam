package tasks.one;

import tasks.Address;
import tasks.Human;

import java.util.Date;
import java.util.Objects;

public class Student extends Human {
    private static int currentId = 0;

    private int id;
    private long phoneNumber;
    private Faculty faculty;
    private int yearsOfEducation;
    private int groupId;


    public Student(String firstName, String lastName, Date dateOfBirth, long phoneNumber, Faculty faculty,
                   int yearsOfEducation, int groupId) {
        super(firstName, lastName, dateOfBirth);
        this.id = currentId++;
        this.phoneNumber = phoneNumber;
        this.faculty = faculty;
        this.yearsOfEducation = yearsOfEducation;
        this.groupId = groupId;
    }

    public Student(String firstName, String lastName, Address address, Date dateOfBirth, long phoneNumber,
                   Faculty faculty, int yearsOfEducation, int groupId) {
        this(firstName, lastName, dateOfBirth, phoneNumber, faculty, yearsOfEducation, groupId);
        super.setAddress(address);
    }

    public Student(String firstName, String lastName, String patronymic, Date dateOfBirth, long phoneNumber,
                   Faculty faculty, int yearsOfEducation, int groupId) {
        super(firstName, lastName, patronymic, dateOfBirth);
        this.id = currentId++;
        this.phoneNumber = phoneNumber;
        this.faculty = faculty;
        this.yearsOfEducation = yearsOfEducation;
        this.groupId = groupId;
    }

    public Student(String firstName, String lastName, String patronymic, Address address, Date dateOfBirth,
                   long phoneNumber, Faculty faculty, int yearsOfEducation, int groupId) {
        this(firstName, lastName, patronymic, dateOfBirth, phoneNumber, faculty, yearsOfEducation, groupId);
        super.setAddress(address);
    }

    public int getId() {
        return id;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public int getYearsOfEducation() {
        return yearsOfEducation;
    }

    public int getGroupId() {
        return groupId;
    }

    public void transferToNextCourse() {
        this.yearsOfEducation++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return id == student.id &&
                phoneNumber == student.phoneNumber &&
                yearsOfEducation == student.yearsOfEducation &&
                groupId == student.groupId &&
                Objects.equals(faculty, student.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, phoneNumber, faculty, yearsOfEducation, groupId);
    }

    @Override
    public String toString() {
        return super.toString() + "\nPhone: " + phoneNumber +
                "\n" + faculty.fullName + ", groupId: " + groupId + ", yearOfEducation: " + yearsOfEducation;
    }
}
