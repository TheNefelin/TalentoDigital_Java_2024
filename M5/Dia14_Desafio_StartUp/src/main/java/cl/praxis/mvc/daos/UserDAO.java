package cl.praxis.mvc.daos;

import cl.praxis.mvc.connections.MySqlConnection;
import cl.praxis.mvc.models.UserDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAO implements IUserDAO {
    private final Connection connection;

    public UserDAO() {
        connection = MySqlConnection.getInstance().getConnection();
    }

    @Override
    public List<UserDTO> getAll() {
        return List.of();
    }

    @Override
    public UserDTO getById(int id) {
        return null;
    }

    @Override
    public UserDTO add(UserDTO dto) {
        try {
            String INSERT = "INSERT INTO usuarios (correo, clave, nombre, apodo, peso) VALUES (?, ?, ?, ?, ?);";

            PreparedStatement ps = connection.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, dto.getEmail());
            ps.setString(2, dto.getPassword());
            ps.setString(3, dto.getName());
            ps.setString(4, dto.getNick());
            ps.setInt(5, dto.getWeight());

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    dto.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dto;
    }

    @Override
    public boolean update(UserDTO dto) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    public boolean emailExists(String email) {
        try {
            String CHECK_EMAIL = "SELECT COUNT(*) FROM usuarios WHERE correo = ?;";

            PreparedStatement ps = connection.prepareStatement(CHECK_EMAIL);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public UserDTO userLogin(String email, String password) {
        UserDTO dto = null;

        try {
            String CHECK_LOGIN = "SELECT id, correo, nombre, apodo, peso, fecha_creacion, fecha_modificacion FROM usuarios WHERE correo = ? AND clave = ?;";

            PreparedStatement ps = connection.prepareStatement(CHECK_LOGIN);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                dto = new UserDTO();

                dto.setId(rs.getInt(1));
                dto.setEmail(rs.getString(2));
                dto.setName(rs.getString(3));
                dto.setNick(rs.getString(4));
                dto.setWeight(rs.getInt(5));
                dto.setDate_create(rs.getDate(6));
                dto.setDate_update(rs.getDate(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dto;
    }
}
