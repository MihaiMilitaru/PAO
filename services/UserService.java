package services;
import models.User;

import java.util.Map;
import java.util.Scanner;
import repository.UserRepository;
public class UserService {
    private UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository();
    }

    public void addUser(User user) {
        userRepository.addUser(user);
    }

    public void deleteUser(Map<Integer, User> users, Scanner scanner) {
        if (users.isEmpty()) {
            System.out.println("There are no users to delete.");
            return;
        }else{
            System.out.println("Existing users:");
            for (Map.Entry<Integer, User> me : users.entrySet()) {
                System.out.println(me.getKey() + ". " + me.getValue().getName());
            }
            System.out.println("Please enter the id of the user.");
            String userid = scanner.nextLine();
            User user = users.get(Integer.parseInt(userid));
            userRepository.deleteUser(user);
            System.out.println("The user was deleted successfully.");
        }

    }

    public void updateUser(Map<Integer, User> users, Scanner scanner) {
        if (users.isEmpty()) {
            System.out.println("There are no users to update.");
            return;
        }else{
            System.out.println("Existing users:");
            for (Map.Entry<Integer, User> me : users.entrySet()) {
                System.out.println(me.getKey() + ". " + me.getValue().getName());
            }
            System.out.println("Please enter the id of the user.");
            String userid = scanner.nextLine();
            System.out.println("Please enter the new email.");
            String email = scanner.nextLine();
            User user = users.get(Integer.parseInt(userid));
            userRepository.updateEmail(user, email);
            System.out.println("The email was updated successfully.");
        }

    }

    public User buildUser(Scanner scanner) {

        User user = new User();

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

        user.setName(name);
        user.setEmail(email);
        user.setPhone(phone);
        user.setAge(age);
        user.setAddress(address);

        return user;

    }

    public Map<Integer, User> getAllUsers() {
        return userRepository.getAllUsers();
    }



}
