package cl.praxis.heroes.daos;

import cl.praxis.heroes.models.UserDTO;

public interface IUserDAO {
    public boolean validateUser(String email);
    public UserDTO addUser(UserDTO user);
    public UserDTO login(UserDTO user);
}
