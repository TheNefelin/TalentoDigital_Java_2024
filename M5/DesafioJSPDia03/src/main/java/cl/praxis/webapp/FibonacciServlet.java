package cl.praxis.webapp;

import cl.praxis.classes.ValidateNaturalNumber;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "FibonacciServlet", value = "/fibonacci")
public class FibonacciServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String numberStr = request.getParameter("number");
        response.setContentType("text/html");
        int n0 = 0;
        int n1 = 1;
        int n;
        int number;

        ValidateNaturalNumber validar = new ValidateNaturalNumber(numberStr);
        if (!validar.isValid()) {
            response.getWriter().append("<p>").append(validar.getMessage()).append("</p>");
            return;
        }
        number = validar.getNatularNumber();

        response.getWriter().append("<h1>El Número Fibonachi de: ").append(String.valueOf(number)).append("</h1>");

        if (number == 0) {
            response.getWriter().append("<div>(0) Fibonachi: 0</div>");
        } else {
            for (int i = 1; i <= number; i++) {
                n = n1 + n0;
                response.getWriter().append("<div>(").append(String.valueOf(i)).append(") Fibonachi: ").append(String.valueOf(n0)).append(" + ").append(String.valueOf(n1)).append(" = ").append(String.valueOf(n)).append("</div>");
                n0 = n1;
                n1 = n;
            }
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

    public void destroy() {

    }

}
