package cl.praxis.webapp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "SpecificQuery", value = "/specific_query")
public class SpecificQuery extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SpecificQuery() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String valor = request.getParameter("valor");
        response.getWriter().append("Served at: ").append(request.getContextPath());
        response.getWriter().append("Served at: ").append("Ud ha seleccionado -> " + valor);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
