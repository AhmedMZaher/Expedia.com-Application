import Controller.*;
import DAO.DataSource;
import DAO.FlightDao;
import Model.Flight;
import Model.FlightSpec;
import Utils.Date;
import View.AddItineraryView;
import View.MainMenuView;

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


        MainMenuController.run();
//        AddItineraryController.run(1);











//        FlightSpec p1 = new FlightSpec(new Date("2023-09-15"), new Date("2023-09-18"), "Cairo", "USA");
//        Flight f1 = new Flight(p1, "Cairo Airport", "F17", 165);
//        int x = FlightDao.addFlight(f1);
//        System.out.println("TEST: "+ x);



//        CreateAccountController.createAccount();
//        LoginController.userLogin();

//        ChangePasswordController.changePassword("ahmedzaher@gmail.com");
//        BookFlightController.addFlight();
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