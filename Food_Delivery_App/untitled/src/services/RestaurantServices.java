package services;

import models.Beverage;
import models.Restaurant;

import java.util.Map;
import java.util.Scanner;

public class RestaurantServices {

    public RestaurantServices() {
    }

    public void deleteRestaurant(Map<Integer, Restaurant> restaurants, Scanner scanner){
        System.out.println("Enter the id of the restaurant you want to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        restaurants.remove(id);
        System.out.println("Restaurant deleted successfully");

    }

    public void updateRestaurantAddress(Map<Integer, Restaurant> restaurants, Scanner scanner){
        System.out.println("Existing restaurants:");
        for (Map.Entry<Integer, Restaurant> entry : restaurants.entrySet()) {
            System.out.println(entry.getValue());
        }

        System.out.println("Enter the id of the restaurant you want to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Restaurant restaurant = restaurants.get(id);
        System.out.println("Enter the new address: ");
        String address = scanner.nextLine();
        restaurant.setAddress(address);
        System.out.println("Restaurant updated successfully");

    }

    public void addRestaurant(Map<Integer, Restaurant> restaurants, Scanner scanner, int index){
        System.out.println("Enter the name: ");
        String name = scanner.nextLine();
        System.out.println("Enter the address: ");
        String address = scanner.nextLine();
        System.out.println("Enter the rating: ");
        float rating = scanner.nextFloat();
        scanner.nextLine();
        Restaurant restaurant = new Restaurant(name, address, rating);
        restaurant.setId(index);
        restaurants.put(restaurant.getId(), restaurant);
        System.out.println("Restaurant added successfully");

    }

    public void listRestaurants(Map<Integer, Restaurant> restaurants){
        System.out.println("Existing restaurants:");
        for (Map.Entry<Integer, Restaurant> entry : restaurants.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
