package cl.praxis.ejercicio.DAO.implement;

import cl.praxis.ejercicio.DAO.IGenericDAO;
import cl.praxis.ejercicio.connections.MySQLConnection;
import cl.praxis.ejercicio.models.UserDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IGenericDAO<UserDTO> {
    private Connection connection;
    private final String USER_GET_ALL = "SELECT id, nombre, apellido, email, edad, esActivo FROM usuarios";
    private final String USER_GET_BYID = "SELECT id, nombre, apellido, email, edad, esActivo FROM usuarios WHERE id = ?";
    private final String USER_INSERT = "INSERT INTO usuarios (nombre, apellido, email, edad, esActivo) VALUES (?, ?, ?, ?, ?)";
    private final String USER_UPDATE = "UPDATE usuarios SET nombre = ?, apellido = ?, email = ?, edad = ?, esActivo = ? WHERE id = ?";
    private final String USER_DELETE = "DELETE FROM usuarios WHERE id = ?";

    public UserDAO() {
        connection = MySQLConnection.getInstance().getConnection();
    }

    @Override
    public List<UserDTO> getAll() {
        List<UserDTO> users = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareStatement(USER_GET_ALL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                UserDTO user = new UserDTO();

                user.setId(rs.getInt("id"));
                user.setName(rs.getString("nombre"));
                user.setSurname(rs.getString("apellido"));
                user.setEmail(rs.getString("email"));
                user.setAge(rs.getInt("edad"));
                user.setActive(rs.getBoolean("esActivo"));

                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public UserDTO getById(int id) {
        UserDTO user = null;

        try {
            PreparedStatement ps = connection.prepareStatement(USER_GET_BYID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new UserDTO();

                user.setId(rs.getInt("id"));
                user.setName(rs.getString("nombre"));
                user.setSurname(rs.getString("apellido"));
                user.setEmail(rs.getString("email"));
                user.setAge(rs.getInt("edad"));
                user.setActive(rs.getBoolean("esActivo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public UserDTO insert(UserDTO obj) {
        try {
            PreparedStatement ps = connection.prepareStatement(USER_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, obj.getName());
            ps.setString(2, obj.getSurname());
            ps.setString(3, obj.getEmail());
            ps.setInt(4, obj.getAge());
            ps.setBoolean(5, obj.isActive());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                obj.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return obj;
    }

    @Override
    public UserDTO update(UserDTO obj) {
        try {
            PreparedStatement ps = connection.prepareStatement(USER_UPDATE);
            ps.setString(1, obj.getName());
            ps.setString(2, obj.getSurname());
            ps.setString(3, obj.getEmail());
            ps.setInt(4, obj.getAge());
            ps.setBoolean(5, obj.isActive());
            ps.setInt(6, obj.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return obj;
    }

    @Override
    public boolean delete(int id) {
        boolean rowDeleted = false;

        try {
            PreparedStatement ps = connection.prepareStatement(USER_DELETE);
            ps.setInt(1, id);
            rowDeleted = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowDeleted;
    }
}
