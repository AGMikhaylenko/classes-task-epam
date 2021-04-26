package tasks.four;

import tasks.Address;
import tasks.Human;

import java.util.Arrays;
import java.util.Objects;

public class Abiturient extends Human implements Comparable {

    private static int currentId;

    private int id;
    private long phone;
    private Rating[] ratings;

    public Abiturient(String firstName, String lastName, String patronymic, Address address) {
        super(firstName, lastName, patronymic, address);
        this.id = currentId++;
    }

    public Abiturient(String firstName, String lastName, String patronymic, Address address, long phone) {
        this(firstName, lastName, patronymic, address);
        this.phone = phone;
    }

    public Abiturient(String firstName, String lastName, String patronymic, Address address, long phone, Rating[] ratings) {
        this(firstName, lastName, patronymic, address, phone);
        this.ratings = ratings;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Abiturient) {
            return this.getSumOfRatings() - ((Abiturient) o).getSumOfRatings();
        } else
            throw new IllegalArgumentException("Сравниваемый объект должен быть создан на основании класса"
                    + this.getClass().getName());
    }

    public int getSumOfRatings() {
        int sum = 0;
        for (Rating r : ratings)
            sum += r.getValue();
        return sum;
    }

    public long getPhone() {
        return phone;
    }

    public Rating[] getRatings() {
        return ratings;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public void setRatings(Rating[] ratings) {
        if (ratings == null)
            this.ratings = ratings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Abiturient that = (Abiturient) o;
        return id == that.id &&
                phone == that.phone &&
                Arrays.equals(ratings, that.ratings);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(super.hashCode(), id, phone);
        result = 31 * result + Arrays.hashCode(ratings);
        return result;
    }

    @Override
    public String toString() {
        return super.toString() +
                (phone != 0 ? "\nPhone: " + phone : "") +
                (ratings != null ? "\nRatings: " + Arrays.toString(ratings) : "");
    }

    class Rating {
        private Discipline discipline;
        private int value;

        public Rating(Discipline discipline, int value) {
            this.discipline = discipline;
            this.value = value;
        }

        public Discipline getDiscipline() {
            return discipline;
        }

        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            return discipline.toString() + ":" + value;
        }
    }
}
