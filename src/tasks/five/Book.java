package tasks.five;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Book {
    private static int currentId = 0;

    private int id;
    private String name;
    private List<Author> authors;
    private String publishingHouse;
    private int year;
    private int countOfPages;
    private double price;
    private Binding binding;

    public Book(String name, List<Author> authors, int year, int countOfPages, Binding binding) {
        this.name = name;
        this.authors = authors;
        this.year = year;
        this.countOfPages = countOfPages;
        this.binding = binding;
        this.id = currentId++;
        this.publishingHouse = "Unknown";
    }

    public Book(String name, List<Author> authors, String publishingHouse, int year, int countOfPages, Binding binding) {
        this(name, authors, year, countOfPages, binding);
        this.publishingHouse = publishingHouse;
    }

    public Book(String name, List<Author> authors, String publishingHouse, int year, int countOfPages, double price, Binding binding) {
        this(name, authors, publishingHouse, year, countOfPages, binding);
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public int getYear() {
        return year;
    }

    public int getCountOfPages() {
        return countOfPages;
    }

    public double getPrice() {
        return price;
    }

    public Binding getBinding() {
        return binding;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                year == book.year &&
                countOfPages == book.countOfPages &&
                Double.compare(book.price, price) == 0 &&
                Objects.equals(name, book.name) &&
                Objects.equals(authors, book.authors) &&
                Objects.equals(publishingHouse, book.publishingHouse) &&
                binding == book.binding;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, authors, publishingHouse, year, countOfPages, price, binding);
    }

    @Override
    public String toString() {
        return name + " " + Arrays.toString(authors.toArray()) + "\n" +
                year + (publishingHouse.equals("Unknown") ? "" : ", " + publishingHouse) + ", " +
                countOfPages + " pages, " + binding.toString() + (price != 0.0 ? ", Price: " + price : "");
    }

    class Author {
        private String firstName;
        private String lastName;

        public Author(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Author author = (Author) o;
            return Objects.equals(firstName, author.firstName) &&
                    Objects.equals(lastName, author.lastName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(firstName, lastName);
        }

        @Override
        public String toString() {
            return lastName + " " + firstName;
        }
    }
}
