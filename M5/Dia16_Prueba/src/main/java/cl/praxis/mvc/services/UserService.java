package cl.praxis.mvc.services;

import cl.praxis.mvc.daos.UserDAO;
import cl.praxis.mvc.utils.SqlResponse;
import cl.praxis.mvc.models.UserDTO;

public class UserService implements IUserService {
    private UserDAO userDAO;
    private SqlResponse<UserDTO> sqlResponse;

    public UserService() {
        userDAO = new UserDAO();
        sqlResponse = new SqlResponse();
    }

    @Override
    public SqlResponse<UserDTO> addUser(UserDTO userDTO, String password) {
        if (!userDTO.getPassword().equals(password)) {
            sqlResponse = new SqlResponse(true, "Las Contraseñas no Coinciden!!!", null);
        } else if (userDAO.emailExists(userDTO.getEmail())) {
            sqlResponse = new SqlResponse(true, "El Correo ya existe!!!", null);
        } else {
            userDTO = userDAO.add(userDTO);
            sqlResponse = new SqlResponse(false, "Usuario Creado Correctamente!!!", userDTO);
        }

        return sqlResponse;
    }

    @Override
    public SqlResponse<UserDTO> loginUser(String email, String password) {
        UserDTO userDTO = userDAO.userLogin(email, password);

        if (userDTO == null)
            sqlResponse = new SqlResponse(true, "Usuario o Contraseña Incorrecta!!!", null);
        else
            sqlResponse = new SqlResponse<>(false, "Sesion iniciada Correctamente!!!", userDTO);

        return sqlResponse;
    }
}
