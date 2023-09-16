package DAO;

import Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {


    public  static boolean isEmailExist(String email){
        try (Connection connection = DataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM Traveler WHERE email = ?")) {

            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();

        } catch (SQLException e) {
            e.printStackTrace(); // Handle the error appropriately (logging, throwing a custom exception, etc.)
            return false; // Assuming false for simplicity
        }
    }
    public  static boolean isNameExist(String name){
        try (Connection connection = DataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM Traveler WHERE name = ?")) {

            statement.setString(1, name);

            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();

        } catch (SQLException e) {
            e.printStackTrace(); // Handle the error appropriately (logging, throwing a custom exception, etc.)
            return false; // Assuming false for simplicity
        }
    }
    public static void saveUser(User user) {
        try (Connection connection = DataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO Traveler (name, email, password) VALUES (?, ?, ?)")) {

            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());

            statement.executeUpdate();
            System.out.println("User saved to database: " + user.getName());

        } catch (SQLException e) {
            e.printStackTrace(); // Handle the error appropriately (logging, throwing a custom exception, etc.)
        }
    }
}
