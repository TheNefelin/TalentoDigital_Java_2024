package cl.praxis.veterinaria.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Sucursal {
    private int id_sucursal;
    private String nombre;
    private String direccion;
    private int telefono;
}
