package repository;

import config.DatabaseConnection;
import models.DeliveryMan;
import models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DeliveryManRepository {

    public void addDeliveryMan(DeliveryMan deliveryman) {
        String query = "INSERT INTO `deliveryman` VALUES (null, ?, ?, ?, ?, ?, ?)";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(query)) {
            statement.setString(1, deliveryman.getName());
            statement.setInt(2, deliveryman.getAge());
            statement.setString(3, deliveryman.getEmail());
            statement.setString(4, deliveryman.getPhone());
            statement.setFloat(5, deliveryman.getRating());
            statement.setFloat(6, deliveryman.getSalary());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateSalary(DeliveryMan deliveryman, String salary) {
        String query = "UPDATE `deliveryman` SET `salary` = ? WHERE `id` = ?;";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(query)) {
            statement.setString(1, salary);
            statement.setFloat(2, deliveryman.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteDriver(DeliveryMan deliveryman) {
        String query = "DELETE FROM `deliveryman` WHERE `id` = ?;";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(query)) {
            statement.setDouble(1, deliveryman.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Map<Integer, DeliveryMan> getAllDeliveryMen() {
        Map<Integer, DeliveryMan> map = new HashMap<Integer, DeliveryMan>();
        String query = "SELECT * FROM `deliveryman`";
        try{
            PreparedStatement preparedStatement = DatabaseConnection.getInstance().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                DeliveryMan deliveryman = new DeliveryMan();
                Integer id = resultSet.getInt(1);
                deliveryman.setId(id);
                deliveryman.setName(resultSet.getString(2));
                deliveryman.setAge(resultSet.getInt(3));
                deliveryman.setEmail(resultSet.getString(4));
                deliveryman.setPhone(resultSet.getString(5));
                deliveryman.setRating(resultSet.getFloat(6));
                deliveryman.setSalary(resultSet.getFloat(7));
                map.put(id, deliveryman);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }



}
