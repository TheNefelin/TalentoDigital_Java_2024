package cl.praxis.mvc.controllers;

import cl.praxis.mvc.utils.SqlResponse;
import cl.praxis.mvc.models.UserDTO;
import cl.praxis.mvc.services.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "registerServlet", value = "/register_servlet")
public class RegisterServlet extends HttpServlet {
    UserService userService;

    public void init() {
        userService = new UserService();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDTO userDTO = new UserDTO();

        userDTO.setEmail(req.getParameter("email"));
        userDTO.setPassword(req.getParameter("password1"));
        userDTO.setName(req.getParameter("name"));
        userDTO.setNick(req.getParameter("nick"));
        userDTO.setWeight(Integer.parseInt(req.getParameter("weight")));

        String password = req.getParameter("password2");
        SqlResponse<UserDTO> sqlResponse = userService.addUser(userDTO, password);

        req.setAttribute("response", sqlResponse);

        if (sqlResponse.isError())
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        else
            req.getRequestDispatcher("login.jsp").forward(req, resp);
    }
}
