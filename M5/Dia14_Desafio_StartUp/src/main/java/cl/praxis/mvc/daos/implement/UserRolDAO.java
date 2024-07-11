package cl.praxis.mvc.daos.implement;

import cl.praxis.mvc.connections.MySqlConnection;
import cl.praxis.mvc.daos.IUserRolDAO;
import cl.praxis.mvc.models.UserRolDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRolDAO implements IUserRolDAO {
    private Connection connection = MySqlConnection.getInstance().getConnection();

    @Override
    public boolean add(UserRolDTO dto) {
        try {
            String INSERT = "INSERT INTO usuarios_roles (id_usuario, id_rol) VALUES (?, ?);";

            PreparedStatement ps = connection.prepareStatement(INSERT);
            ps.setInt(1, dto.getIdUser());
            ps.setInt(2, dto.getIdRol());

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
