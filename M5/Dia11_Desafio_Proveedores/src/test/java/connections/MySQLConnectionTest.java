package connections;

import cl.praxis.proveedores.connections.MySQLConnection;
import org.junit.jupiter.api.*;

import java.sql.*;

@DisplayName("Tests Connection")
public class MySQLConnectionTest {
    public static Connection connection = MySQLConnection.getInstance().getConnection();

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
