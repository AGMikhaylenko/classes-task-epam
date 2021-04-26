package tasks.one;

import tasks.Address;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class StudentMain {

    private Student[] listOfStudents;

    public static void main(String[] args) {

        Student studentOne = new Student("Ivan", "Ivanov", "Ivanovich",
                new GregorianCalendar(1995, 10, 26).getTime(), 9301534747L, Faculty.FPIE, 3, 125);
        Student studentTwo = new Student("Petr", "Petrov", "Petrovich",
                new GregorianCalendar(1996, 0, 11).getTime(), 9201685878L, Faculty.FUSK, 1, 125);
        Student studentThree = new Student("Alexander", "Mikhaylenko", "Gennadyevich", new Address("Tver", "Sedova", 14, 20),
                new GregorianCalendar(1994, 8, 16).getTime(), 9065550088L, Faculty.FIT, 4, 127);
        Student studentFour = new Student("Nikolay", "Nikolaev", "Nikolaevich", new Address("Tver", "Sovetskaya", 20),
                new GregorianCalendar(1995, 8, 23).getTime(), 9807456982L, Faculty.FIT, 2, 129);

        StudentMain test = new StudentMain(new Student[]{studentOne, studentTwo, studentThree, studentFour});

        System.out.println(getString(test.getStudents(Faculty.FIT)));
        System.out.println(getString(test.getStudents(Faculty.FIT, 4)));
        System.out.println(getString(test.getStudents(125)));
        System.out.println(getString(test.getStudentsAfterYear(1994)));
    }

    public StudentMain(Student[] listOfStudents) {
        this.listOfStudents = listOfStudents;
    }

    /**
     * Поиск студентов по факультету
     * @param faculty Факультет
     * @return Список студентов
     */
    public Student[] getStudents(Faculty faculty) {
        ArrayList<Student> students = new ArrayList<>();

        for (Student s : listOfStudents)
            if (s.getFaculty() == faculty)
                students.add(s);

        return students.toArray(new Student[students.size()]);
    }

    /**
     * Поиск студентов по факультету и курсу
     * @param faculty Факультет
     * @param yearOfEducation Курс
     * @return Список студентов
     */
    public Student[] getStudents(Faculty faculty, int yearOfEducation) {
        ArrayList<Student> students = new ArrayList<>();

        for (Student s : listOfStudents)
            if (s.getFaculty() == faculty && s.getYearsOfEducation() == yearOfEducation)
                students.add(s);

        return students.toArray(new Student[students.size()]);
    }

    /**
     * Поиск студентов по группе
     * @param groupId Идентификатор группы
     * @return Список студентов
     */
    public Student[] getStudents(int groupId) {
        ArrayList<Student> students = new ArrayList<>();

        for (Student s : listOfStudents)
            if (s.getGroupId() == groupId)
                students.add(s);

        return students.toArray(new Student[students.size()]);
    }

    /**
     * Поиск студентов, родившихся после определенного года
     * @param year Год
     * @return Список студентов
     */
    public Student[] getStudentsAfterYear(int year) {
        ArrayList<Student> students = new ArrayList<>();

        for (Student s : listOfStudents)
            if (s.getDateOfBirth().after(new GregorianCalendar(year, Calendar.DECEMBER, 31).getTime()))
                students.add(s);

        return students.toArray(new Student[students.size()]);
    }

    /**
     * Получение строкового представления массива студентов
     * @param students Список студентов
     * @return Строковое представление списка студентов
     */
    public static String getString(Student[] students) {
        String result = "";
        for (Student s : students)
            if (s != null)
                result += s.toString() + "\n";
        return result;
    }
}
