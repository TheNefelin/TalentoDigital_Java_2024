package cl.praxis.dia02_actividad.servlet;

import cl.praxis.dia02_actividad.utils.General;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/ObtieneDiasMes")
public class ObtieneDiasMes extends HttpServlet {
    public ObtieneDiasMes() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int numMes = Integer.parseInt(req.getParameter("mes"));

        General monthName = new General();
        LocalDate date = LocalDate.of(LocalDate.now().getYear(), numMes, 1);

        resp.setContentType("text/html");
        resp.getWriter().append(monthName.getNombreMes(numMes-1) + " Tiene " + date.lengthOfMonth() + " Dias");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}