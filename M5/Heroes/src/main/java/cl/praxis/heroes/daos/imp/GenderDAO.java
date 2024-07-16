package cl.praxis.heroes.daos.imp;

import cl.praxis.heroes.connections.MySqlConnection;
import cl.praxis.heroes.daos.IGenderDAO;
import cl.praxis.heroes.models.GenderDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenderDAO implements IGenderDAO {
    private Connection connection = MySqlConnection.getInstance().getConnection();

    @Override
    public List<GenderDTO> getAllRol() {
        List<GenderDTO> list = new ArrayList<>();
        String query = "SELECT id, nombre FROM generos;";

        try {
            PreparedStatement sp = connection.prepareStatement(query);

            ResultSet rs = sp.executeQuery();
            while (rs.next()) {
                GenderDTO dto = new GenderDTO();
                dto.setId(rs.getInt("id"));
                dto.setName(rs.getString("nombre"));

                list.add(dto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }
}
