package cl.praxis.restorant.entities;

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
@Table(name = "mesas")
public class Mesa {
    @Id
    @Column(name = "id_mesa")
    private int id;

    @Column(name = "numero_mesa")
    private int numeroMesa;

    @Column(name = "cantidad_persona")
    private int cantidadPersona;

    @Column(name = "disponible")
    private boolean disponible;
}
