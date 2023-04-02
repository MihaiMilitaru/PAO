import models.*;
import services.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Declare an empty map for users and deliverymen
        Map<Integer, User> users = new HashMap<>();
        Map <Integer, DeliveryMan> deliveryMen = new HashMap<>();
        Map <Integer, Restaurant> restaurants = new HashMap<>();
        Map <Integer, Food> foods = new HashMap<>();
        Map <Integer, Beverage> beverages = new HashMap<>();
        ArrayList <Order> orders = new ArrayList<>();

        // Array of history representing strings
        String[] history = new String[500];

        int index_user = 0;
        int index_deliveryman = 0;
        int index_history = 0;
        int index_order = 0;
        int index_food = 0;
        int index_beverage = 0;

        // Make a crud service for users and deliverymen
        int choice = 0;
        System.out.println("Welcome to the delivery app");

        UserService userService = new UserService();
        DeliveryManService deliveryManService = new DeliveryManService();
        FoodService foodService = new FoodService();
        BeverageService beverageService = new BeverageService();
        RestaurantServices restaurantServices = new RestaurantServices();
        OrderService orderService = new OrderService();

        while (choice != 27) {
            System.out.println("Please select an option:");
            System.out.println("1. Add a user");
            System.out.println("2. List users");
            System.out.println("3. Update user email");
            System.out.println("4. Delete user");
            System.out.println("5. Add a deliveryman");
            System.out.println("6. List deliverymen");
            System.out.println("7. Update deliveryman salary");
            System.out.println("8. Delete deliveryman");
            System.out.println("9. Add food");
            System.out.println("10. Add beverage");
            System.out.println("11. List food");
            System.out.println("12. List beverages");
            System.out.println("13. Update food price");
            System.out.println("14. Update beverage price");
            System.out.println("15. Delete food");
            System.out.println("16. Delete beverage");
            System.out.println("17. List restaurants");
            System.out.println("18. Add restaurant");
            System.out.println("19. Update restaurant address");
            System.out.println("20. Delete restaurant");
            System.out.println("21. Add order");
            System.out.println("22. List orders by client");
            System.out.println("23. List orders by restaurant");
            System.out.println("24. List orders by deliveryman");
            System.out.println("25. List all orders by price");
            System.out.println("26. Remove order");
            System.out.println("27. Exit");





            choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character


            switch (choice) {
                case 1:
                    userService.addUser(users, scanner, index_user);
                    index_user++;
                    history[index_history] = "User added";
                    index_history++;
                    break;
                case 2:
                    userService.listUsers(users);
                    history[index_history] = "Users listed";
                    index_history++;
                    break;

                case 3:
                    userService.updateUserEmail(users, scanner);
                    history[index_history] = "User email updated";
                    index_history++;
                    break;

                case 4:
                    userService.deleteUser(users, scanner);
                    history[index_history] = "User deleted";
                    index_history++;
                    break;

                case 5:
                    deliveryManService.addDeliveryMan(deliveryMen, scanner, index_deliveryman);
                    history[index_history] = "Deliveryman added";
                    index_history++;
                    index_deliveryman++;
                    break;

                case 6:
                    deliveryManService.listDeliveryMen(deliveryMen);
                    history[index_history] = "Deliverymen listed";
                    index_history++;
                    break;

                case 7:
                    deliveryManService.updateDeliveryManSalary(deliveryMen, scanner);
                    history[index_history] = "Deliveryman salary updated";
                    index_history++;
                    break;

                case 8:
                    deliveryManService.deleteDeliveryMan(deliveryMen, scanner);
                    history[index_history] = "Deliveryman deleted";
                    index_history++;
                    break;

                case 9:
                    foodService.addFood(foods, scanner, index_food);
                    history[index_history] = "Food added";
                    index_history++;
                    index_food++;
                    break;

                case 10:
                    beverageService.addBeverage(beverages, scanner, index_beverage);
                    history[index_history] = "Beverage added";
                    index_history++;
                    index_beverage++;
                    break;

                case 11:
                    foodService.listFood(foods);
                    history[index_history] = "Foods listed";
                    index_history++;
                    break;


                case 12:
                    beverageService.listBeverages(beverages);
                    history[index_history] = "Beverages listed";
                    index_history++;
                    break;


                case 13:
                    foodService.updateFoodPrice(foods, scanner);
                    history[index_history] = "Food price updated";
                    index_history++;
                    break;

                case 14:
                    beverageService.updateBeveragePrice(beverages, scanner);
                    history[index_history] = "Beverage price updated";
                    index_history++;
                    break;

                case 15:
                    foodService.deleteFood(foods, scanner);
                    history[index_history] = "Food deleted";
                    index_history++;
                    break;

                case 16:
                    beverageService.deleteBeverage(beverages, scanner);
                    history[index_history] = "Beverage deleted";
                    index_history++;
                    break;


                case 17:
                    restaurantServices.listRestaurants(restaurants);
                    history[index_history] = "Restaurants listed";
                    index_history++;
                    break;


                case 18:
                    restaurantServices.addRestaurant(restaurants, scanner, index_user);
                    history[index_history] = "Restaurant added";
                    index_history++;
                    index_user++;
                    break;

                case 19:
                    restaurantServices.updateRestaurantAddress(restaurants, scanner);
                    history[index_history] = "Restaurant address updated";
                    index_history++;
                    break;

                case 20:
                    restaurantServices.deleteRestaurant(restaurants, scanner);
                    history[index_history] = "Restaurant deleted";
                    index_history++;
                    break;


                case 21:
                    orderService.addOrder(users, deliveryMen, restaurants, foods, beverages, orders, scanner, index_order);
                    history[index_history] = "Order added";
                    index_history++;
                    index_order++;
                    break;

                case 22:
                    orderService.listOrdersUser(users, orders, scanner);
                    history[index_history] = "Orders listed by client";
                    index_history++;
                    break;


                case 23:
                    orderService.listOrdersRestaurant(restaurants, orders, scanner);
                    history[index_history] = "Orders listed by restaurant";
                    index_history++;
                    break;

                case 24:
                    orderService.listOrdersDeliveryman(deliveryMen, orders, scanner);
                    history[index_history] = "Orders listed by deliveryman";
                    index_history++;
                    break;

                case 25:
                    orderService.listOrdersByPrice(orders);
                    history[index_history] = "Orders listed by price";
                    index_history++;
                    break;
                case 26:
                    orderService.deleteOrder(orders, scanner);
                    history[index_history] = "Order deleted";
                    index_history++;
                    break;

                case 27:
                    System.out.println("Thank you for using our app!");
                    System.exit(0);
                    break;
            }

        }
    }
}