package services;

import models.Beverage;

import java.util.Map;
import java.util.Scanner;
import repository.BeverageRepository;

public class BeverageService {

    private BeverageRepository beverageRepository;

    public BeverageService() {
        this.beverageRepository = new BeverageRepository();
    }

    public void deleteBeverage(Map<Integer, Beverage> beverages, Scanner scanner) {
        if (beverages.isEmpty()) {
            System.out.println("There are no beverages available.");
            return;
        }else{
            System.out.println("Beverages available:");
            for (Map.Entry<Integer, Beverage> me : beverages.entrySet()) {
                System.out.println(me.getKey() + ". " + me.getValue());
            }
            System.out.println("Please enter the id of the beverage.");
            String beverageid = scanner.nextLine();
            Beverage beverage = beverages.get(Integer.parseInt(beverageid));
            beverageRepository.deleteBeverage(beverage);
            System.out.println("The beverage was deleted successfully.");

        }

    }


    public void updateBeverage(Map<Integer, Beverage> beverages, Scanner scanner) {
        if (beverages.isEmpty()) {
            System.out.println("There are no beverages available.");
            return;
        }else{
            System.out.println("Beverages available:");
            for (Map.Entry<Integer, Beverage> me : beverages.entrySet()) {
                System.out.println(me.getKey() + ". " + me.getValue());
            }
            System.out.println("Please enter the id of the beverage.");
            String beverageid = scanner.nextLine();
            System.out.println("Please enter the new price.");
            Float price = Float.parseFloat(scanner.nextLine());
            Beverage beverage = beverages.get(Integer.parseInt(beverageid));
            beverageRepository.updatePrice(beverage, price);
            System.out.println("The price was updated successfully.");
        }

    }


    public Beverage buildBeverage(Scanner scanner) {
        Beverage bev = new Beverage();


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
            bev.setName(name);
            bev.setDescription(description);
            bev.setPrice(price);
            bev.setVolume(quantity);
            bev.setIsAlcoholic(true);

        } else {
            bev.setName(name);
            bev.setDescription(description);
            bev.setPrice(price);
            bev.setVolume(quantity);
            bev.setIsAlcoholic(false);


        }
        return bev;

    }

    public void addBeverage(Beverage beverage) {
        beverageRepository.addBeverage(beverage);
        System.out.println("The beverage was added successfully.");
    }

    public Map<Integer, Beverage> getAllBeverages() {
        return beverageRepository.getAllBeverages();
    }


}
