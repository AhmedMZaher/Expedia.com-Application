package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
