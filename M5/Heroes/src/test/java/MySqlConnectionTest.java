import cl.praxis.heroes.connections.MySqlConnection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@DisplayName("Test Connection")
public class MySqlConnectionTest {

    @Test
    @DisplayName("Testing Select")
    public void testSelect() {
        boolean isConnected = false;

        try {
            Connection connection = MySqlConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT 0");
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                isConnected = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Assertions.assertTrue(isConnected, "No se Pudo Connectar");
    }

}
