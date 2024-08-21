package cl.praxis.tiendadiscos.applicationjava;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Miembro {
    private int id;
    private String nombre;
    private String apellido;
    private int idMembresia;
    private String membresia;
    private int total;
}
