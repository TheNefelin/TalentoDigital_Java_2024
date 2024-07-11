package cl.praxis.mvc.daos;

import cl.praxis.mvc.models.UserDTO;

import java.util.List;

public interface IUserDAO {
    public List<UserDTO> getAll();
    public UserDTO add(UserDTO dto);
    public boolean emailExists(String email);
    public UserDTO userLogin(String email, String password);
}
