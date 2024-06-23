package cl.praxis.servlets;

import cl.praxis.utils.General;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/ObtenerEfemerides")
public class ObtenerEfemerides extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ObtenerEfemerides() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int numMes = Integer.parseInt(request.getParameter("mes"));

        General utilesgeneral = new General();
        String efemedires =  utilesgeneral.getEfemeridesMes(numMes);

        response.getWriter().append(efemedires);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
