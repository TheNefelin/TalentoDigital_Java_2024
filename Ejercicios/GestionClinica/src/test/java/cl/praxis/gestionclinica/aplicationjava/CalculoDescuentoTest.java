package cl.praxis.gestionclinica.aplicationjava;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculoDescuentoTest {
    public static List<Detalle> detalles = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        detalles.clear();
        detalles.add(new Detalle(3, 12, "Cardiólogo", "Hombre"));
        detalles.add(new Detalle(3, 7, "Neurólogo", "Hombre"));
        detalles.add(new Detalle(15, 20, "Neurólogo", "Mujer"));
        detalles.add(new Detalle(15, 20, "Endocrinólogo", "Mujer"));
        detalles.add(new Detalle(60, 8, "Endocrinólogo", "Hombre"));
        detalles.add(new Detalle(60, 16, "Oncólogo", "Mujer"));
        detalles.add(new Detalle(60, 10, "Oncólogo", "Mujer"));
        detalles.add(new Detalle(24, 30, "Dermatólogo", "Hombre"));
    }

    @Test
    public void testCalculoSimple() {
        ICalculoDescuento calculoSimple = new CalculoSimple();

        List<Double> descuentoResult = calculoSimple.calculoDescuento(detalles);
        List<Double> listaEsperada = Arrays.asList(0.05, 0.05, 1.02, 1.02, 0.2, 0.3, 0.3, 0.0);

        assertEquals(descuentoResult, listaEsperada);
    }

    @Test
    public void testCalculoComplejo() {
        ICalculoDescuento calculoComplejo = new CalculoComplejo();

        List<Double> descuentoResult = calculoComplejo.calculoDescuento(detalles);
        List<Double> listaEsperada = Arrays.asList(0.05, 0.15, 0.05, 0.1, 0.15, 0.1, 0.1, 0.0);

        assertEquals(descuentoResult, listaEsperada);
    }
}
