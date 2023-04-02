package services;
import models.User;

import java.util.Map;
import java.util.Scanner;
public class UserService {

    public UserService() {
    }

    public void deleteUser(Map<Integer, User> users, Scanner scanner) {
        System.out.println("Enter the id of the user you want to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        users.remove(id);
        System.out.println("User deleted successfully");
    }

    public void updateUserEmail(Map<Integer, User> users, Scanner scanner) {
        System.out.println("Existing users:");
        for (Map.Entry<Integer, User> entry : users.entrySet()) {
            System.out.println(entry.getValue());
        }

        System.out.println("Enter the id of the user you want to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        User user = users.get(id);
        System.out.println("Enter the new email: ");
        String email = scanner.nextLine();
        user.setEmail(email);
        System.out.println("User updated successfully");

    }

    public void addUser(Map<Integer, User> users, Scanner scanner, int index) {
        System.out.println("Enter the name: ");
        String name = scanner.nextLine();
        System.out.println("Enter the email: ");
        String email = scanner.nextLine();
        System.out.println("Enter the phone: ");
        String phone = scanner.nextLine();
        System.out.println("Enter the age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the address: ");
        String address = scanner.nextLine();
        User user = new User(name, email, phone, age, address);
        user.setId(index);
        users.put(user.getId(), user);
        System.out.println("User added successfully");
    }

    public void listUsers(Map<Integer, User> users) {
        System.out.println("Existing users:");
        for (Map.Entry<Integer, User> entry : users.entrySet()) {
            System.out.println(entry.getValue());
        }
    }


}
