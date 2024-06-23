package cl.praxis.webapp;

import cl.praxis.classes.ValidateNaturalNumber;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ParImparServlet", value = "/parimpar")
public class ParImparServlet extends HttpServlet {

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

        if (number % 2 == 0)
            response.getWriter().append("<h1>El Número ").append(String.valueOf(number)).append(" es Par!</h1>");
        else
            response.getWriter().append("<h1>El Número ").append(String.valueOf(number)).append(" es Impar</h1>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

    public void destroy() {

    }

}
