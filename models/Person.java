package models;

import java.util.Objects;

public class Person {
    private int id;
    private String name;
    private String email;
    private String phone;
    private int age;

    public Person() {

    }

    public Person(String name, String email, String phone, int age) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.age = age;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [age=" + age + ", email=" + email + ", id=" + id + ", name=" + name + ", phone=" + phone + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        return age == other.age && Objects.equals(email, other.email) && Objects.equals(name, other.name)
                && Objects.equals(phone, other.phone);
    }

    @Override
    public int hashCode() {
       return Objects.hash(name, email, phone, age);
    }



}
