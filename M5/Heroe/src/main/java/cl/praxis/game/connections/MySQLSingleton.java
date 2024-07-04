package cl.praxis.game.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLSingleton {
    private static MySQLSingleton instance;
    private final Connection conn;
    private final String jdbcURL = "jdbc:mysql://localhost:3306/praxis";
    private final String jdbcUsername = "praxis"; //"root";
    private final String jdbcPassword = "praxis"; //"contraseña"

    private MySQLSingleton() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static MySQLSingleton getInstance() throws SQLException {
        if (instance == null) {
            instance = new MySQLSingleton();
        } else if (instance.getConnection().isClosed()) {
            instance = new MySQLSingleton();
        }

        return instance;
    }

    public Connection getConnection() {
        return conn;
    }

    public void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
