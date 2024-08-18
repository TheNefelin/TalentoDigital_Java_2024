package cl.praxis.tiendadiscos.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "miembro")
public class Miembro {
    @Id
    @Column(name = "miembro_id")
    private int id;

    @Column(name = "miembro_nombre")
    private String nombre;

    @Column(name = "miembro_apellidos")
    private String apellido;

    @Column(name = "miembro_email")
    private String email;

    @Column(name = "miembro_fecha_nacimiento")
    private LocalDate nacimiento;

    @Column(name = "tipo_membresia_id")
    private int IdMembresia;

    @Column(name = "genero_id")
    private int idGenero;
}
