package cl.praxis.veterinaria.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "mascota")
public class Mascota {
    @Id
    @Column(name = "mascota_id")
    private int id;

    @Column(name = "mascota_nombre")
    private String nombre;

    @Column(name = "mascota_raza")
    private String raza;

    @ManyToOne
    @JoinColumn(name = "dueno_id")
    private Dueno dueno;

    @Column(name = "genero_id")
    private int generoId;

    @Column(name = "tipo_mascota_id")
    private int tipoMascotaId;
}
