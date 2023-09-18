package DAO;

import Model.Flight;
import Model.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FlightDao {


    // If flight Exist return its id otherwise return -1
    public static int isFlightExist(Flight flight) {
        try (Connection connection = DataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM Flight WHERE " +
                     "departureDate = ? AND arrivalDate = ? AND departureCity = ? AND arrivalCity = ? " +
                     "AND airline = ? AND aircraftType = ?");
        ) {
            statement.setDate(1, java.sql.Date.valueOf(flight.getFlightSpec().getDepartureDate().toString()));
            statement.setDate(2, java.sql.Date.valueOf(flight.getFlightSpec().getArrivalDate().toString()));
            statement.setString(3, flight.getFlightSpec().getDepartureCity());
            statement.setString(4, flight.getFlightSpec().getArrivalCity());
            statement.setString(5, flight.getAirline());
            statement.setString(6, flight.getAircraftType());

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("itemId"); // Return the itemId
            } else {
                return -1; // If not found
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Handle the error appropriately (logging, throwing a custom exception, etc.)
            return -1;
        }
    }

    public static void addFlight(Flight flight, int itemId) {
        try (Connection connection = DataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO Flight " +
                     "(airline, cost, aircraftType, departureDate, arrivalDate, departureCity, arrivalCity, itemId) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
        ) {
            statement.setString(1, flight.getAirline());
            statement.setDouble(2, flight.getPrice());
            statement.setString(3, flight.getAircraftType());
            statement.setDate(4, java.sql.Date.valueOf(flight.getFlightSpec().getDepartureDate().toString()));
            statement.setDate(5, java.sql.Date.valueOf(flight.getFlightSpec().getArrivalDate().toString()));
            statement.setString(6, flight.getFlightSpec().getDepartureCity());
            statement.setString(7, flight.getFlightSpec().getArrivalCity());
            statement.setInt(8, itemId);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(); // Handle the error appropriately (logging, throwing a custom exception, etc.)
        }
    }
}
