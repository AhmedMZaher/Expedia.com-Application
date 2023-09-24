package DAO;

import Model.Hotel;
import Model.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDao {
    public static int addItem() {
        try (Connection connection = DataSource.getConnection();) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Item DEFAULT VALUES");
            statement.execute();

            PreparedStatement statement1 = connection.prepareStatement("SELECT TOP 1 * FROM Item ORDER BY ID DESC");
            ResultSet resultSet = statement1.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("ID");
            } else {
                return -1;
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Handle the error appropriately (logging, throwing a custom exception, etc.)
            return -1;
        }
    }

    public static Item getItem(int itemId) {
        Item item;
        item = HotelDao.getItemUsingId(itemId);
        if (item != null)
            return item;

        item = FlightDao.getItemUsingId(itemId);
        return item;
    }
}
