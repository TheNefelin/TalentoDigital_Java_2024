package cl.praxis.heroes.controllers;

import cl.praxis.heroes.models.UserDTO;
import cl.praxis.heroes.services.imp.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "userRegisterServlet", value = "/user-register-servlet")
public class UserRegisterServlet extends HttpServlet {
    private UserService userService = new UserService();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String password2 = req.getParameter("password2");

        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(email);
        userDTO.setPassword(password);

        String msg = userService.register(userDTO, password2);

        if (msg.isEmpty()) {
            req.setAttribute("msg", "Usuario Creado Correctamente");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        } else {
            req.setAttribute("msg", msg);
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        }
    }
}
