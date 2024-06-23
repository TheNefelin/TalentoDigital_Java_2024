package cl.praxis.servlets;

import cl.praxis.utils.General;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ObtieneCantidadFeriadosMes")
public class ObtieneCantidadFeriadosMes extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private List<LocalDate> feriados;

    public ObtieneCantidadFeriadosMes() {
        super();
        int anio = LocalDate.now().getYear();

        feriados = new ArrayList<>();
        feriados.add(LocalDate.of(anio, Month.JANUARY, 1)); // Año Nuevo
        feriados.add(LocalDate.of(anio, Month.MARCH, 29)); // Viernes Santo
        feriados.add(LocalDate.of(anio, Month.MARCH, 30)); // Sábado Santo
        feriados.add(LocalDate.of(anio, Month.MAY, 1)); // Día del Trabajador
        feriados.add(LocalDate.of(anio, Month.MAY, 21)); // Día de las Glorias Navales
        feriados.add(LocalDate.of(anio, Month.JUNE, 24)); // Día Nacional de los Pueblos Indígenas
        feriados.add(LocalDate.of(anio, Month.JUNE, 29)); // San Pedro y San Pablo
        feriados.add(LocalDate.of(anio, Month.JULY, 16)); // Día de la Virgen del Carmen
        feriados.add(LocalDate.of(anio, Month.AUGUST, 15)); // Asunción de la Virgen
        feriados.add(LocalDate.of(anio, Month.SEPTEMBER, 18)); // Independencia Nacional
        feriados.add(LocalDate.of(anio, Month.SEPTEMBER, 19)); // Día de las Glorias del Ejército
        feriados.add(LocalDate.of(anio, Month.OCTOBER, 12)); // Encuentro de Dos Mundos
        feriados.add(LocalDate.of(anio, Month.OCTOBER, 31)); // Día de las Iglesias Evangélicas y Protestantes
        feriados.add(LocalDate.of(anio, Month.NOVEMBER, 1)); // Día de Todos los Santos
        feriados.add(LocalDate.of(anio, Month.DECEMBER, 8)); // Inmaculada Concepción
        feriados.add(LocalDate.of(anio, Month.DECEMBER, 25)); // Navidad
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int numMes = Integer.parseInt(request.getParameter("mes"));

        long feriadosEnMes = feriados.stream().filter(date -> date.getMonth() == Month.of(numMes)).count();

        General mes = new General();

        response.setContentType("text/plain");
        response.getWriter().println("El mes de " + mes.getNombreMes(numMes-1) + " tiene " + feriadosEnMes + " feriados.");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
