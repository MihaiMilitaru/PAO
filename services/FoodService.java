package services;

import models.Food;
import repository.FoodRepository;

import java.util.Map;
import java.util.Scanner;
public class FoodService {
    private FoodRepository foodRepository;

    public FoodService() {
        this.foodRepository = new FoodRepository();
    }

    public void addFood(Food food) {
        foodRepository.addFood(food);
        System.out.println("The food was added successfully.");
    }

    public Food buildFood(Scanner scanner){
        Food food = new Food();

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
            food.setName(name);
            food.setPrice(price);
            food.setDescription(description);
            food.setIsVegetarian(true);
            food.setWeight(weight);
            food.setPreparationTime(preparationTime);
        } else {
           food.setName(name);
           food.setPrice(price);
           food.setDescription(description);
           food.setIsVegetarian(false);
           food.setWeight(weight);
           food.setPreparationTime(preparationTime);

        }
        return food;
    }

    public void deleteFood(Map<Integer, Food> food, Scanner scanner) {
        if (food.isEmpty()) {
            System.out.println("There are no foods available.");
            return;
        }else{
            System.out.println("Food available:");
            for (Map.Entry<Integer, Food> me : food.entrySet()) {
                System.out.println(me.getKey() + ". " + me.getValue());
            }
            System.out.println("Please enter the id of the food.");
            String foodid = scanner.nextLine();
            Food foodaux = food.get(Integer.parseInt(foodid));
            foodRepository.deleteFood(foodaux);
            System.out.println("The food was deleted successfully.");
        }

    }

    public void updateFood(Map<Integer, Food> food, Scanner scanner) {
        if (food.isEmpty()) {
            System.out.println("There are no foods available.");
            return;
        }else{
            System.out.println("Food available:");
            for (Map.Entry<Integer, Food> me : food.entrySet()) {
                System.out.println(me.getKey() + ". " + me.getValue());
            }
            System.out.println("Please enter the id of the food.");
            String foodid = scanner.nextLine();
            System.out.println("Please enter the new price.");
            Float price = Float.parseFloat(scanner.nextLine());
            Food foodaux = food.get(Integer.parseInt(foodid));
            foodRepository.updatePrice(foodaux, price);
            System.out.println("The price was updated successfully.");
        }

    }

    public Map<Integer, Food> getAllFood() {
        return foodRepository.getAllFood();
    }




}
