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
@Table(name = "dueno")
public class Dueno {
    @Id
    @Column(name = "dueno_id")
    private int id;

    @Column(name = "dueno_rut")
    private String rut;

    @Column(name = "dueno_nombre")
    private String nombre;

    @Column(name = "dueno_apellidos")
    private String apellidos;

    @Column(name = "dueno_email")
    private String email;
}
