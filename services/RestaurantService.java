package services;

import models.Restaurant;

import java.util.Map;
import java.util.Scanner;
import repository.RestaurantRepository;

public class RestaurantService {
    private RestaurantRepository restaurantRepository;

    public RestaurantService() {
        this.restaurantRepository = new RestaurantRepository();
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurantRepository.addRestaurant(restaurant);
        System.out.println("The restaurant was added successfully.");
    }

    public void updateRestaurant(Map<Integer, Restaurant> restaurants, Scanner scanner) {
        if (restaurants.isEmpty()) {
            System.out.println("There are no restaurants in the database.");
            return;
        }else{
            System.out.println("Existing restaurants:");
            for (Map.Entry<Integer, Restaurant> me : restaurants.entrySet()) {
                System.out.println(me.getKey() + ". " + me.getValue().getName() + " (rating: " + me.getValue().getRating() + ")");
            }
            System.out.println("Please enter the id of the restaurant.");
            String restaurantid = scanner.nextLine();
            System.out.println("Please enter the new address.");
            String address = scanner.nextLine();
            Restaurant restaurant = restaurants.get(Integer.parseInt(restaurantid));
            restaurantRepository.updateAddress(restaurant, address);
            System.out.println("The address was updated successfully.");
        }

    }

    public void deleteRestaurant(Map<Integer, Restaurant> restaurants, Scanner scanner) {
        if (restaurants.isEmpty()) {
            System.out.println("There are no restaurants in the database.");
            return;
        }else{
            System.out.println("Existing restaurants:");
            for (Map.Entry<Integer, Restaurant> me : restaurants.entrySet()) {
                System.out.println(me.getKey() + ". " + me.getValue().getName() + " (rating: " + me.getValue().getRating() + ")");
            }
            System.out.println("Please enter the id of the restaurant.");
            String restaurantid = scanner.nextLine();
            Restaurant restaurant = restaurants.get(Integer.parseInt(restaurantid));
            restaurantRepository.deleteRestaurant(restaurant);
            System.out.println("The restaurant was deleted successfully.");
        }

    }


    public Restaurant  buildRestaurant(Scanner scanner) {
        System.out.println("Enter the name: ");
        String name = scanner.nextLine();
        System.out.println("Enter the address: ");
        String address = scanner.nextLine();
        System.out.println("Enter the rating: ");
        float rating = scanner.nextFloat();
        scanner.nextLine();

        Restaurant restaurant = new Restaurant(name, address, rating);

        return restaurant;

    }

    public Map<Integer, Restaurant> getAllRestaurants() {
        return restaurantRepository.getAllRestaurants();
    }



}
