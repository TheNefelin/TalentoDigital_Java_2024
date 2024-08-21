package cl.praxis.gestionclinica.aplicationjava;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Detalle> detalles = new ArrayList<>();
        detalles.add(new Detalle(3, 12, "Cardiólogo", "Hombre"));
        detalles.add(new Detalle(3, 7, "Neurólogo", "Hombre"));
        detalles.add(new Detalle(15, 20, "Neurólogo", "Mujer"));
        detalles.add(new Detalle(15, 20, "Endocrinólogo", "Mujer"));
        detalles.add(new Detalle(60, 8, "Endocrinólogo", "Hombre"));
        detalles.add(new Detalle(60, 16, "Oncólogo", "Mujer"));
        detalles.add(new Detalle(60, 10, "Oncólogo", "Mujer"));
        detalles.add(new Detalle(24, 30, "Dermatólogo", "Hombre"));

        CalculoSimple calculoSimple = new CalculoSimple();
        CalculoComplejo calculoComplejo = new CalculoComplejo();

        System.out.println("### Calculo Simple ##########################");
        System.out.println(calculoSimple.calculoDescuento(detalles));
        System.out.println("### Calculo Complejo ########################");
        System.out.println(calculoComplejo.calculoDescuento(detalles));
        System.out.println("#############################################");
    }
}
