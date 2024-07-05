package cl.praxis.proveedores.dao;

import cl.praxis.proveedores.models.SupplierDTO;

import java.util.List;

public interface ISupplierDAO {
    public List<SupplierDTO> getAllSuppliers();
    public SupplierDTO getSupplierById(int id);
    public boolean addSupplier(SupplierDTO supplier);
    public boolean updateSupplier(SupplierDTO supplier);
    public boolean deleteSupplier(int id);
}
