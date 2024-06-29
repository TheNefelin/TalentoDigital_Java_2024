package cl.praxis.app;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "loginServlet", value = "/login-servlet")
public class LoginServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if(username.equals("desafio") && password.equals("latam")) {
            Cookie cookie = new Cookie("username", username);
            resp.addCookie(cookie);
            resp.sendRedirect("exito.jsp");
        } else {
            resp.sendRedirect("error.jsp");
        }

        System.out.println("username = " + username);
        System.out.println("password = " + password);
    }

    public void destroy() { }
}
