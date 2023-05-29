package models;

public class User extends Person {
    private String address;

    public User(String name, String email, String phone, int age, String address) {
        super(name, email, phone, age);
        this.address = address;
    }

    public User() {

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }



}

