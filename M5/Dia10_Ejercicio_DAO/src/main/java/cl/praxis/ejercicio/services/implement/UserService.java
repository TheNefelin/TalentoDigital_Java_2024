package cl.praxis.ejercicio.services.implement;

import cl.praxis.ejercicio.DAO.implement.UserDAO;
import cl.praxis.ejercicio.models.UserDTO;
import cl.praxis.ejercicio.services.IUserService;

import java.util.List;

public class UserService implements IUserService {
    private UserDAO userDAO;

    public UserService() {
        userDAO = new UserDAO();
    }

    @Override
    public List<UserDTO> getAll() {
        return userDAO.getAll();
    }

    @Override
    public UserDTO getById(int id) {
        return userDAO.getById(id);
    }

    @Override
    public UserDTO insert(UserDTO obj) {
        return userDAO.insert(obj);
    }

    @Override
    public UserDTO update(UserDTO obj) {
        return userDAO.update(obj);
    }

    @Override
    public boolean delete(int id) {
        return userDAO.delete(id);
    }
}
