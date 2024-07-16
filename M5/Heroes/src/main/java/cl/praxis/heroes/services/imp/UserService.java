package cl.praxis.heroes.services.imp;

import cl.praxis.heroes.daos.imp.UserDAO;
import cl.praxis.heroes.models.UserDTO;
import cl.praxis.heroes.services.IUserService;

public class UserService implements IUserService {
    UserDAO userDAO = new UserDAO();

    @Override
    public UserDTO login(UserDTO userDTO) {
        return userDAO.login(userDTO);
    }

    @Override
    public String register(UserDTO userDTO, String password2) {
        // valida las contraseñas
        if (!userDTO.getPassword().equals(password2))
            return "Las Contraseñas no Coinciden";

        // valida el correo
        boolean exist = userDAO.validateUser(userDTO.getEmail());
        if (exist)
            return "El Correo ya Existe";

        userDTO = userDAO.addUser(userDTO);

        return "";
    }
}
