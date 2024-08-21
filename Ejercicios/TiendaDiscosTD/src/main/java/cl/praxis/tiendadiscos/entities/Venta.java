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
@Table(name = "venta_miembro")
public class Venta {
    @Id
    @Column(name = "venta_miembro_id")
    private int id;

    @Column(name = "venta_miembro_cantidad")
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "miembro_id")
    private Miembro miembro;

    @ManyToOne
    @JoinColumn(name = "sucursal_id")
    private Sucursal sucursal;

    @Column(name = "disco_id")
    private int idDisco;
}
