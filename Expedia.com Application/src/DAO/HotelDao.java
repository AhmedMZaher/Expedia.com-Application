package DAO;

import Model.Hotel;
import Model.HotelSpec;
import Model.Item;
import Utils.Date;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HotelDao {
    // If Hotel Exist return its id otherwise return -1

    public static int isHotelExist(Hotel hotel){
        try(Connection connection = DataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Hotel WHERE departureDate = ?" +
                    "AND arrivalDate = ? AND city = ? AND country = ? AND noOfAdults = ? AND noOfChildren = ?" +
                    "AND roomType = ? AND hotelName = ?")) {
            statement.setDate(1, java.sql.Date.valueOf(hotel.getHotelSpec().getDepartureDate().toString()));
            statement.setDate(2, java.sql.Date.valueOf(hotel.getHotelSpec().getArrivalDate().toString()));
            statement.setString(3, hotel.getHotelSpec().getCity());
            statement.setString(4, hotel.getHotelSpec().getCountry());
            statement.setInt(5, hotel.getHotelSpec().getNumberOfAdults());
            statement.setInt(6, hotel.getHotelSpec().getNumberOfChildren());
            statement.setString(7, hotel.getRoomType());
            statement.setString(8, hotel.getHotelName());
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                return resultSet.getInt("itemId");
            }else{
                return -1;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void addHotel(Hotel hotel, int itemId){
        try (Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO Hotel " +
                "(city, country, departureDate, arrivalDate, noOfAdults, noOfChildren, roomType, hotelName, itemId, price)" +
                "VALUES (?, ? , ? , ?, ? , ? , ? ,?, ?, ?)")){
            statement.setString(1, hotel.getHotelSpec().getCity());
            statement.setString(2, hotel.getHotelSpec().getCountry());
            statement.setDate(3, java.sql.Date.valueOf(hotel.getHotelSpec().getDepartureDate().toString()));
            statement.setDate(4, java.sql.Date.valueOf(hotel.getHotelSpec().getArrivalDate().toString()));
            statement.setInt(5, hotel.getHotelSpec().getNumberOfAdults());
            statement.setInt(6, hotel.getHotelSpec().getNumberOfChildren());
            statement.setString(7, hotel.getRoomType());
            statement.setString(8, hotel.getHotelName());
            statement.setInt(9, itemId);
            statement.setDouble(10, hotel.getPrice());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static Item getItemUsingId(int itemId){
        Hotel hotel = null;
        try (Connection connection = DataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM Hotel WHERE itemId = ?")) {
            statement.setInt(1, itemId);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                // Create Hotel object based on the result set
                String city = resultSet.getString("city");
                String country = resultSet.getString("country");
                Date departureDate = new Date(resultSet.getString("departureDate"));
                Date arrivalDate = new Date(resultSet.getString("arrivalDate"));
                int noOfAdults = resultSet.getInt("noOfAdults");
                int noOfChildren = resultSet.getInt("noOfChildren");
                String roomType = resultSet.getString("roomType");
                String hotelName = resultSet.getString("hotelName");
                double price = resultSet.getDouble("price");
                hotel = new Hotel(new HotelSpec(arrivalDate, departureDate, city, country, noOfAdults, noOfChildren), hotelName, roomType, price);

            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the error appropriately
        }
        return hotel;
    }
}
