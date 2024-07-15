package cl.praxis.mvc.controllers;

import cl.praxis.mvc.models.AddressDTO;
import cl.praxis.mvc.models.CarDTO;
import cl.praxis.mvc.models.RolDTO;
import cl.praxis.mvc.services.implement.CarService;
import cl.praxis.mvc.services.implement.RolService;
import cl.praxis.mvc.utils.ServiceResponse;
import cl.praxis.mvc.models.UserDTO;
import cl.praxis.mvc.services.implement.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "registerServlet", value = "/register_servlet")
public class RegisterServlet extends HttpServlet {
    UserService userService;
    CarService carService;
    RolService rolService;

    public void init() {
        userService = new UserService();
        carService = new CarService();
        rolService = new RolService();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServiceResponse<List<CarDTO>> carServiceResponse = carService.getAllCars();
        ServiceResponse<List<RolDTO>> rolServiceResponse = rolService.getAllRoles();
        ServiceResponse<List<UserDTO>> userServiceResponse = userService.getAllUser();

        req.setAttribute("cars", carServiceResponse);
        req.setAttribute("roles", rolServiceResponse);
        req.setAttribute("users", userServiceResponse);

        req.getRequestDispatcher("register.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CarDTO carDTO = new CarDTO();
        carDTO.setId(Integer.parseInt(req.getParameter("id_car")));

        RolDTO rolDTO = new RolDTO();
        rolDTO.setId(Integer.parseInt(req.getParameter("id_rol")));

        AddressDTO addressDTO  = new AddressDTO();
        addressDTO.setName(req.getParameter("address"));
        addressDTO.setNumber(Integer.parseInt(req.getParameter("address_number")));

        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(req.getParameter("email"));
        userDTO.setPassword(req.getParameter("password1"));
        userDTO.setPassword2(req.getParameter("password2"));
        userDTO.setName(req.getParameter("name"));
        userDTO.setNick(req.getParameter("nick"));
        userDTO.setWeight(Integer.parseInt(req.getParameter("weight")));
        userDTO.setCar(carDTO);
        userDTO.setRol(rolDTO);
        userDTO.setAddress(addressDTO);

        ServiceResponse<UserDTO> userServiceResponse = userService.addUser(userDTO);

        req.setAttribute("user", userServiceResponse);

        if (userServiceResponse.isError())
            //req.getRequestDispatcher("register.jsp").forward(req, resp);
            doGet(req, resp);
        else
            req.getRequestDispatcher("login.jsp").forward(req, resp);
    }
}
