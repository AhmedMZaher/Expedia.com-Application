package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserItemsDao {
    public static void addItem(int itemId , int userId) {
        try (Connection connection = DataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO userItems (userId, itemId) " +
                     "values (?, ?)")){
            statement.setInt(1, userId);
            statement.setInt(2, itemId);

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<Integer> getOrderedItemIDs(int userID) {
        List<Integer> orderedItemIDs = new ArrayList<>();
        try(Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT itemId FROM userItems WHERE userId = ?")) {
            statement.setInt(1, userID);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                orderedItemIDs.add(resultSet.getInt("itemId"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderedItemIDs;
    }
}
