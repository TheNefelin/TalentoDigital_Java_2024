package cl.praxis.veterinaria.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Medico {
    private int id;
    private String run;
    private String nombre;
    private String apellido;
    private String email;
}
