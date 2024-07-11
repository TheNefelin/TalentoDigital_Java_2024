package cl.praxis.mvc.daos;

import cl.praxis.mvc.models.SupplierDTO;

import java.util.List;

public interface ISuppliersDAO {
    public List<SupplierDTO> getAll();
}
