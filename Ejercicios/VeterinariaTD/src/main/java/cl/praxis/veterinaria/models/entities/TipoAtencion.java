package cl.praxis.veterinaria.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tipo_atencion")
public class TipoAtencion {
    @Id
    @Column(name = "tipo_atencion_id")
    private int id;

    @Column(name = "tipo_atencion_descripcion")
    private String nombre;
}
