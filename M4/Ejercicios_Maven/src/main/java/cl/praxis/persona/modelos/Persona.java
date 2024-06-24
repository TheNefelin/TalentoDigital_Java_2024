package cl.praxis.persona.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Persona {
    private String rut;
    private String nombre;
}
