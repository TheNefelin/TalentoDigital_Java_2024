package cl.praxis;

public class Calculadora {
    public int suma(int a, int b) {
        return a + b;
    }

    public int resta(int a, int b) {
        return a - b;
    }

    public int multiplica(int a, int b) {
        return a * b;
    }

    public float division(int a, int b) {
        if (b == 0)
            throw new ArithmeticException("Division by zero");
        return  (float) a / b;
    }
}
