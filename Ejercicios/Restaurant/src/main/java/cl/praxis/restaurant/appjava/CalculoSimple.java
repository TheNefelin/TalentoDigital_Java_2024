package cl.praxis.restaurant.appjava;

import java.util.ArrayList;
import java.util.List;

public class CalculoSimple implements ICalculoDescuento{
    @Override
    public List<Double> calcularDescuento(List<Detalle> listaDetalle) {
        List<Double> listaDescuento = new ArrayList<>();

        for (Detalle detalle : listaDetalle) {
            if (detalle.getCantidadPlatos() <= 5)
                listaDescuento.add(0.0);
            else if (detalle.getCantidadPlatos() < 10 && detalle.getCategoriaPlato().equals("Entrada"))
                listaDescuento.add(0.03);
            else if (detalle.getCantidadPlatos() < 10 && detalle.getCategoriaPlato().equals("Plato Principal"))
                listaDescuento.add(0.05);
            else if (detalle.getCantidadPlatos() < 10 && detalle.getCategoriaPlato().equals("Postre"))
                listaDescuento.add(0.04);
            else if (detalle.getCantidadPlatos() >= 10 && detalle.getCantidadPlatos() <= 15)
                listaDescuento.add(0.1);
            else if (detalle.getCantidadPlatos() > 15 && detalle.getCategoriaPlato().equals("Entrada"))
                listaDescuento.add(0.15);
            else if (detalle.getCantidadPlatos() > 15 && detalle.getCategoriaPlato().equals("Plato Principal"))
                listaDescuento.add(0.30);
            else if (detalle.getCantidadPlatos() > 15 && detalle.getCategoriaPlato().equals("Postre"))
                listaDescuento.add(0.20);
        }

        return listaDescuento;
    }
}
