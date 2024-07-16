package cl.praxis.heroes.daos.imp;

import cl.praxis.heroes.connections.MySqlConnection;
import cl.praxis.heroes.daos.IUserDAO;
import cl.praxis.heroes.models.UserDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO implements IUserDAO {
    private Connection connection = MySqlConnection.getInstance().getConnection();

    @Override
    public boolean validateUser(String email) {
        String query = "SELECT COUNT(id) FROM usuarios WHERE correo = ?;";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                if (rs.getInt(1) > 0) {
                    return true;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }

    @Override
    public UserDTO addUser(UserDTO user) {
        String query = "INSERT INTO usuarios (correo, clave) VALUES (?, ?);";

        try {
            PreparedStatement ps = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());

            int rowsAffecter = ps.executeUpdate();

            if (rowsAffecter > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    user.setId(rs.getInt(1));
                    user.setPassword(null);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return user;
    }

    @Override
    public UserDTO login(UserDTO user) {
        String query = "SELECT id FROM usuarios WHERE correo = ? AND clave = ?;";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user.setId(rs.getInt(1));
                user.setPassword(null);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return user;
    }
}
