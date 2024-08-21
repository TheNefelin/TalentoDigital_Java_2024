package cl.praxis.veterinaria.applicationjava;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Producto {
    private int id;
    private String nombre;
    private String marca;
    private int stock;
    private int idSucursal;
}
