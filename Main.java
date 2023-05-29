import models.*;
import services.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

import config.DatabaseConnection;
import java.sql.PreparedStatement;
import services.AuditService;



public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        UserService userService = new UserService();
        DeliveryManService deliverymanService = new DeliveryManService();
        FoodService foodService = new FoodService();
        BeverageService beverageService = new BeverageService();
        RestaurantService restaurantService = new RestaurantService();
        OrderService orderService = new OrderService();
        AuditService auditService = new AuditService();
        Scanner scanner = new Scanner(System.in);

        Map<Integer, Beverage> beverages = beverageService.getAllBeverages();
        Map<Integer, Food> foods = foodService.getAllFood();
        Map<Integer, User> users = userService.getAllUsers();
        Map<Integer, DeliveryMan> deliverymen = deliverymanService.getAllDeliveryMen();
        Map<Integer, Restaurant> restaurants = restaurantService.getAllRestaurants();
        ArrayList<Order> orders = orderService.getAllOrders(users, deliverymen, restaurants, foods, beverages);
        Collections.sort(orders);

        System.out.println("WELCOME TO OUR FOOD DELIVERY APP");
        System.out.println("Please select one option");

        while(true){
            System.out.println();
            System.out.println();
            System.out.println("1. DISPLAY Menu");
            System.out.println("2. UPDATE Menu");
            System.out.println("3. CREATE Menu");
            System.out.println("4. DELETE Menu");
            System.out.println("5. EXIT");

            System.out.print("Your option is: ");
            String option = scanner.nextLine();
            switch(option) {
                case "5" : {
                    System.out.println("Thank you for visiting our app!");
                    System.exit(0);
                }

                case "4": {
                    int opt =1;
                    while (opt ==1){
                        System.out.println();
                        System.out.println();
                        System.out.println("1. Delete a user");
                        System.out.println("2. Delete a deliveryman");
                        System.out.println("3. Delete a restaurant");
                        System.out.println("4. Delete a food");
                        System.out.println("5. Delete a beverage");
                        System.out.println("6. Delete an order");
                        System.out.println("7. EXIT");

                        System.out.println("Your option is: ");
                        String option2 = scanner.nextLine();

                        switch (option2) {

                            case "1": {
                                userService.deleteUser(users, scanner);
                                auditService.addAction("Delete an user");
                                System.out.println("Press enter to continue...");
                                users = userService.getAllUsers();
                                String aux = scanner.nextLine();
                                break;

                            }

                            case "2":{
                                deliverymanService.deleteDeliveryMan(deliverymen, scanner);
                                auditService.addAction("Delete a deliveryman");
                                System.out.println("Press enter to continue...");
                                deliverymen = deliverymanService.getAllDeliveryMen();
                                String aux = scanner.nextLine();
                                break;
                            }

                            case "3":{
                                restaurantService.deleteRestaurant(restaurants, scanner);
                                auditService.addAction("Delete a restaurant");
                                System.out.println("Press enter to continue");
                                restaurants = restaurantService.getAllRestaurants();
                                String aux = scanner.nextLine();
                                break;
                            }

                            case "4": {
                                foodService.deleteFood(foods, scanner);
                                auditService.addAction("Delete a food");
                                System.out.println("Press enter to continue...");
                                foods = foodService.getAllFood();
                                String aux = scanner.nextLine();
                                break;
                            }

                            case "5": {
                                beverageService.deleteBeverage(beverages, scanner);
                                auditService.addAction("Delete a beverage");
                                System.out.println("Press enter to continue...");
                                beverages = beverageService.getAllBeverages();
                                String aux = scanner.nextLine();
                                break;
                            }

                            case "6":{
                                orderService.deleteOrder(orders, scanner);
                                auditService.addAction("Delete an order");
                                System.out.println("Press enter to continue...");
                                orders = orderService.getAllOrders(users, deliverymen, restaurants, foods, beverages);
                                String aux = scanner.nextLine();
                                break;


                            }

                            case "7": {
                                opt = 0;

                                break;
                            }


                            default: {
                                System.out.println("Invalid option!");
                                break;
                            }





                        }
                    }
                    break;
                }


                case "3" :{
                    int opt = 1;
                    while (opt ==1 ){
                        System.out.println();
                        System.out.println();
                        System.out.println("1. Add a new user");
                        System.out.println("2. Add a new deliveryman");
                        System.out.println("3. Add a new restaurant");
                        System.out.println("4. Add a new food");
                        System.out.println("5. Add a new beverage");
                        System.out.println("6. Add a new order");
                        System.out.println("7. EXIT");

                        System.out.print("Your option is: ");
                        String option2 = scanner.nextLine();

                        switch (option2) {

                            case "1": {
                                userService.addUser(userService.buildUser(scanner));
                                auditService.addAction("Add a new user");
                                users = userService.getAllUsers();
                                System.out.println("Press enter to continue...");
                                String aux = scanner.nextLine();
                                break;
                            }

                            case "2": {
                                deliverymanService.addDeliveryMan(deliverymanService.buildDeliveryMan(scanner));
                                auditService.addAction("Add a new deliveryman");
                                deliverymen = deliverymanService.getAllDeliveryMen();
                                System.out.println("Press enter to continue...");
                                String aux = scanner.nextLine();
                                break;

                            }

                            case "3": {
                                restaurantService.addRestaurant(restaurantService.buildRestaurant(scanner));
                                auditService.addAction("Add a new restaurant");
                                restaurants = restaurantService.getAllRestaurants();
                                System.out.println("Press enter to continue...");
                                String aux = scanner.nextLine();
                                break;

                            }

                            case "4": {
                                foodService.addFood(foodService.buildFood(scanner));
                                auditService.addAction("Add a new food");
                                foods = foodService.getAllFood();
                                System.out.println("Press enter to continue...");
                                String aux = scanner.nextLine();
                                break;

                            }

                            case "5": {
                                beverageService.addBeverage(beverageService.buildBeverage(scanner));
                                auditService.addAction("Add a new beverage");
                                beverages = beverageService.getAllBeverages();
                                System.out.println("Press enter to continue...");
                                String aux = scanner.nextLine();
                                break;

                            }

                            case "6": {
                                orderService.addOrder(orderService.buildOrder(scanner, users, deliverymen, restaurants, foods, beverages));
                                auditService.addAction("Add a new order");
                                orders = orderService.getAllOrders(users, deliverymen, restaurants, foods, beverages);
                                System.out.println("Press enter to continue...");
                                String aux = scanner.nextLine();
                                break;

                            }

                            case "7": {
                                opt = 0;
                                break;
                            }


                            default: {
                                System.out.println("Invalid option!");
                                break;
                            }



                        }
                    }

                    break;
                }


                case "2" : {
                    int opt = 1;
                    while (opt == 1) {
                        System.out.println();
                        System.out.println();
                        System.out.println("1. Update user email");
                        System.out.println("2. Update deliveryman salary");
                        System.out.println("3. Update restaurant address");
                        System.out.println("4. Update food price");
                        System.out.println("5. Update beverage price");
                        System.out.println("6. EXIT");

                        System.out.print("Your option is: ");
                        String option2 = scanner.nextLine();

                        switch (option2) {

                            case "1": {

                                userService.updateUser(users, scanner);
                                auditService.addAction("Update email of an user");
                                System.out.println("Press enter to continue...");
                                users = userService.getAllUsers();
                                String aux = scanner.nextLine();
                                break;
                            }

                            case "2": {

                                deliverymanService.updateDeliveryMan(deliverymen, scanner);
                                auditService.addAction("Update salary of a deliveryman");
                                System.out.println("Press enter to continue...");
                                deliverymen = deliverymanService.getAllDeliveryMen();
                                String aux = scanner.nextLine();
                                break;
                            }

                            case "3":{
                                restaurantService.updateRestaurant(restaurants, scanner);
                                auditService.addAction("Update address of a restaurant");
                                System.out.println("Press enter to continue...");
                                restaurants = restaurantService.getAllRestaurants();
                                String aux = scanner.nextLine();
                                break;

                            }

                            case "4":{
                                foodService.updateFood(foods, scanner);
                                auditService.addAction("Update price of a food");
                                System.out.println("Press enter to continue...");
                                foods = foodService.getAllFood();
                                String aux = scanner.nextLine();
                                break;

                            }

                            case "5":{
                                beverageService.updateBeverage(beverages, scanner);
                                auditService.addAction("Update price of a beverage");
                                System.out.println("Press enter to continue...");
                                beverages = beverageService.getAllBeverages();
                                String aux = scanner.nextLine();
                                break;

                            }

                            case "6": {
                                opt = 0;
                                break;
                            }

                            default: {
                                System.out.println("Invalid option!");
                                break;
                            }


                        }


                    }
                    break;

                }


                case "1" : {
                    int opt = 1;
                    while (opt == 1) {
                        System.out.println();
                        System.out.println();
                        System.out.println("1. Display all users");
                        System.out.println("2. Display all deliverymen");
                        System.out.println("3. Display all restaurants");
                        System.out.println("4. Display all foods");
                        System.out.println("5. Display all beverages");
                        System.out.println("6. Display all orders");
                        System.out.println("7. Display all orders by user");
                        System.out.println("8. Display all orders by deliveryman");
                        System.out.println("9. Display all orders by restaurant");
                        System.out.println("10. EXIT");

                        System.out.print("Your option is: ");
                        String option2 = scanner.nextLine();

                        switch (option2) {

                            case "1": {
                                for (Map.Entry<Integer, User> me : users.entrySet()) {
                                    System.out.println(me.getKey() + ". " + me.getValue());
                                }
                                auditService.addAction("Display all users");
                                System.out.println("Press enter to continue...");
                                String aux = scanner.nextLine();
                                break;
                            }

                            case "2": {
                                for (Map.Entry<Integer, DeliveryMan> me : deliverymen.entrySet()) {
                                    System.out.println(me.getKey() + ". " + me.getValue());
                                }
                                auditService.addAction("Display all deliverymen");
                                System.out.println("Press enter to continue...");
                                String aux = scanner.nextLine();
                                break;
                            }

                            case "3": {
                                for (Map.Entry<Integer, Restaurant> me : restaurants.entrySet()) {
                                    System.out.println(me.getKey() + ". " + me.getValue());
                                }
                                auditService.addAction("Display all restaurants");
                                System.out.println("Press enter to continue...");
                                String aux = scanner.nextLine();
                                break;
                            }

                            case "4": {
                                for (Map.Entry<Integer, Food> me : foods.entrySet()) {
                                    System.out.println(me.getKey() + ". " + me.getValue());
                                }
                                auditService.addAction("Display all foods");
                                System.out.println("Press enter to continue...");
                                String aux = scanner.nextLine();
                                break;
                            }

                            case "5": {
                                for (Map.Entry<Integer, Beverage> me : beverages.entrySet()) {
                                    System.out.println(me.getKey() + ". " + me.getValue());
                                }
                                auditService.addAction("Display all beverages");
                                System.out.println("Press enter to continue...");
                                String aux = scanner.nextLine();
                                break;
                            }

                            case "6": {
                                for (Order order : orders) {
                                    System.out.println(order);
                                }
                                auditService.addAction("Display all orders");
                                System.out.println("Press enter to continue...");
                                String aux = scanner.nextLine();
                                break;
                            }

                            case "7": {
                                orderService.getAllOrdersByUser(scanner, users, deliverymen, restaurants, foods, beverages);
                                auditService.addAction("Display all orders by user");
                                System.out.println("Press enter to continue...");
                                String aux = scanner.nextLine();
                                break;
                            }

                            case "8": {
                                orderService.getAllOrdersByDeliveryMan(scanner, users, deliverymen, restaurants, foods, beverages);
                                auditService.addAction("Display all orders by deliveryman");
                                System.out.println("Press enter to continue...");
                                String aux = scanner.nextLine();
                                break;
                            }

                            case "9": {
                                orderService.getAllOrdersByRestaurant(scanner, users, deliverymen, restaurants, foods, beverages);
                                auditService.addAction("Display all orders by restaurant");
                                System.out.println("Press enter to continue...");
                                String aux = scanner.nextLine();
                                break;
                            }

                            case "10": {
                                opt = 0;
                                break;
                            }

                            default: {
                                System.out.println("Invalid option!");
                                break;
                            }
                        }
                    }

                    break;
                }

            }



        }



    }
}