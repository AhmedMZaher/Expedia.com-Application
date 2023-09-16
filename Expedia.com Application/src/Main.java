import Controller.CreateAccountController;
import DAO.DataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        try {
            DataSource dataSource = new DataSource(); // This line calls the constructor
            // ...
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while establishing connection.");
        }
        CreateAccountController c = new CreateAccountController();
        c.createAccount();
//        DataSource dataSource = new DataSource(); // Create an instance of DataSource
//        Connection c = DataSource.getConnection();
//        if (c != null) {
//            System.out.println("Connected to the database!");
//            // Use the connection here
//        } else {
//            System.out.println("Failed to connect to the database.");
//        }
    }
}