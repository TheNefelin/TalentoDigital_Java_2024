package cl.praxis.mvc.services.implement;

import cl.praxis.mvc.daos.implement.SuppliersDAO;
import cl.praxis.mvc.models.SupplierDTO;
import cl.praxis.mvc.services.ISuppliersService;
import cl.praxis.mvc.utils.ServiceResponse;

import java.util.List;

public class SuppliersService implements ISuppliersService {
    public SuppliersDAO suppliersDAO;

    public SuppliersService() {
        suppliersDAO = new SuppliersDAO();
    }

    @Override
    public ServiceResponse<List<SupplierDTO>> getAllSuppliers() {
        ServiceResponse<List<SupplierDTO>> serviceResponse = new ServiceResponse<>();
        serviceResponse.setError(false);
        serviceResponse.setMsg("Lista de Proveedores");
        serviceResponse.setObj(suppliersDAO.getAll());

        return serviceResponse;
    }
}
