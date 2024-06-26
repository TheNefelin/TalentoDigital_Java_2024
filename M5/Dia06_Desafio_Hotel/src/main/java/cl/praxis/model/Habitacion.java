package cl.praxis.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Habitacion {
    private int id;
    private String nombre;
    private String descripcion;
    private String imagen;
    private int precio;
    private int habitaciones;
    private int metraje;
}
