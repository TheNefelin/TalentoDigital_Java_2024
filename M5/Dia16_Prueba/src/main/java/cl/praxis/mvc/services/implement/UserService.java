package cl.praxis.mvc.services.implement;

import cl.praxis.mvc.daos.implement.AddressDAO;
import cl.praxis.mvc.daos.implement.UserDAO;
import cl.praxis.mvc.daos.implement.UserRolDAO;
import cl.praxis.mvc.models.AddressDTO;
import cl.praxis.mvc.models.CarDTO;
import cl.praxis.mvc.models.UserRolDTO;
import cl.praxis.mvc.services.IUserService;
import cl.praxis.mvc.utils.ServiceResponse;
import cl.praxis.mvc.models.UserDTO;

import java.util.List;

public class UserService implements IUserService {
    private UserDAO userDAO;
    private UserRolDAO userRolDAO;
    private AddressDAO addressDAO;

    public UserService() {
        userDAO = new UserDAO();
        userRolDAO = new UserRolDAO();
        addressDAO = new AddressDAO();
    }

    @Override
    public ServiceResponse<List<UserDTO>> getAllUser() {
        ServiceResponse<List<UserDTO>> serviceResponse = new ServiceResponse<>();

        serviceResponse.setError(false);
        serviceResponse.setMsg("Lista de Autos");
        serviceResponse.setObj(userDAO.getAll());

        return serviceResponse;
    }

    @Override
    public ServiceResponse<UserDTO> addUser(UserDTO userDTO) {
        ServiceResponse<UserDTO> serviceResponse = new ServiceResponse<>();
        // indica que hay un error
        serviceResponse.setError(true);

        if (!userDTO.getPassword().equals(userDTO.getPassword2())) {
            serviceResponse.setMsg("Las Contraseñas no Coinciden!!!");
            return serviceResponse;
        }

        if (userDAO.emailExists(userDTO.getEmail())) {
            serviceResponse.setMsg("El Correo " + userDTO.getEmail() + " ya Existe!!!");
            return serviceResponse;
        }

        // crea el usuario y obtengo el id
        userDTO = userDAO.add(userDTO);

        if (userDTO.getId() == 0) {
            serviceResponse.setMsg("Error al Crear el Usuario id = " + userDTO.getId());
            return serviceResponse;
        } else
            serviceResponse.setMsg("Usuario Creado Correctamente!!!");

        // preparacion para agregar direccion
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setName(userDTO.getAddress().getName());
        addressDTO.setNumber(userDTO.getAddress().getNumber());
        addressDTO.setIdUser(userDTO.getId());

        addressDTO = addressDAO.add(addressDTO); // se guarda la direccion

        if (addressDTO.getId() == 0) {
            serviceResponse.setMsg(serviceResponse.getMsg() + " - (Usuario Creado Sin Direccion)");
        }

        // preparacion para vincular el rol con el usuario
        UserRolDTO userRolDTO = new UserRolDTO(userDTO.getId(), userDTO.getRol().getId());
        boolean isUserRolOK = userRolDAO.add(userRolDTO);

        if (!isUserRolOK) {
            serviceResponse.setMsg(serviceResponse.getMsg() + " - (Usuario Creado Sin Perfil)");
        }

        serviceResponse.setError(false);
        serviceResponse.setObj(userDTO);

        return serviceResponse;
    }

    @Override
    public ServiceResponse<UserDTO> loginUser(String email, String password) {
        ServiceResponse<UserDTO> serviceResponse = new ServiceResponse<>();
        serviceResponse.setError(true); // indica que hay un error
        serviceResponse.setObj(userDAO.userLogin(email, password));

        if (serviceResponse.getObj() == null)
            serviceResponse.setMsg("Usuario o Contraseña Incorrecta!!!");
        else if (!serviceResponse.getObj().getRol().getName().equals("Admin"))
            serviceResponse.setMsg("No Esta Autorizado para Ingresar!!!  (...trabajador)");
        else {
            serviceResponse.setError(false); // infico que NO hay un error
            serviceResponse.setMsg("Sesion iniciada Correctamente!!!");
        }

        return serviceResponse;
    }
}
