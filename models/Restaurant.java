package models;

import java.util.Objects;

public class Restaurant {

    private int id;
    private String name;
    private String address;
    private Float rating;

    public Restaurant() {
    }

    public Restaurant(String name, String address, Float rating) {
        this.name = name;
        this.address = address;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(address, that.address) &&
                Objects.equals(rating, that.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, rating);
    }


    @Override
    public String toString() {
        return "Restaurant [address=" + address + ", id=" + id + ", name=" + name + ", rating=" + rating + "]";
    }

}
