package ua.homework.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Database {
    private static final Database INSTANCE = new Database();
    private static final String CONNECTION_URL = "jdbc:h2:./test";
    private Connection connection;

    private Database() {
        try {
            connection = DriverManager.getConnection(CONNECTION_URL);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Database getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() {
        return connection;
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}