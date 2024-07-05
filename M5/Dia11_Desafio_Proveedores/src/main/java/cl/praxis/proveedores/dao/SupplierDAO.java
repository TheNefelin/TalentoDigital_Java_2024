package cl.praxis.proveedores.dao;

import cl.praxis.proveedores.connections.MySQLConnection;
import cl.praxis.proveedores.models.SupplierDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDAO implements ISupplierDAO {
    private final String GET_ALL = "SELECT id, nombre, rut, direccion, correo, telefono, contacto, telefono_contacto, activo FROM proveedores;";
    private final String GET_BY_ID = "SELECT id, nombre, rut, direccion, correo, telefono, contacto, telefono_contacto, activo FROM proveedores WHERE id = ?;";
    private final String INSERT = "INSERT INTO proveedores (nombre, rut, direccion, correo, telefono, contacto, telefono_contacto, activo) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    private final String UPDATE = "UPDATE proveedores SET nombre = ?, rut = ?, direccion = ?, correo = ?, telefono = ?, contacto = ?, telefono_contacto = ?, activo = ? WHERE id = ?;";
    private final String DELETE = "DELETE FROM proveedores WHERE id = ?;";
    private final String DELETE2 = "UPDATE proveedores SET activo = ? WHERE id = ?;";
    private final Connection connection = MySQLConnection.getInstance().getConnection();

    @Override
    public List<SupplierDTO> getAllSuppliers() {
        List<SupplierDTO> listSupplier = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                SupplierDTO dto = new SupplierDTO();

                dto.setId(rs.getInt("id"));
                dto.setName(rs.getString("nombre"));
                dto.setRut(rs.getString("rut"));
                dto.setAddress(rs.getString("direccion"));
                dto.setEmail(rs.getString("correo"));
                dto.setPhone(rs.getInt("telefono"));
                dto.setContact(rs.getString("contacto"));
                dto.setContactPhone(rs.getInt("telefono_contacto"));
                dto.setActive(rs.getBoolean("activo"));

                listSupplier.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listSupplier;
    }

    @Override
    public SupplierDTO getSupplierById(int id) {
        SupplierDTO dto = null;

        try {
            PreparedStatement ps = connection.prepareStatement(GET_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                dto = new SupplierDTO();

                dto.setId(rs.getInt("id"));
                dto.setName(rs.getString("nombre"));
                dto.setRut(rs.getString("rut"));
                dto.setAddress(rs.getString("direccion"));
                dto.setEmail(rs.getString("correo"));
                dto.setPhone(rs.getInt("telefono"));
                dto.setContact(rs.getString("contacto"));
                dto.setContactPhone(rs.getInt("telefono_contacto"));
                dto.setActive(rs.getBoolean("activo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dto;
    }

    @Override
    public boolean addSupplier(SupplierDTO supplier) {
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT);
            ps.setString(1, supplier.getName());
            ps.setString(2, supplier.getRut());
            ps.setString(3, supplier.getAddress());
            ps.setString(4, supplier.getEmail());
            ps.setInt(5, supplier.getPhone());
            ps.setString(6, supplier.getContact());
            ps.setInt(7, supplier.getContactPhone());
            ps.setBoolean(8, supplier.isActive());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean updateSupplier(SupplierDTO supplier) {
        try {
            PreparedStatement ps = connection.prepareStatement(UPDATE);
            ps.setString(1, supplier.getName());
            ps.setString(2, supplier.getRut());
            ps.setString(3, supplier.getAddress());
            ps.setString(4, supplier.getEmail());
            ps.setInt(5, supplier.getPhone());
            ps.setString(6, supplier.getContact());
            ps.setInt(7, supplier.getContactPhone());
            ps.setBoolean(8, supplier.isActive());
            ps.setInt(9, supplier.getId());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteSupplier(int id) {
        try {
            PreparedStatement ps = connection.prepareStatement(DELETE2);
            ps.setBoolean(1, false);
            ps.setInt(2, id);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
