package repository;

import config.DatabaseConnection;
import models.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public class OrderRepository {
    public void addOrder(Order order) {

        String query = "INSERT INTO `order` VALUES (null, ";
        User user = order.getUser();
        query = query + user.getId() + ", ";
        Restaurant restaurant = order.getRestaurant();
        query = query + restaurant.getId() + ", ";
        DeliveryMan deliveryman = order.getDeliveryMan();
        query = query + deliveryman.getId() + ", ";
        Food food = order.getFood();
        if (food != null) {
            query = query + food.getId() + ", ";
        }
        else {
            query = query + "null, ";
        }
        Beverage beverage = order.getBeverage();
        if (beverage != null) {
            query = query + beverage.getId() + ");";
        }
        else {
            query = query + "null);";
        }

        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(query)) {
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public ArrayList<Order> getAllOrders(Map<Integer, User> users, Map<Integer, DeliveryMan> deliverymen, Map<Integer, Restaurant> restaurants, Map<Integer, Food> foods, Map<Integer, Beverage> beverages) {
        ArrayList<Order> orders = new ArrayList<>();
        String query = "SELECT * FROM `order`;";
        try{
            PreparedStatement preparedStatement = DatabaseConnection.getInstance().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt(1));
                order.setUser(users.get(resultSet.getInt(2)));
                order.setRestaurant(restaurants.get(resultSet.getInt(3)));
                order.setDeliveryMan(deliverymen.get(resultSet.getInt(4)));
                if (resultSet.getInt(5) != 0) {
                    order.setFood(foods.get(resultSet.getInt(5)));
                }
                if (resultSet.getInt(6) != 0) {
                    order.setBeverage(beverages.get(resultSet.getInt(6)));
                }
                orders.add(order);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }


    public void getAllOrdersByRestaurant(Integer restaurantId, Map<Integer, User> users, Map<Integer, DeliveryMan> deliverymen, Map<Integer, Restaurant> restaurants, Map<Integer, Food> foods, Map<Integer, Beverage> beverages) {
        String query = "select * from `order` where `restaurantId` = ?;";
        try{
            PreparedStatement preparedStatement = DatabaseConnection.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, restaurantId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Order order = new Order();
                Integer id = resultSet.getInt(1);
                //restaurant.setId(id);
                order.setUser(users.get(resultSet.getInt(2)));
                order.setRestaurant(restaurants.get(resultSet.getInt(3)));
                order.setDeliveryMan(deliverymen.get(resultSet.getInt(4)));
                if (resultSet.getInt(5) != 0) {
                    order.setFood(foods.get(resultSet.getInt(5)));
                }
                if (resultSet.getInt(6) != 0) {
                    order.setBeverage(beverages.get(resultSet.getInt(6)));
                }
                System.out.println(order);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void getAllOrdersByUser(Integer userId, Map<Integer, User> users, Map<Integer, DeliveryMan> deliverymen, Map<Integer, Restaurant> restaurants, Map<Integer, Food> foods, Map<Integer, Beverage> beverages) {
        String query = "select * from `order` where `userId` = ?;";
        try{
            PreparedStatement preparedStatement = DatabaseConnection.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Order order = new Order();
                Integer id = resultSet.getInt(1);
                //restaurant.setId(id);
                order.setUser(users.get(resultSet.getInt(2)));
                order.setRestaurant(restaurants.get(resultSet.getInt(3)));
                order.setDeliveryMan(deliverymen.get(resultSet.getInt(4)));
                if (resultSet.getInt(5) != 0) {
                    order.setFood(foods.get(resultSet.getInt(5)));
                }
                if (resultSet.getInt(6) != 0) {
                    order.setBeverage(beverages.get(resultSet.getInt(6)));
                }
                System.out.println(order);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAllOrdersByDeliveryMan(Integer driverId, Map<Integer, User> users, Map<Integer, DeliveryMan> deliverymen, Map<Integer, Restaurant> restaurants, Map<Integer, Food> foods, Map<Integer, Beverage> beverages) {
        String query = "select * from `order` where `deliverymanId` = ?;";
        try{
            PreparedStatement preparedStatement = DatabaseConnection.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, driverId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Order order = new Order();
                Integer id = resultSet.getInt(1);
                //restaurant.setId(id);
                order.setUser(users.get(resultSet.getInt(2)));
                order.setRestaurant(restaurants.get(resultSet.getInt(3)));
                order.setDeliveryMan(deliverymen.get(resultSet.getInt(4)));
                if (resultSet.getInt(5) != 0) {
                    order.setFood(foods.get(resultSet.getInt(5)));
                }
                if (resultSet.getInt(6) != 0) {
                    order.setBeverage(beverages.get(resultSet.getInt(6)));
                }
                System.out.println(order);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteOrder(Order order) {
        String query = "DELETE FROM `order` WHERE `id` = ?;";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(query)) {
            statement.setDouble(1, order.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
