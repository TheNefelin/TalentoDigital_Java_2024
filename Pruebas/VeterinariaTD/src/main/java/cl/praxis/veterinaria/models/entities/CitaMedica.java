package cl.praxis.veterinaria.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CitaMedica {
    private int id;
    private int medicoId;
    private int sucursalId;
    private int mascotaId;
    private int tipoAtencionId;
    private LocalDate fechaAtencion;
    private LocalDate proximaFechaAtencion;
    private String boxAtencion;
}
