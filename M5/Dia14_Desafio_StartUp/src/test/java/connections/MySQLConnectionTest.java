package connections;

import cl.praxis.mvc.connections.MySqlConnection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@DisplayName("Tests Connection")
public class MySQLConnectionTest {
    public static Connection connection = MySqlConnection.getInstance().getConnection();

    @Test
    @DisplayName("Testing Select")
    public void testConnection() {
        boolean isConnected = false;

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT 1");
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                isConnected = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        Assertions.assertTrue(isConnected, "Error en la conexión: No se pudo ejecutar la consulta.");
    }
}
