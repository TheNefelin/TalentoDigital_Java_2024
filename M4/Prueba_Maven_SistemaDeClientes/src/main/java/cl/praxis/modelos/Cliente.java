package cl.praxis.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    private int run;
    private String nombre;
    private String apellido;
    private int anios;
    private CategoriaEnum categoria;
}
