package DAO;

import Model.*;
import Utils.Date;

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
            statement.setString(1, flight.getFlightSpec().getDepartureDate().toString());
            statement.setString(2, flight.getFlightSpec().getArrivalDate().toString());
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
            statement.setString(4, flight.getFlightSpec().getDepartureDate().toString());
            statement.setString(5, flight.getFlightSpec().getArrivalDate().toString());
            statement.setString(6, flight.getFlightSpec().getDepartureCity());
            statement.setString(7, flight.getFlightSpec().getArrivalCity());
            statement.setInt(8, itemId);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(); // Handle the error appropriately (logging, throwing a custom exception, etc.)
        }
    }
    public static Item getItemUsingId(int itemId){
        Flight flight = null;
        try (Connection connection = DataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM Flight WHERE itemId = ?")) {
            statement.setInt(1, itemId);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                // Create Flight object based on the result set
                String airline = resultSet.getString("airline");
                double cost = resultSet.getDouble("cost");
                String aircraftType = resultSet.getString("aircraftType");
                Date departureDate = new Date(resultSet.getString("departureDate"));
                Date arrivalDate  = new Date(resultSet.getString("arrivalDate"));
                String departureCity = resultSet.getString("departureCity");
                String arrivalCity = resultSet.getString("arrivalCity");
                flight = new Flight(new FlightSpec(departureDate, arrivalDate, departureCity, arrivalCity), airline, aircraftType, cost);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the error appropriately
        }
        return flight;
    }
}
