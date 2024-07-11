package cl.praxis.mvc.daos.implement;

import cl.praxis.mvc.connections.MySqlConnection;
import cl.praxis.mvc.daos.IAddressDAO;
import cl.praxis.mvc.models.AddressDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressDAO implements IAddressDAO {
    private Connection connection = MySqlConnection.getInstance().getConnection();

    @Override
    public AddressDTO add(AddressDTO addressDTO) {
        try {
            String INSERT = "INSERT INTO direcciones (nombre, numero, id_usuario) VALUES (?, ?, ?);";

            PreparedStatement ps = connection.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, addressDTO.getAddressName());
            ps.setInt(2, addressDTO.getAddressNumber());
            ps.setInt(3, addressDTO.getIdUser());

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    addressDTO.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return addressDTO;
    }
}
