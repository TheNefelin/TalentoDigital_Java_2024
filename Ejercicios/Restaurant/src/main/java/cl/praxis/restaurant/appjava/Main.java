package cl.praxis.restaurant.appjava;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Detalle> detalles = new ArrayList<>();
        detalles.add(new Detalle(2, 2, "Plato Principal"));
        detalles.add(new Detalle(6, 4, "Postre"));
        detalles.add(new Detalle(7, 12, "Entrada")); // falla
        detalles.add(new Detalle(8, 16, "Entrada")); // falla
        detalles.add(new Detalle(26, 15, "Postre"));
        detalles.add(new Detalle(2, 20, "Plato Principal"));

        CalculoSimple calculoSimple = new CalculoSimple();
        CalculoComplejo calculoComplejo = new CalculoComplejo();

        System.out.println("## cálculo según cantidad y categoría del plato #########");
        System.out.println(calculoSimple.calcularDescuento(detalles));
        System.out.println("## cálculo según cantidad de platos ######################");
        System.out.println(calculoComplejo.calcularDescuento(detalles));
        System.out.println("##########################################################");
    }
}
