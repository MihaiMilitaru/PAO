package services;

import models.Food;

import java.util.Map;
import java.util.Scanner;
public class FoodService {

    public FoodService() {

    }

    public void addFood(Map<Integer, Food> foodMap, Scanner scanner, int index) {
        System.out.println("Enter the name: ");
        String name = scanner.nextLine();
        System.out.println("Enter the price: ");
        float price = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("Enter the description: ");
        String description = scanner.nextLine();
        System.out.println("Enter the weight: ");
        float weight = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("Enter the preparation time (minutes): ");
        int preparationTime = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the category: ");
        System.out.println("1. Vegetarian");
        System.out.println("2. Non-Vegetarian");
        int category = scanner.nextInt();
        scanner.nextLine();
        while(category != 1 && category != 2) {
            System.out.println("Invalid category. Please enter a valid category: ");
            category = scanner.nextInt();
            scanner.nextLine();
        }
        if(category == 1) {
            Food food = new Food(name, description, price, true, weight, preparationTime);
            food.setId(index);
            foodMap.put(food.getId(), food);
            System.out.println("Food added successfully");
        } else {
            Food food = new Food(name, description, price, false, weight, preparationTime);
            food.setId(index);
            foodMap.put(food.getId(), food);
            System.out.println("Food added successfully");
        }


    }

    public void deleteFood(Map<Integer, Food> foodMap, Scanner scanner) {
        System.out.println("Existing food:\n");
        for (Map.Entry<Integer, Food> entry : foodMap.entrySet()) {
            System.out.println(entry.getValue());
        }
        System.out.println("Enter the id of the food you want to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        foodMap.remove(id);
        System.out.println("Food deleted successfully");
    }

    public void updateFoodPrice(Map<Integer, Food> foodMap, Scanner scanner){
        System.out.println("Existing food:\n");
        for (Map.Entry<Integer, Food> entry : foodMap.entrySet()) {
            System.out.println(entry.getValue());
        }
        System.out.println("Please enter the id of the food.");
        int id = scanner.nextInt();
        scanner.nextLine();
        Food food = foodMap.get(id);
        System.out.println("Enter the new price: ");
        float price = scanner.nextFloat();
        scanner.nextLine();
        food.setPrice(price);
        System.out.println("Food price updated successfully");
    }

    public void listFood(Map<Integer, Food> foodMap) {
        System.out.println("Existing food:\n");
        for (Map.Entry<Integer, Food> entry : foodMap.entrySet()) {
            System.out.println(entry.getValue());
        }
    }


}
