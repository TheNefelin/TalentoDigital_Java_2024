package cl.praxis.services;

import java.util.LinkedHashMap;
import java.util.Map;

public class CalculatorService {
    private Map<Integer, String> operations = new LinkedHashMap<>();

    public CalculatorService() {
        operations.put(1, "Suma");
        operations.put(2, "Resta");
        operations.put(3, "Multiplicación");
        operations.put(4, "División");
        operations.put(5, "Ordenar el número");
        operations.put(6, "Cuál es par e impar");
    }

    public Map<Integer, String> getOperations() {
        return operations;
    }

    public String calculate(int num1, int num2, int operation) {
        switch (operation) {
            case 1:
                return addition(num1, num2);
            case 2:
                return subtraction(num1, num2);
            case 3:
                return multiplication(num1, num2);
            case 4:
                return division(num1, num2);
            case 5:
                return order(num1, num2);
            case 6:
                return evenOdd(num1, num2);
            default:
                return "Operación no válida";
        }
    }

    public String addition(int num1, int num2) {
        return "La suma de " + num1 + " + " + num2 + " = " + (num1 + num2);
    }

    public String subtraction(int num1, int num2) {
        return "La resta de " + num1 + " - " + num2 + " = " + (num1 - num2);
    }

    public String multiplication(int num1, int num2) {
        return "La multiplicacion de " + num1 + " * " + num2 + " = " + (num1 * num2);
    }

    public String division(int num1, int num2) {
        if (num2 == 0)
            return "Error: no se puede dividir por 0";

        return "La division de " + num1 + " / " + num2 + " = " + ((double) num1 / (double) num2);
    }

    public String order(int num1, int num2) {
        if (num1 == num2)
            return "Los numeros " + num1 + " y " + num2 + " son iguales";

        if (num1 > num2)
            return "El orden de los numeros es: " + num2 + ", " + num1;
        else
            return "El orden de los numeros es: " + num1 + ", " + num2;
    }

    public String evenOdd(int num1, int num2) {
        String str = "";

        if (num1 % 2 == 0)
            str = "El numero (" + num1 + ") es par";
        else
            str = "El numero (" + num1 + ") es impar";

        if (num2 % 2 == 0)
            str += " y El numero (" + num2 + ") es par";
        else
            str += " y El numero (" + num2 + ") es impar";

        return str;
    }
}
