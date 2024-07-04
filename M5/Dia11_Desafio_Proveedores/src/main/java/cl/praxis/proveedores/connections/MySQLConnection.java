package cl.praxis.proveedores.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    private static MySQLConnection instance;
    private final String HOST = "jdbc:mysql://localhost:3306/";
    private final String DATABASE = "praxis";
    private final String USER = "praxis";
    private final String PASS = "praxis";
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private Connection connection;

    private MySQLConnection() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(HOST.concat(DATABASE), USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static MySQLConnection getInstance() {
        if (instance == null) {
            instance = new MySQLConnection();
        } else {
            try {
                if (instance.getConnection().isClosed()) {
                    instance = new MySQLConnection();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
