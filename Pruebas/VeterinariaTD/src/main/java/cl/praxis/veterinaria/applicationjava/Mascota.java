package cl.praxis.veterinaria.applicationjava;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Mascota {
    private int id;
    private String tipo;
    private String nombre;
    private LocalDate fecha;
    private String atencion;
}
