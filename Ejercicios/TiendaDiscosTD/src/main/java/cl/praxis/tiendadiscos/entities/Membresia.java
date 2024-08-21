package cl.praxis.tiendadiscos.entities;

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
@Table(name = "tipo_membresia")
public class Membresia {
    @Id
    @Column(name = "tipo_membresia_id")
    private int id;

    @Column(name = "tipo_membresia_descripcion")
    private String nombre;
}
