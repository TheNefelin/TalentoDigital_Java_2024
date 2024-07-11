package cl.praxis.mvc.daos.implement;

import cl.praxis.mvc.connections.MySqlConnection;
import cl.praxis.mvc.daos.IUserDAO;
import cl.praxis.mvc.models.RolDTO;
import cl.praxis.mvc.models.UserDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {
    private final Connection connection = MySqlConnection.getInstance().getConnection();;

    @Override
    public List<UserDTO> getAll() {
        List<UserDTO> list = new ArrayList<>();

        String SELECT_ALL = "" +
            "SELECT" +
            "   a.id, " +
            "   a.correo, " +
            //"a.clave, " +
            "   a.nombre, " +
            "   a.apodo, " +
            "   a.peso, " +
            "   a.fecha_creacion, " +
            "   a.fecha_modificacion, " +
            "   c.id AS idRol, " +
            "   c.nombre AS rol, " +
            "   d.id AS idAuto, " +
            "   d.nombre AS auto, " +
            "   d.url, " +
            "   e.id AS idDireccion, " +
            "   e.nombre AS direccion, " +
            "   e.numero " +
            "FROM usuarios a " +
            "   LEFT JOIN usuarios_roles b ON a.id = b.id_usuario " +
            "   LEFT JOIN roles c ON c.id = b.id_rol " +
            "   LEFT JOIN autos d ON d.id = a.id_auto " +
            "   LEFT JOIN direcciones e ON e.id_usuario = a.id " +
            "ORDER BY a.id;";

        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                UserDTO user = mapUserDTO(rs);

                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public UserDTO add(UserDTO dto) {
        try {
            String INSERT = "INSERT INTO usuarios (correo, clave, nombre, apodo, peso, id_auto) VALUES (?, ?, ?, ?, ?, ?);";

            PreparedStatement ps = connection.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, dto.getEmail());
            ps.setString(2, dto.getPassword());
            ps.setString(3, dto.getName());
            ps.setString(4, dto.getNick());
            ps.setInt(5, dto.getWeight());
            ps.setInt(6, dto.getIdCar());

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
    public boolean emailExists(String email) {
        try {
            String CHECK_EMAIL = "SELECT COUNT(id) FROM usuarios WHERE correo = ?;";

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

    @Override
    public UserDTO userLogin(String email, String password) {
        UserDTO user = null;

        try {
            String CHECK_LOGIN = "" +
                "SELECT" +
                "   a.id, " +
                "   a.correo, " +
                 //"a.clave, " +
                "   a.nombre, " +
                "   a.apodo, " +
                "   a.peso, " +
                "   a.fecha_creacion, " +
                "   a.fecha_modificacion, " +
                "   c.id AS idRol, " +
                "   c.nombre AS rol, " +
                "   d.id AS idAuto, " +
                "   d.nombre AS auto, " +
                "   d.url, " +
                "   e.id AS idDireccion, " +
                "   e.nombre AS direccion, " +
                "   e.numero " +
                "FROM usuarios a " +
                "   LEFT JOIN usuarios_roles b ON a.id = b.id_usuario " +
                "   LEFT JOIN roles c ON c.id = b.id_rol " +
                "   LEFT JOIN autos d ON d.id = a.id_auto " +
                "   LEFT JOIN direcciones e ON e.id_usuario = a.id " +
                "WHERE correo = ? AND clave = ?;";

            PreparedStatement ps = connection.prepareStatement(CHECK_LOGIN);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = mapUserDTO(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    private UserDTO mapUserDTO(ResultSet rs) throws SQLException {
        UserDTO user = new UserDTO();

        user.setId(rs.getInt("id"));
        user.setEmail(rs.getString("correo"));
        user.setName(rs.getString("nombre"));
        user.setNick(rs.getString("apodo"));
        user.setWeight(rs.getInt("peso"));
        user.setDate_create(rs.getDate("fecha_creacion"));
        user.setDate_update(rs.getDate("fecha_modificacion"));
        user.setIdRol(rs.getInt("idRol"));
        user.setRol(rs.getString("rol"));
        user.setIdCar(rs.getInt("idAuto"));
        user.setCar(rs.getString("auto"));
        user.setUrl(rs.getString("url"));
        user.setIdAddress(rs.getInt("idDireccion"));
        user.setAddress(rs.getString("direccion"));
        user.setAddressNumber(rs.getInt("numero"));

        return user;
    }
}
