package services;

import models.Beverage;

import java.util.Map;
import java.util.Scanner;

public class BeverageService {

    public BeverageService() {
    }

    public void deleteBeverage(Map<Integer, Beverage> beverages, Scanner scanner) {
        System.out.println("Enter the id of the beverage you want to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        beverages.remove(id);
        System.out.println("Beverage deleted successfully");
    }

    public void updateBeveragePrice(Map<Integer, Beverage> beverages, Scanner scanner) {
        System.out.println("Existing beverages:");
        for (Map.Entry<Integer, Beverage> entry : beverages.entrySet()) {
            System.out.println(entry.getValue());
        }

        System.out.println("Enter the id of the beverage you want to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Beverage beverage = beverages.get(id);
        System.out.println("Enter the new price: ");
        float price = scanner.nextFloat();
        scanner.nextLine();
        beverage.setPrice(price);
        System.out.println("Beverage updated successfully");

    }

    public void addBeverage(Map<Integer, Beverage> beverages, Scanner scanner, int index) {
        System.out.println("Enter the name: ");
        String name = scanner.nextLine();
        System.out.println("Enter the description: ");
        String description = scanner.nextLine();
        System.out.println("Enter the price: ");
        float price = scanner.nextFloat();
        scanner.nextLine();

        System.out.println("Enter the quantity: ");
        float quantity = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("Enter the type: ");
        System.out.println("1. Alcoholic");
        System.out.println("2. Non-alcoholic");
        int type = scanner.nextInt();
        scanner.nextLine();
        while(type != 1 && type != 2) {
            System.out.println("Invalid type. Please enter 1 or 2");
            type = scanner.nextInt();
            scanner.nextLine();
        }
        if(type == 1) {
            Beverage beverage = new Beverage(name, description, price, quantity, true);
            beverage.setId(index);
            beverages.put(beverage.getId(), beverage);
        } else {
            Beverage beverage = new Beverage(name, description, price, quantity, false);
            beverage.setId(index);
            beverages.put(beverage.getId(), beverage);
        }




        System.out.println("Beverage added successfully");
    }

    public void listBeverages(Map<Integer, Beverage> beverages) {
        System.out.println("Existing beverages:");
        for (Map.Entry<Integer, Beverage> entry : beverages.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
