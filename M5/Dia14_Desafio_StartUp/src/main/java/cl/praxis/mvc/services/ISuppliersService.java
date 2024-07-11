package cl.praxis.mvc.services;

import cl.praxis.mvc.models.SupplierDTO;
import cl.praxis.mvc.utils.ServiceResponse;

import java.util.List;

public interface ISuppliersService {
    public ServiceResponse<List<SupplierDTO>> getAllSuppliers();
}
