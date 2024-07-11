package cl.praxis.mvc.services;

import cl.praxis.mvc.models.RolDTO;
import cl.praxis.mvc.utils.ServiceResponse;

import java.util.List;

public interface IRolService {
    public ServiceResponse<List<RolDTO>> getAllRoles();
}
