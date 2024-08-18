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
@Table(name = "medico")
public class Medico {
    @Id
    @Column(name = "medico_id ")
    private int id;

    @Column(name = "medico_rut")
    private String rut;

    @Column(name = "medico_nombre")
    private String nombre;

    @Column(name = "medico_apellidos")
    private String apellido;

    @Column(name = "medico_email")
    private String email;
}

