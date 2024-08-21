package cl.praxis.gestionclinica.aplicationjava;

import java.util.ArrayList;
import java.util.List;

public class CalculoComplejo implements ICalculoDescuento {

    @Override
    public List<Double> calculoDescuento(List<Detalle> detalles) {
        List<Double> descuentos = new ArrayList<>();

        for (Detalle detalle : detalles) {
            if (detalle.getExperiencia() < 10) {
               descuentos.add(0.15);
            } else if (detalle.getExperiencia() <= 20 && (detalle.getEspecialidad().equals("Cardiólogo") || detalle.getEspecialidad().equals("Neurólogo"))) {
                descuentos.add(0.05);
            } else if (detalle.getEspecialidad().equals("Endocrinólogo") || detalle.getEspecialidad().equals("Oncólogo")) {
                descuentos.add(0.10);
            } else if (detalle.getEspecialidad().equals("Dermatólogo")) {
                descuentos.add(0.0);
            } else if(detalle.getExperiencia() > 20) {
                descuentos.add(0.05);
            }
        }

        return descuentos;
    }
}
