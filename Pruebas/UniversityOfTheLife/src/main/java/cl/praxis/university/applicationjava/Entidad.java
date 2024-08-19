package cl.praxis.university.applicationjava;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Entidad {
    private int id;
    private String nombre;
    private String apellido;
    private double nota;
    private String curso;
    private int idEspecialidad;
    private String especialidad;
}
