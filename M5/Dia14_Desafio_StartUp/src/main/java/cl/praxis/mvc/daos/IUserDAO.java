package cl.praxis.mvc.daos;

import cl.praxis.mvc.models.UserDTO;

import java.util.List;

public interface IUserDAO {
    public List<UserDTO> getAll();
    public UserDTO getById(int id);
    public UserDTO add(UserDTO dto);
    public boolean update(UserDTO dto);
    public boolean delete(int id);

    public boolean emailExists(String email);
    public UserDTO userLogin(String email, String password);
}
