package cl.praxis.heroes.controllers;

import cl.praxis.heroes.models.UserDTO;
import cl.praxis.heroes.services.imp.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "userLoginServlet", value = "/user-login-servlet")
public class UserLoginServlet extends HttpServlet {
    UserService userService = new UserService();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(email);
        userDTO.setPassword(password);

        userDTO = userService.login(userDTO);

        if (userDTO.getId() > 0) {
            HttpSession session = req.getSession();
            session.setAttribute("user", userDTO);

            req.getRequestDispatcher("hero-servlet").forward(req, resp);
        } else {
            req.setAttribute("msgLogin", "Usuario o Contraseña Incorrecta");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
