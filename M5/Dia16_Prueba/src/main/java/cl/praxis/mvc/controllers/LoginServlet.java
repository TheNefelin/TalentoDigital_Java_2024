package cl.praxis.mvc.controllers;

import cl.praxis.mvc.models.UserDTO;
import cl.praxis.mvc.services.UserService;
import cl.praxis.mvc.utils.SqlResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "loginServlet", value = "/login-servlet")
public class LoginServlet extends HttpServlet {
    UserService userService;

    public void init() {
        userService = new UserService();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        SqlResponse<UserDTO> sqlResponse = userService.loginUser(email, password);

        req.setAttribute("response", sqlResponse);

        if (sqlResponse.isError())
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        else {
            HttpSession session = req.getSession();
            session.setAttribute("user", sqlResponse.getObj());
            req.getRequestDispatcher("home.jsp").forward(req, resp);
        }
    }
}
