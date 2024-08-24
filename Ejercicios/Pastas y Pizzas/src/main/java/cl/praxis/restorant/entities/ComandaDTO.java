package cl.praxis.restorant.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ComandaDTO {
    private int id;
    private LocalDate fecha;
    private boolean estado;
    private int propinaSugerida;
    private int idGarzon;
    private int idMesa;
}
