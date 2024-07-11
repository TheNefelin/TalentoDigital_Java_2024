package cl.praxis.mvc.daos.implement;

import cl.praxis.mvc.connections.MySqlConnection;
import cl.praxis.mvc.daos.ICarDAO;
import cl.praxis.mvc.models.CarDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDAO implements ICarDAO {
    private Connection connection = MySqlConnection.getInstance().getConnection();

    @Override
    public List<CarDTO> getAll() {
        List<CarDTO> list = new ArrayList<>();

        try {
            String GET_ALL = "SELECT id, nombre, url, id_proveedor FROM autos;";

            PreparedStatement ps = connection.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                CarDTO dto = new CarDTO();
                dto.setId(rs.getInt(1));
                dto.setName(rs.getString(2));
                dto.setUrl(rs.getString(3));
                dto.setIdSuppliers(rs.getInt(4));

                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
