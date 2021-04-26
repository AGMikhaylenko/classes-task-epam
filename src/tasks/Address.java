package tasks;

import java.util.Objects;

public class Address {
    private String city;
    private String street;
    private int houseId;
    private int flatId;

    public Address(){
        this.city = "Unknown";
        this.street = "Unknown";
    }

    public Address(String city, String street, int houseId) {
        this.city = city;
        this.street = street;
        this.houseId = houseId;
        this.flatId = 0;
    }

    public Address(String city, String street, int houseId, int flatId) {
        this(city, street, houseId);
        this.flatId = flatId;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getHouseId() {
        return houseId;
    }

    public int getFlatId() {
        return flatId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return houseId == address.houseId &&
                flatId == address.flatId &&
                Objects.equals(city, address.city) &&
                Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, houseId, flatId);
    }

    @Override
    public String toString() {
        String textAddress = "Address: " + city + ", " + street + " street, " + houseId;
        return flatId == 0 ? textAddress : textAddress + ", " + flatId;
    }
}
