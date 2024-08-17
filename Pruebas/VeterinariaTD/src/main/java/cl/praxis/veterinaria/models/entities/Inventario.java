package cl.praxis.veterinaria.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Inventario {
    private int id;
    private String nombre;
    private String marca;
    private int existencia;
    private int idTipoProducto; //(1 = medicinal, 2 = accesorios)
    private int idSucursal;
}
