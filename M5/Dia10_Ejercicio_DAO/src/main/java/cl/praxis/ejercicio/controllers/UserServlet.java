package cl.praxis.ejercicio.controllers;

import cl.praxis.ejercicio.models.UserDTO;
import cl.praxis.ejercicio.services.implement.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "userServlet", value = "/user-servlet")
public class UserServlet extends HttpServlet {
    UserService userService = new UserService();
    List<UserDTO> userDTOList = new ArrayList<>();

    // Delete GetAll GetById => Edit
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action != null) {
            int id = Integer.parseInt(req.getParameter("id"));

            if (action.equals("delete")) {
                userService.delete(id);
                resp.sendRedirect(req.getContextPath() + "/user-servlet");
                return;
            } else if (action.equals("edit")) {
                UserDTO user = userService.getById(id);
                req.setAttribute("user", user);
            }
        }

        // getAll
        userDTOList = userService.getAll();
        req.setAttribute("users", userDTOList);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    // Insert y Update
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        String isActiveStr = req.getParameter("isActive");

        int id = idStr.isEmpty() ? 0 : Integer.parseInt(idStr);
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        int age = Integer.parseInt(req.getParameter("age"));

        boolean isActive;

        if (isActiveStr == null)
            isActive = false;
        else
            isActive = isActiveStr.isBlank() || isActiveStr.equals("on")? true: false;

        if (id == 0)
            userService.insert(new UserDTO(id, name, surname, email, age, isActive));
        else
            userService.update(new UserDTO(id, name, surname, email, age, isActive));

        //doGet(req, resp);
        resp.sendRedirect(req.getContextPath() + "/user-servlet");
    }
}
