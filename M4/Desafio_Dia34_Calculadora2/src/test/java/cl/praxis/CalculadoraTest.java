package cl.praxis;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//---- TDD ----
//(Rojo): Escribir el/los test
//(Verde): Escribir codigo minimo para que el test pase (Clase)
//(Refactorización) Mejorar el codigo de la clase:
// ------------
@DisplayName("Prueba TDD Clase Calculadora")
public class CalculadoraTest {
    public Calculadora calculadora;

    @BeforeEach
    void setUp() {
        calculadora = new Calculadora();
    }

    @Test
    @DisplayName("Prueba TDD - suma de dos números")
    void testSuma() {
        int resultado = calculadora.sumar(3, 5);
        assertEquals(8, resultado, "3 + 5 = 8");
    }

    @Test
    @DisplayName("Prueba TDD - resta de dos números")
    void testResta() {
        int resultado = calculadora.restar(3, 5);
        assertEquals(-2, resultado, "3 - 5 = -2");
    }

    @Test
    @DisplayName("Prueba TDD - multiplicación de dos números")
    void testMultiplicacion() {
        int resultado = calculadora.multiplicar(3, 5);
        assertEquals(15, resultado, "3 * 5 = 15");
    }

    @Test
    @DisplayName("Prueba TDD - division de dos números")
    void testDivision() {
        double resultado = calculadora.divisao(3, 5);
        assertEquals(0.6, resultado, "3 / 5 = 0.6");
    }
}
