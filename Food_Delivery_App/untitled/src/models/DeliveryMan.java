package models;

public class DeliveryMan extends Person{

    private Float salary;

    private Float rating;

    public DeliveryMan(String name, String email, String phone, int age, Float salary, Float rating) {
        super(name, email, phone, age);
        this.salary = salary;
        this.rating = rating;
    }

    public DeliveryMan() {

    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "DeliveryMan{" +
                "salary=" + salary +
                ", rating=" + rating +
                "} " + super.toString();
    }


}
