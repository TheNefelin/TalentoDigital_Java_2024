package cl.praxis.mvc.services.implement;

import cl.praxis.mvc.daos.implement.RolDAO;
import cl.praxis.mvc.models.RolDTO;
import cl.praxis.mvc.services.IRolService;
import cl.praxis.mvc.utils.ServiceResponse;

import java.util.List;

public class RolService implements IRolService {
    private RolDAO rolDAO;

    public RolService() {
        rolDAO = new RolDAO();
    }

    @Override
    public ServiceResponse<List<RolDTO>> getAllRoles() {
        ServiceResponse<List<RolDTO>> serviceResponse;
        serviceResponse = new ServiceResponse<>(false, "Lista de Roles", rolDAO.getAll());

        return serviceResponse;
    }
}
