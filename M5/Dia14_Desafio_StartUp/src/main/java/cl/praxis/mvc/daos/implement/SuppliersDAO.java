package cl.praxis.mvc.daos.implement;

import cl.praxis.mvc.connections.MySqlConnection;
import cl.praxis.mvc.daos.ISuppliersDAO;
import cl.praxis.mvc.models.SupplierDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SuppliersDAO implements ISuppliersDAO {
    private final Connection connection = MySqlConnection.getInstance().getConnection();

    @Override
    public List<SupplierDTO> getAll() {
        List<SupplierDTO> list = new ArrayList<>();

        try {
            String GET_ALL = "SELECT id, nombre FROM proveedores;";

            PreparedStatement ps = connection.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                SupplierDTO dto = new SupplierDTO();
                dto.setId(rs.getInt(1));
                dto.setName(rs.getString(2));

                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
