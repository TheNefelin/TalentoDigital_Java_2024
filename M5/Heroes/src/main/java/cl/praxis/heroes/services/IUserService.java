package cl.praxis.heroes.services;

import cl.praxis.heroes.models.UserDTO;

public interface IUserService {
    public UserDTO login(UserDTO userDTO);
    public String register(UserDTO userDTO, String password);
}
