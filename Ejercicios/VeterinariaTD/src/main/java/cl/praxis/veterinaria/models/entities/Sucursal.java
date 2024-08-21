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
@Table(name = "sucursal")
public class Sucursal {
    @Id
    @Column(name = "sucursal_id")
    private int id;

    @Column(name = "sucursal_nombre")
    private String nombre;

    @Column(name = "sucursal_direccion")
    private String direccion;

    @Column(name = "sucursal_telefono")
    private int telefono;
}
