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
@Table(name = "sucursal")
public class Sucursal {
    @Id
    @Column(name = "sucursal_id")
    private int id;

    @Column(name = "sucursal_descripcion")
    private String nombre;
}
