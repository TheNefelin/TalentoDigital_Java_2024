package cl.praxis.gestionclinica.aplicationjava;

import java.util.ArrayList;
import java.util.List;

public class CalculoSimple implements ICalculoDescuento {
    @Override
    public List<Double> calculoDescuento(List<Detalle> detalles) {
        List<Double> descuentos = new ArrayList<>();

        for (Detalle detalle : detalles) {
            if (detalle.getEdad() <= 5) {
                descuentos.add(0.05);
            } else if (detalle.getEdad() < 13) {
                descuentos.add(0.03);
            } else if (detalle.getEdad() <= 35) {
                if (detalle.getGenero().equals("Hombre")) {
                    descuentos.add(0.0);
                } else if (detalle.getGenero().equals("Mujer")) {
                    descuentos.add(1.02);
                }
            } else if (detalle.getEdad() < 60) {
                descuentos.add(0.1);
            } else {
                if (detalle.getGenero().equals("Hombre")) {
                    descuentos.add(0.2);
                } else if (detalle.getGenero().equals("Mujer")) {
                    descuentos.add(0.3);
                }
            }
        }

        return descuentos;
    }
}
