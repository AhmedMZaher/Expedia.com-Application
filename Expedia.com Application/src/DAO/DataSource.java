package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataSource implements AutoCloseable {
    private static Connection connection;

    public DataSource() throws SQLException {
        System.out.println("Trying to connect");
        this.connection = DriverManager.getConnection("jdbc:sqlserver://localhost;database=expediaDB;encrypt=false", "admin", "admin");
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            System.out.println("Reconnecting...");
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost;database=expediaDB;encrypt=false", "admin", "admin");
        }
        return connection;
    }

    @Override
    public void close() throws SQLException {
        if(connection != null && connection.isClosed()){
            connection.close();
        }
    }
}
