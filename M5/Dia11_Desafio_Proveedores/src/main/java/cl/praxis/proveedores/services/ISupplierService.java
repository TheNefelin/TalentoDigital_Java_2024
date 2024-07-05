package cl.praxis.proveedores.services;

import cl.praxis.proveedores.models.SupplierDTO;

import java.util.List;

public interface ISupplierService {
    public List<SupplierDTO> getAllSuppliers();
    public SupplierDTO getSupplierById(int id);
    public boolean addSupplier(SupplierDTO supplier);
    public boolean updateSupplier(SupplierDTO supplier);
    public boolean deleteSupplier(int id);
}
