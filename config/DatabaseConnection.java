package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;

    private DatabaseConnection() {


    }

    public static Connection getInstance() throws SQLException {
        if(connection == null) {
            String url = "jdbc:sqlite:C:/Users/mihai/Documents/Diverse/Projects/Food_Delivery_App/untitled/src/config/database.db";


            connection = DriverManager.getConnection(url);
        }
        return connection;
    }
}
