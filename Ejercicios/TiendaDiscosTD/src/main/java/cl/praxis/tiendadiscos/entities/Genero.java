package cl.praxis.tiendadiscos.entities;

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
@Table(name = "genero")
public class Genero {
    @Id
    @Column(name = "genero_id")
    private int id;

    @Column(name = "genero_descripcion")
    private String nombre;
}
