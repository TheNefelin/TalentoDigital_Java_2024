package cl.praxis.webapp;

import cl.praxis.classes.ValidateNaturalNumber;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "FactorialServlet", value = "/factorial")
public class FactorialServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String numberStr = request.getParameter("number");
        response.setContentType("text/html");
        int number;

        ValidateNaturalNumber validar = new ValidateNaturalNumber(numberStr);
        if (!validar.isValid()) {
            response.getWriter().append("<p>").append(validar.getMessage()).append("</p>");
            return;
        }
        number = validar.getNatularNumber();

        response.getWriter().append("<h1>El Número Factorial de: ").append(String.valueOf(number)).append("!</h1>");

        if (number == 0 || number == 1) {
            response.getWriter().append("<div>(0) Factorial: 1</div>");
            return;
        }

        String msge = "1";
        int resultado = 1;

        for (int i = 2; i <= number; i++) {
            msge = msge + " x " + i;
            resultado = resultado * i;
        }

        response.getWriter().append("<div>Factorial: ").append(msge).append(" = ").append(String.valueOf(resultado)).append("</div>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

    public void destroy() {

    }
}
