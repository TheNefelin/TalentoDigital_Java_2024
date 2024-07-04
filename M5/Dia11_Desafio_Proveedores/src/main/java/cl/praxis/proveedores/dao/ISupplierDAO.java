package cl.praxis.proveedores.dao;

import java.util.List;

public interface ISupplierDAO {
    public List<SupplierDAO> getAllSuppliers();
    public SupplierDAO getSupplierById(int id);
    public boolean addSupplier(SupplierDAO supplier);
    public boolean updateSupplier(SupplierDAO supplier);
    public boolean deleteSupplier(int id);
}
