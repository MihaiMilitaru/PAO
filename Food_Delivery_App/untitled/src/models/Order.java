package models;

import java.lang.reflect.Array;

public class Order {

    private int id;
    private User user;
    private Restaurant restaurant;

    private DeliveryMan deliveryMan;

    private Food food;

    private Beverage beverage;

    public Order(){

    }

    public Order(User user, Restaurant restaurant, DeliveryMan deliveryMan, Food food, Beverage beverage) {
        this.user = user;
        this.restaurant = restaurant;
        this.deliveryMan = deliveryMan;
        this.food = food;
        this.beverage = beverage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public DeliveryMan getDeliveryMan() {
        return deliveryMan;
    }

    public void setDeliveryMan(DeliveryMan deliveryMan) {
        this.deliveryMan = deliveryMan;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Beverage getBeverage() {
        return beverage;
    }

    public void setBeverage(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String toString() {
        String food = "";
        String beverage = "";
        if (this.food != null){
            food = this.food.toString();
        }
        if (this.beverage != null){
            beverage = this.beverage.toString();
        }
        return "Order{" +
                "user=" + user +
                ", restaurant=" + restaurant +
                ", deliveryMan=" + deliveryMan +
                ", food=" + food +
                ", beverage=" + beverage +
                '}';
    }



}
