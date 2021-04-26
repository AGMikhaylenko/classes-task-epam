package tasks.two;

import tasks.Address;
import tasks.Human;

import java.util.Objects;

public class Customer extends Human implements Comparable {

    private static int currentId = 0;

    private int id;
    private long numberOfCard;
    private long numberOfDeposit;


    public Customer(String firstName, String lastName, String patronymic, Address address, long numberOfCard) {
        super(firstName, lastName, patronymic, address);
        this.numberOfCard = numberOfCard;
        this.id = currentId++;
    }

    public Customer(String firstName, String lastName, String patronymic, Address address, long numberOfCard, long numberOfDeposit) {
        this(firstName, lastName, patronymic, address, numberOfCard);
        this.numberOfDeposit = numberOfDeposit;
    }

    public int getId() {
        return id;
    }

    public long getNumberOfCard() {
        return numberOfCard;
    }

    public long getNumberOfDeposit() {
        return numberOfDeposit;
    }

    public void setNumberOfCard(long numberOfCard) {
        this.numberOfCard = numberOfCard;
    }

    public void setNumberOfDeposit(long numberOfDeposit) {
        this.numberOfDeposit = numberOfDeposit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Customer customer = (Customer) o;
        return id == customer.id &&
                numberOfCard == customer.numberOfCard &&
                numberOfDeposit == customer.numberOfDeposit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, numberOfCard, numberOfDeposit);
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Number of card: " + numberOfCard + (numberOfDeposit != 0 ? ", Number of deposit " + numberOfDeposit : "");
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Customer)
            return super.getFullName().compareTo((((Customer) o).getFullName()));
        else
            throw new IllegalArgumentException("Сравниваемый объект должен быть создан на основании класса"
                    + this.getClass().getName());
    }
}
