package cl.praxis.gestionclinica.aplicationjava;

import java.util.List;

public interface ICalculoDescuento {
    List<Double> calculoDescuento(List<Detalle> detalles);
}
