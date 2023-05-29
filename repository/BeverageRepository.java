package repository;

import config.DatabaseConnection;
import models.Beverage;
import models.Food;
import models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class BeverageRepository {

    public void addBeverage(Beverage beverage) {
        String query = "INSERT INTO `beverage` VALUES (null, ?, ?, ?, ?, ?);";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(query)) {
            statement.setString(1, beverage.getName());
            statement.setString(2, beverage.getDescription());
            statement.setFloat(3, beverage.getPrice());
            statement.setString(4, String.valueOf(beverage.getIsAlcoholic()));
            statement.setFloat(5, beverage.getVolume());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updatePrice(Beverage beverage, Float price) {
        String query = "UPDATE `beverage` SET `price` = ? WHERE `id` = ?;";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(query)) {
            statement.setFloat(1, price);
            statement.setInt(2, beverage.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteBeverage(Beverage beverage) {
        String query = "DELETE FROM `beverage` WHERE `id` = ?;";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(query)) {
            statement.setInt(1, beverage.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Map<Integer, Beverage> getAllBeverages() {
        Map map = new HashMap<Integer, Beverage>();
        String query = "select * from `beverage`;";
        try{
            PreparedStatement preparedStatement = DatabaseConnection.getInstance().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Beverage beverage = new Beverage();
                Integer id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String description = resultSet.getString(3);
                Float price = resultSet.getFloat(4);
                String isAlcoholicStr = resultSet.getString(5);
                if (isAlcoholicStr.equals("false")) {
                    beverage.setIsAlcoholic(false);
                }
                else {
                    beverage.setIsAlcoholic(true);
                }
                Float volume = resultSet.getFloat(6);
                beverage.setId(id);
                beverage.setName(name);
                beverage.setDescription(description);
                beverage.setPrice(price);
                beverage.setVolume(volume);
                map.put(id, beverage);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }
}
