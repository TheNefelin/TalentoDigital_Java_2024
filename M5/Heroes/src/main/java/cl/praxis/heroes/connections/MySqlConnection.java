package cl.praxis.heroes.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection implements IDBConnection {
    private static MySqlConnection instance;
    private Connection connection;
    private final String HOST = "jdbc:mysql://localhost:3306/";
    private final String DATABASE = "heroes";
    private final String USER = "praxis";
    private final String PASSWORD = "praxis";
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private MySqlConnection() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(HOST.concat(DATABASE), USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static MySqlConnection getInstance() {
        if (instance == null) {
            instance = new MySqlConnection();
        } else {
            try {
                if (instance.getConnection().isClosed()) {
                    instance = new MySqlConnection();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return instance;
    }

    @Override
    public Connection getConnection() {
        return connection;
    }
}
