package cl.praxis.tiendadiscos.applicationjava;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Disco {
    private int id;
    private String nombre;
    private String artista;
    private int stock;
}
