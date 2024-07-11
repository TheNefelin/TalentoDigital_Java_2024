package cl.praxis.mvc.controllers;

import cl.praxis.mvc.models.SupplierDTO;
import cl.praxis.mvc.models.UserDTO;
import cl.praxis.mvc.services.implement.SuppliersService;
import cl.praxis.mvc.services.implement.UserService;
import cl.praxis.mvc.utils.ServiceResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "loginServlet", value = "/login-servlet")
public class LoginServlet extends HttpServlet {
    UserService userService;
    SuppliersService suppliersService;

    public void init() {
        userService = new UserService();
        suppliersService = new SuppliersService();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        ServiceResponse<UserDTO> userServiceResponse = userService.loginUser(email, password);
        req.setAttribute("user", userServiceResponse);

        if (userServiceResponse.isError())
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        else {
            //HttpSession session = req.getSession();
            //session.setAttribute("user", userServiceResponse);

            ServiceResponse<List<UserDTO>> allUserServiceResponse = userService.getAllUser();
            ServiceResponse<List<SupplierDTO>> suppliersServiceResp = suppliersService.getAllSuppliers();

            req.setAttribute("users", allUserServiceResponse);
            req.setAttribute("suppliers", suppliersServiceResp);

            req.getRequestDispatcher("home.jsp").forward(req, resp);
        }
    }
}
