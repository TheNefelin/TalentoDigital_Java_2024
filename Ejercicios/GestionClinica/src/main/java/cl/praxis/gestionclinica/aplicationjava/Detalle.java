package cl.praxis.gestionclinica.aplicationjava;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Detalle {
    private int edad;
    private int experiencia;
    private String especialidad;
    private String genero;
}
