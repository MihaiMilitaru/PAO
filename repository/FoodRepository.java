package repository;

import config.DatabaseConnection;
import models.Food;
import models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;



public class FoodRepository {
    public void addFood(Food food) {
        String query = "INSERT INTO `food` VALUES(null, ?, ?, ?, ?, ?, ?);";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(query)) {
           statement.setString(1, food.getName());
           statement.setString(2, food.getDescription());
           statement.setFloat(3, food.getPrice());
           statement.setString(4, food.getIsVegetarian().toString());
           statement.setInt(5, food.getPreparationTime());
           statement.setFloat(6, food.getWeight());
           statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updatePrice(Food food, Float price) {
        String query = "UPDATE `food` SET `price` = ? WHERE `id` = ?;";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(query)) {
            statement.setFloat(1, price);
            statement.setInt(2, food.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void deleteFood(Food food) {
        String query = "DELETE FROM `food` WHERE `id` = ?;";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(query)) {
            statement.setDouble(1, food.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Map<Integer, Food> getAllFood() {
        Map<Integer, Food> map = new HashMap<Integer, Food>();
        String query = "SELECT * FROM `food`;";
        try{
            PreparedStatement preparedStatement = DatabaseConnection.getInstance().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Food food = new Food();
                Integer id = resultSet.getInt(1);
                food.setId(id);
                food.setName(resultSet.getString(2));
                food.setDescription(resultSet.getString(3));
                food.setPrice(resultSet.getFloat(4));
                String isVegetarianStr = resultSet.getString(5);
                if (isVegetarianStr.equals("true")) {
                    food.setIsVegetarian(true);
                } else {
                    food.setIsVegetarian(false);
                }
                food.setPreparationTime(resultSet.getInt(6));
                food.setWeight(resultSet.getFloat(7));
                map.put(id, food);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }


}
