package cl.praxis.restaurant.appjava;

import java.util.List;

public interface ICalculoDescuento {
    List<Double> calcularDescuento(List<Detalle> listaDetalle);
}
