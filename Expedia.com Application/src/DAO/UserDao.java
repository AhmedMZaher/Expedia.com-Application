package DAO;

import Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {


    public static boolean isEmailExist(String email) {
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

    // Check if email and password match together
    public static boolean isPasswordMatch(String email, String password) {
        try (Connection connection = DataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT password FROM Traveler WHERE email = ?")) {

            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                String storedPassword = resultSet.getString("password");
                return password.equals(storedPassword);
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();// Handle the error appropriately (logging, throwing a custom exception, etc.)
            return false; // Assuming false for simplicity
        }
    }

    public static boolean isNameExist(String name) {
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

    public static void saveUser(String name, String email, String password) {
        try (Connection connection = DataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO Traveler (name, email, password) VALUES (?, ?, ?)")) {

            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, password);

            statement.executeUpdate();
            System.out.println("User saved to database: " + name);

        } catch (SQLException e) {
            e.printStackTrace(); // Handle the error appropriately (logging, throwing a custom exception, etc.)
        }
    }

    public static boolean changeEmail(String oldEmail, String newEmail) {
        try (Connection connection = DataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE Traveler SET email = ? WHERE email = ?")) {

            statement.setString(1, newEmail);
            statement.setString(2, oldEmail);

            int rowsAffected = statement.executeUpdate();

            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace(); // Handle the error appropriately (logging, throwing a custom exception, etc.)
        }

        return false; // If an error occurred
    }

    public static boolean changePassword(String email, String password) {
        try (Connection connection = DataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE Traveler SET password = ? WHERE email = ?")) {

            statement.setString(1, password);
            statement.setString(2, email);

            int rowsAffected = statement.executeUpdate();

            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace(); // Handle the error appropriately (logging, throwing a custom exception, etc.)
        }

        return false; // If an error occurred
    }

    public static int getId(User user) {
        try (Connection connection = DataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT id FROM Traveler WHERE" +
                     "name = ? AND password = ? AND email = ?")) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());

            ResultSet resultSet = statement.executeQuery();
            return resultSet.getInt("id");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getName(String email) {
        try (Connection connection = DataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM Traveler WHERE email = ?")) {

            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("name");
            } else {
                // Handle case where no rows match the email
                return null; // Or throw an exception, or return a default value, depending on your logic
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
