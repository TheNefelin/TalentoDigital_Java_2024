package cl.praxis.restaurant.appjava;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Detalle {
    private int cantidadPlatos;
    private int capacidadMesa;
    private String categoriaPlato;
}
