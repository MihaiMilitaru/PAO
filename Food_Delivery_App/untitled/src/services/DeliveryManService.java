package services;
import models.DeliveryMan;
import models.User;

import java.util.Map;
import java.util.Scanner;

public class DeliveryManService {

    public DeliveryManService() {
    }

    public void deleteDeliveryMan(Map<Integer, DeliveryMan> deliveryMen, Scanner scanner) {
        System.out.println("Existing deliverymen:\n");
        for (Map.Entry<Integer, DeliveryMan> entry : deliveryMen.entrySet()) {
            System.out.println(entry.getValue());
        }
        System.out.println("Enter the id of the delivery man you want to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        deliveryMen.remove(id);
        System.out.println("Delivery man deleted successfully");
    }

    public void updateDeliveryManSalary(Map<Integer, DeliveryMan> deliveryMen, Scanner scanner){
        System.out.println("Existing deliverymen:\n");
        for (Map.Entry<Integer, DeliveryMan> entry : deliveryMen.entrySet()) {
            System.out.println(entry.getValue());
        }
        System.out.println("Please enter the id of the deliveryman.");
        int id = scanner.nextInt();
        scanner.nextLine();
        DeliveryMan deliveryMan = deliveryMen.get(id);
        System.out.println("Enter the new salary: ");
        float salary = scanner.nextFloat();
        scanner.nextLine();
        deliveryMan.setSalary(salary);

    }

    public void addDeliveryMan(Map<Integer, DeliveryMan> deliveryMen, Scanner scanner, int index){
        System.out.println("Enter the name: ");
        String name = scanner.nextLine();
        System.out.println("Enter the email: ");
        String email = scanner.nextLine();
        System.out.println("Enter the phone: ");
        String phone = scanner.nextLine();
        System.out.println("Enter the age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the salary: ");
        float salary = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("Enter the rating: ");
        float rating = scanner.nextFloat();
        scanner.nextLine();
        DeliveryMan deliveryMan = new DeliveryMan(name, email, phone, age, salary, rating);
        deliveryMan.setId(index);
        deliveryMen.put(deliveryMan.getId(), deliveryMan);
        System.out.println("DeliveryMan added successfully");
    }

    public void listDeliveryMen(Map<Integer, DeliveryMan> deliverymen) {
        System.out.println("Existing deliverymen:");
        for (Map.Entry<Integer, DeliveryMan> entry : deliverymen.entrySet()) {
            System.out.println(entry.getValue());
        }
    }



}
