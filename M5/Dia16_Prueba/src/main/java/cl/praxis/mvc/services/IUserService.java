package cl.praxis.mvc.services;

import cl.praxis.mvc.utils.SqlResponse;
import cl.praxis.mvc.models.UserDTO;

public interface IUserService {

    public SqlResponse<UserDTO> addUser(UserDTO dto, String password);
    public SqlResponse<UserDTO> loginUser(String email, String password);

}
