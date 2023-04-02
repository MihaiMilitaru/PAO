package services;

import models.*;

import java.util.*;

public class OrderService {

    public OrderService() {
    }


    // get all order from a user
    public void listOrdersUser(Map<Integer, User> users, List<Order> orders, Scanner scanner) {
        System.out.println("Existing users:");
        for (Map.Entry<Integer, User> entry : users.entrySet()) {
            // print them like id - name
            System.out.println(entry.getKey() + " - " + entry.getValue().getName());

        }
        System.out.println("Enter the id of the user you want to see the orders: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        User user = users.get(id);
        for (Order order : orders) {
            if (order.getUser().getId() == user.getId()) {
                System.out.println(order);
                float total = order.getFood().getPrice() + order.getBeverage().getPrice();
                System.out.println("Total: " + total);
            }
        }
    }



    // get all order from a restaurant

    public void listOrdersRestaurant(Map<Integer, Restaurant> restuarants, List<Order> orders, Scanner scanner) {
        System.out.println("Existing restaurants:");
        for (Map.Entry<Integer, Restaurant> entry : restuarants.entrySet()) {
            // print them like id - name
            System.out.println(entry.getKey() + " - " + entry.getValue().getName());

        }
        System.out.println("Enter the id of the restaurant you want to see the orders: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Restaurant restaurant = restuarants.get(id);
        for (Order order : orders) {
            if (order.getUser().getId() == restaurant.getId()) {
                System.out.println(order);
                float total = order.getFood().getPrice() + order.getBeverage().getPrice();
                System.out.println("Total: " + total);
            }
        }
    }

    // get all order from a deliveryman

    public void listOrdersDeliveryman(Map<Integer, DeliveryMan> deliverymen, List<Order> orders, Scanner scanner) {
        System.out.println("Existing deliverymen:");
        for (Map.Entry<Integer, DeliveryMan> entry : deliverymen.entrySet()) {
            // print them like id - name
            System.out.println(entry.getKey() + " - " + entry.getValue().getName());

        }
        System.out.println("Enter the id of the deliveryman you want to see the orders: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        DeliveryMan deliveryMan = deliverymen.get(id);
        for (Order order : orders) {
            if (order.getUser().getId() == deliveryMan.getId()) {
                System.out.println(order);
                float total = order.getFood().getPrice() + order.getBeverage().getPrice();
                System.out.println("Total: " + total);
            }
        }
    }

    // make a new order where you can read the user, restaurant, deliveryman, food and beverage
    // before any of these atributes print the existing ones

    public void addOrder(Map<Integer, User> users, Map<Integer, DeliveryMan> deliverymen, Map<Integer, Restaurant> restaurants, Map<Integer, Food> foods, Map<Integer, Beverage> beverages, List<Order> orders, Scanner scanner, int idOrder) {
        System.out.println("Existing users:");
        for (Map.Entry<Integer, User> entry : users.entrySet()) {
            // print them like id - name
            System.out.println(entry.getKey() + " - " + entry.getValue().getName());

        }
        System.out.println("Enter the id of the user: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        User user = users.get(id);


        System.out.println("Exsiting deliverymen: ");
        for (Map.Entry<Integer, DeliveryMan> entry : deliverymen.entrySet()) {
            // print them like id - name
            System.out.println(entry.getKey() + " - " + entry.getValue().getName());

        }
        System.out.println("Enter the id of the deliveryman: ");
        int idDeliveryman = scanner.nextInt();
        scanner.nextLine();
        DeliveryMan deliveryMan = deliverymen.get(idDeliveryman);


        System.out.println("Existing restaurants:");
        for (Map.Entry<Integer, Restaurant> entry : restaurants.entrySet()) {
            // print them like id - name
            System.out.println(entry.getKey() + " - " + entry.getValue().getName());

        }
        System.out.println("Enter the id of the restaurant: ");
        int idRestaurant = scanner.nextInt();
        scanner.nextLine();
        Restaurant restaurant = restaurants.get(idRestaurant);


        System.out.println("Existing foods:");
        for (Map.Entry<Integer, Food> entry : foods.entrySet()) {
            // print them like id - name
            System.out.println(entry.getKey() + " - " + entry.getValue().getName());

        }
        System.out.println("Enter the id of the food: ");
        int idFood = scanner.nextInt();
        scanner.nextLine();
        Food food = foods.get(idFood);


        System.out.println("Existing beverages:");
        for (Map.Entry<Integer, Beverage> entry : beverages.entrySet()) {
            // print them like id - name
            System.out.println(entry.getKey() + " - " + entry.getValue().getName());

        }
        System.out.println("Enter the id of the beverage: ");
        int idBeverage = scanner.nextInt();
        scanner.nextLine();
        Beverage beverage = beverages.get(idBeverage);

        Order order = new Order(user, restaurant, deliveryMan, food, beverage);

        order.setId(idOrder);

        orders.add(order);

        System.out.println("Order added successfully!");



    }

    // delete an order by id

    public void deleteOrder(List<Order> orders, Scanner scanner) {
        System.out.println("Enter the id of the order you want to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        for (Order order : orders) {
            if (order.getId() == id) {
                orders.remove(order);
                System.out.println("Order deleted successfully!");
                break;
            }
        }
    }

    // list all orders by price

    public void listOrdersByPrice(List<Order> orders) {
        Collections.sort(orders, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                float total1 = o1.getFood().getPrice() + o1.getBeverage().getPrice();
                float total2 = o2.getFood().getPrice() + o2.getBeverage().getPrice();
                return Float.compare(total1, total2);
            }
        });
        for (Order order : orders) {
            System.out.println(order);
            float total = order.getFood().getPrice() + order.getBeverage().getPrice();
            System.out.println("Total: " + total);
        }

    }


}
