package cl.praxis.restaurant.appjava;

import java.util.ArrayList;
import java.util.List;

public class CalculoComplejo implements ICalculoDescuento{
    @Override
    public List<Double> calcularDescuento(List<Detalle> listaDetalle) {
        List<Double> listaDescuento = new ArrayList<>();

        for (Detalle detalle : listaDetalle) {
            if (detalle.getCantidadPlatos() > 5 && detalle.getCapacidadMesa() < 4)
                listaDescuento.add(0.15);
            else if (detalle.getCantidadPlatos() >= 5 && detalle.getCantidadPlatos() <= 15 && detalle.getCapacidadMesa() >= 4 && detalle.getCapacidadMesa() <= 6)
                listaDescuento.add(0.2);
            else if (detalle.getCantidadPlatos() > 15 && detalle.getCapacidadMesa() > 6)
                listaDescuento.add(0.3);
            else if (detalle.getCantidadPlatos() > 5 && detalle.getCapacidadMesa() == 2)
                listaDescuento.add(0.15);
            else if (detalle.getCantidadPlatos() < 5 && detalle.getCapacidadMesa() <= 4)
                listaDescuento.add(0.0);
        }

        return listaDescuento;
    }
}
