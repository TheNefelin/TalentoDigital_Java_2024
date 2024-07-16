package cl.praxis.heroes.daos.imp;

import cl.praxis.heroes.connections.MySqlConnection;
import cl.praxis.heroes.daos.IClassDAO;
import cl.praxis.heroes.models.ClassDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassDAO implements IClassDAO {
    private Connection connection = MySqlConnection.getInstance().getConnection();

    @Override
    public List<ClassDTO> getAllClass() {
        List<ClassDTO> list = new ArrayList<>();
        String query = "SELECT id, nombre FROM clases;";

        try {
            PreparedStatement ps = connection.prepareStatement(query);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ClassDTO dto = new ClassDTO();
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
