package cl.praxis.webapp;

import cl.praxis.models.Calculator;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "CalculatorServlet", value = "/calculator-servlet")
public class CalculatorServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int number1 = validateInt(req.getParameter("number1"));
        int number2 = validateInt(req.getParameter("number2"));
        int operation = validateInt(req.getParameter("operation"));

        Calculator calculator = new Calculator();

        System.out.println(calculator.calculate(number1, number2, operation));

        req.setAttribute("strResponse", calculator.calculate(number1, number2, operation));
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    private int validateInt(String num) {
        if (num.isBlank())
            return 0;
        try {
            return Integer.parseInt(num);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public void destroy() { }
}
