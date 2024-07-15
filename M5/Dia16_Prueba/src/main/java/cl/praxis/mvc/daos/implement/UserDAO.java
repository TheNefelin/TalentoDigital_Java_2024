package cl.praxis.mvc.daos.implement;

import cl.praxis.mvc.connections.MySqlConnection;
import cl.praxis.mvc.daos.IUserDAO;
import cl.praxis.mvc.models.*;

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

        String SELECT_ALL =
            "SELECT " +
            "   a.id, " +
            "   a.correo, " +
            //"   a.clave, " +
            "   a.nombre, " +
            "   a.apodo, " +
            "   a.peso, " +
            "   a.fecha_creacion, " +
            "   a.fecha_modificacion, " +
            "   b.id AS id_direccion, " +
            "   b.nombre AS direccion, " +
            "   b.numero, " +
            "   d.id AS id_rol, " +
            "   d.nombre AS rol, " +
            "   e.id AS id_auto, " +
            "   e.nombre AS auto, " +
            "   e.url, " +
            "   f.id AS id_proveedor, " +
            "   f.nombre AS proveedor " +
            "FROM usuarios a " +
            "   LEFT JOIN direcciones b ON b.id_usuario = a.id " +
            "   LEFT JOIN usuarios_roles c ON c.id_usuario = a.id " +
            "   LEFT JOIN roles d ON d.id = c.id_rol " +
            "   LEFT JOIN autos e ON e.id = a.id_auto " +
            "   LEFT JOIN proveedores f ON f.id = e.id_proveedor;";

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
            ps.setInt(6, dto.getCar().getId());

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
            String CHECK_LOGIN =
                "SELECT " +
                "   a.id, " +
                "   a.correo, " +
                //"   a.clave, " +
                "   a.nombre, " +
                "   a.apodo, " +
                "   a.peso, " +
                "   a.fecha_creacion, " +
                "   a.fecha_modificacion, " +
                "   b.id AS id_direccion, " +
                "   b.nombre AS direccion, " +
                "   b.numero, " +
                "   d.id AS id_rol, " +
                "   d.nombre AS rol, " +
                "   e.id AS id_auto, " +
                "   e.nombre AS auto, " +
                "   e.url, " +
                "   f.id AS id_proveedor, " +
                "   f.nombre AS proveedor " +
                "FROM usuarios a " +
                "   LEFT JOIN direcciones b ON b.id_usuario = a.id " +
                "   LEFT JOIN usuarios_roles c ON c.id_usuario = a.id " +
                "   LEFT JOIN roles d ON d.id = c.id_rol " +
                "   LEFT JOIN autos e ON e.id = a.id_auto " +
                "   LEFT JOIN proveedores f ON f.id = e.id_proveedor " +
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
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setId(rs.getInt("id_direccion"));
        addressDTO.setName(rs.getString("direccion"));
        addressDTO.setNumber(rs.getInt("numero"));

        RolDTO rolDTO = new RolDTO();
        rolDTO.setId(rs.getInt("id_rol"));
        rolDTO.setName(rs.getString("rol"));

        CarDTO carDTO = new CarDTO();
        carDTO.setId(rs.getInt("id_auto"));
        carDTO.setName(rs.getString("auto"));
        carDTO.setUrl(rs.getString("url"));

        SupplierDTO supplierDTO = new SupplierDTO();
        supplierDTO.setId(rs.getInt("id_proveedor"));
        supplierDTO.setName(rs.getString("proveedor"));

        UserDTO user = new UserDTO();
        user.setId(rs.getInt("id"));
        user.setEmail(rs.getString("correo"));
        user.setName(rs.getString("nombre"));
        user.setNick(rs.getString("apodo"));
        user.setWeight(rs.getInt("peso"));
        user.setDate_create(rs.getDate("fecha_creacion"));
        user.setDate_update(rs.getDate("fecha_modificacion"));
        user.setAddress(addressDTO);
        user.setRol(rolDTO);
        user.setCar(carDTO);
        user.setSupplier(supplierDTO);

        return user;
    }
}
