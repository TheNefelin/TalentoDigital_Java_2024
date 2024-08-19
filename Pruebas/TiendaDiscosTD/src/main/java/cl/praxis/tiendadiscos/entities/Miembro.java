package cl.praxis.tiendadiscos.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "tipo_membresia_id")
    private Membresia membresia;

    @ManyToOne
    @JoinColumn(name = "genero_id")
    private Genero genero;

    @OneToMany(mappedBy = "miembro")
    private List<Venta> ventas;
}
