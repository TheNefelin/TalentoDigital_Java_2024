package cl.praxis.futbol;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipoFutbol {
    private int juegosGanados;
    private int juegosEmpatados;
    private int juegosPerdidos;
}
