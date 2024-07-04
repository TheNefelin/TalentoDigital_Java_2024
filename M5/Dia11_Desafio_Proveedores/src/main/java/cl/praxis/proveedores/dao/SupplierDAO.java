package cl.praxis.proveedores.dao;

import java.util.List;

public class SupplierDAO implements ISupplierDAO {
    @Override
    public List<SupplierDAO> getAllSuppliers() {
        return List.of();
    }

    @Override
    public SupplierDAO getSupplierById(int id) {
        return null;
    }

    @Override
    public boolean addSupplier(SupplierDAO supplier) {
        return false;
    }

    @Override
    public boolean updateSupplier(SupplierDAO supplier) {
        return false;
    }

    @Override
    public boolean deleteSupplier(int id) {
        return false;
    }
}
