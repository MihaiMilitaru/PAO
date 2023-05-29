package services;

import models.*;

import java.util.*;

import repository.OrderRepository;

public class OrderService {

    private OrderRepository orderRepository;

    public OrderService() {
        this.orderRepository = new OrderRepository();
    }

    public void addOrder(Order order) {
        orderRepository.addOrder(order);
        System.out.println("The order was placed successfully.");
    }

    public ArrayList<Order> getAllOrders(Map<Integer, User> users, Map<Integer, DeliveryMan> deliverymen, Map<Integer, Restaurant> restaurants, Map<Integer, Food> foods, Map<Integer, Beverage> beverages) {
        return orderRepository.getAllOrders(users, deliverymen, restaurants, foods, beverages);
    }

    public void deleteOrder(ArrayList <Order> orders, Scanner scanner) {
        if(orders.size() == 0){
            System.out.println("There are no orders to delete.");
            return;
        }else{
            System.out.println("Existing orders:");
            for(Order ord: orders){
                System.out.println(ord.getId() + ". " + ord.getRestaurant().getName() + "  " + ord.getUser().getName() + "  " + ord.getFood().getName()
                        + "  " + ord.getBeverage().getName() + "  " + ord.getDeliveryMan().getName());

            }

            System.out.println("Please enter the id of the order.");
            int orderid = scanner.nextInt();
            try{
                Order del_order = null;
                for (Order ord: orders){
                    if (ord.getId() == orderid){
                        del_order = ord;
                    }
                }
                orderRepository.deleteOrder(del_order);
                System.out.println("The order was deleted successfully.");

            }catch(Exception e){
                System.out.println("The order does not exist.");
            }


        }

    }

    public void getAllOrdersByRestaurant(Scanner scanner, Map<Integer, User> users, Map<Integer, DeliveryMan> deliverymen, Map<Integer, Restaurant> restaurants, Map<Integer, Food> foods, Map<Integer, Beverage> beverages) {
        if(restaurants.size() == 0){
            System.out.println("There are no restaurants to show.");
            return;
        }else{
            System.out.println("Existing restaurants:");
            for (Map.Entry<Integer, Restaurant> me : restaurants.entrySet()) {
                System.out.println(me.getKey() + ". " + me.getValue().getName() + " (rating: " + me.getValue().getRating() + ")");
            }
            System.out.println("Please enter the id of the restaurant.");
            String restaurantid = scanner.nextLine();
            orderRepository.getAllOrdersByRestaurant(Integer.parseInt(restaurantid), users, deliverymen, restaurants, foods, beverages);

        }

    }

    public void getAllOrdersByUser(Scanner scanner, Map<Integer, User> users, Map<Integer, DeliveryMan> deliverymen, Map<Integer, Restaurant> restaurants, Map<Integer, Food> foods, Map<Integer, Beverage> beverages) {
        if (users.size() == 0) {
            System.out.println("There are no users to show.");
            return;
        }else{
            System.out.println("Existing users:");
            for (Map.Entry<Integer, User> me : users.entrySet()) {
                System.out.println(me.getKey() + ". " + me.getValue().getName());
            }
            System.out.println("Please enter the id of the user.");
            String userid = scanner.nextLine();
            orderRepository.getAllOrdersByUser(Integer.parseInt(userid), users, deliverymen, restaurants, foods, beverages);
        }

    }

    public void getAllOrdersByDeliveryMan(Scanner scanner, Map<Integer, User> users, Map<Integer, DeliveryMan> deliverymen, Map<Integer, Restaurant> restaurants, Map<Integer, Food> foods, Map<Integer, Beverage> beverages) {
        if (deliverymen.size() == 0) {
            System.out.println("There are no drivers to show.");
            return;
        }else{
            System.out.println("Existing drivers:");
            for (Map.Entry<Integer, DeliveryMan> me : deliverymen.entrySet()) {
                System.out.println(me.getKey() + ". " + me.getValue().getName());
            }
            System.out.println("Please enter the id of the driver.");
            String driverid = scanner.nextLine();
            orderRepository.getAllOrdersByDeliveryMan(Integer.parseInt(driverid), users, deliverymen, restaurants, foods, beverages);
        }

    }

    public Order buildOrder(Scanner scanner, Map<Integer, User> users, Map<Integer, DeliveryMan> deliverymen, Map<Integer, Restaurant> restaurants, Map<Integer, Food> foods, Map<Integer, Beverage> beverages) {

        Order order = new Order();

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

        order.setUser(user);
        order.setDeliveryMan(deliveryMan);
        order.setRestaurant(restaurant);
        order.setFood(food);
        order.setBeverage(beverage);

        return order;


    }

}
