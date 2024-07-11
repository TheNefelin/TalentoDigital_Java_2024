package cl.praxis.mvc.services;

import cl.praxis.mvc.utils.ServiceResponse;
import cl.praxis.mvc.models.UserDTO;

import java.util.List;

public interface IUserService {
    public ServiceResponse<List<UserDTO>> getAllUser();
    public ServiceResponse<UserDTO> addUser(UserDTO dto);
    public ServiceResponse<UserDTO> loginUser(String email, String password);
}
