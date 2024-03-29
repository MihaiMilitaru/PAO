package repository;

import config.DatabaseConnection;
import models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    public void addUser(User user) {
        String query = "INSERT INTO `user` VALUES (null, ?, ?, ?, ?, ?)";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(query)) {
            statement.setString(1, user.getName());
            statement.setInt(2, user.getAge());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPhone());
            statement.setString(5, user.getAddress());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateEmail(User user, String email) {
        String query = "UPDATE `user` SET `email` = ? WHERE `id` = ?;";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(query)) {
            statement.setString(1, email);
            statement.setInt(2, user.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteUser(User user) {
        String query = "DELETE FROM `user` WHERE `id` = ?;";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(query)) {
            statement.setDouble(1, user.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Map<Integer, User> getAllUsers() {
        Map<Integer, User> map = new HashMap<Integer, User>();
        String query = "SELECT * FROM `user`;";
        try{
            PreparedStatement preparedStatement = DatabaseConnection.getInstance().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                Integer id = resultSet.getInt(1);
                user.setId(id);
                user.setName(resultSet.getString(2));
                user.setAge(resultSet.getInt(3));
                user.setEmail(resultSet.getString(4));
                user.setPhone(resultSet.getString(5));
                user.setAddress(resultSet.getString(6));
                map.put(id, user);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }
}
