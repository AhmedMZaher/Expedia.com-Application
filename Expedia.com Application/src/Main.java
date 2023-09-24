import Controller.*;
import DAO.DataSource;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        try {
            DataSource dataSource = new DataSource(); // This line calls the constructor
            MainMenuController.run();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while establishing connection.");
        }

    }
}