package cl.praxis.veterinaria.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Mascota {
    private int id;
    private String nombre;
    private String raza;
    private String duenio;
    private String genero;
    private String tipoMascota;
}
