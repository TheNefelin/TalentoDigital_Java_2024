package cl.praxis.ejercicio.connections;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Getter
public class MySQLConnection {
    private static MySQLConnection instance;
    private Connection connection;
    private final String URL = "jdbc:mysql://localhost:3306/praxis";
    private final String USER = "praxis";
    private final String PASS = "praxis";
    private final String DRIVER = "com.mysql.jdbc.Driver";

    private MySQLConnection() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASS);
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
}
