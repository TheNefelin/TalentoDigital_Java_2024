package cl.praxis.proveedores.services;

import cl.praxis.proveedores.dao.SupplierDAO;
import cl.praxis.proveedores.models.SupplierDTO;

import java.util.List;

public class SupplierService implements ISupplierService {
    private SupplierDAO dao;

    public SupplierService() {
        dao = new SupplierDAO();
    }

    @Override
    public List<SupplierDTO> getAllSuppliers() {
        return dao.getAllSuppliers();
    }

    @Override
    public SupplierDTO getSupplierById(int id) {
        return dao.getSupplierById(id);
    }

    @Override
    public boolean addSupplier(SupplierDTO supplier) {
        return dao.addSupplier(supplier);
    }

    @Override
    public boolean updateSupplier(SupplierDTO supplier) {
        return dao.updateSupplier(supplier);
    }

    @Override
    public boolean deleteSupplier(int id) {
        return dao.deleteSupplier(id);
    }
}
