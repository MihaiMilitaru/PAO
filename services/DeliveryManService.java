package services;
import models.DeliveryMan;
import models.User;
import repository.DeliveryManRepository;

import java.util.Map;
import java.util.Scanner;

public class DeliveryManService {
    private DeliveryManRepository deliverymanRepository;

    public DeliveryManService() {
        this.deliverymanRepository = new DeliveryManRepository();
    }

    public void addDeliveryMan(DeliveryMan deliveryMan) {
        deliverymanRepository.addDeliveryMan(deliveryMan);
        System.out.println("The deliveryman was added successfully.");
    }

    public void deleteDeliveryMan(Map<Integer, DeliveryMan> deliverymen, Scanner scanner) {
        if (deliverymen.isEmpty()) {
            System.out.println("There are no deliverymen to delete.");
            return;
        }else{
            System.out.println("Existing deliverymen:");
            for (Map.Entry<Integer, DeliveryMan> me : deliverymen.entrySet()) {
                System.out.println(me.getKey() + ". " + me.getValue().getName());
            }
            System.out.println("Please enter the id of the deliveryman.");
            String driverid = scanner.nextLine();
            DeliveryMan driver = deliverymen.get(Integer.parseInt(driverid));
            deliverymanRepository.deleteDriver(driver);
            System.out.println("The deliveryman was deleted successfully.");
        }

    }

    public void updateDeliveryMan(Map<Integer, DeliveryMan> deliverymen, Scanner scanner) {
        if (deliverymen.isEmpty()) {
            System.out.println("There are no deliverymen to update.");
            return;
        }else{
            System.out.println("Existing deliverymen:");
            for (Map.Entry<Integer, DeliveryMan> me : deliverymen.entrySet()) {
                System.out.println(me.getKey() + ". " + me.getValue().getName());
            }
            System.out.println("Please enter the id of the deliveryman.");
            String driverid = scanner.nextLine();
            System.out.println("Please enter the new salary.");
            String phoneNumber = scanner.nextLine();
            DeliveryMan driver = deliverymen.get(Integer.parseInt(driverid));
            deliverymanRepository.updateSalary(driver, phoneNumber);
            System.out.println("The salary was updated successfully.");
        }

    }


    public DeliveryMan buildDeliveryMan(Scanner scanner) {
        DeliveryMan deliveryMan = new DeliveryMan();

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
        deliveryMan.setName(name);
        deliveryMan.setEmail(email);
        deliveryMan.setPhone(phone);
        deliveryMan.setAge(age);
        deliveryMan.setSalary(salary);
        deliveryMan.setRating(rating);

        return deliveryMan;

    }

    public Map<Integer, DeliveryMan> getAllDeliveryMen() {
        return deliverymanRepository.getAllDeliveryMen();
    }




}
