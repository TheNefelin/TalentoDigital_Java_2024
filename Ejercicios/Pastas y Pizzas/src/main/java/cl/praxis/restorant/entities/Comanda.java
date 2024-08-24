package cl.praxis.restorant.entities;

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
@Table(name = "comandas")
public class Comanda {
    @Id
    @Column(name = "id_comanda")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fecha_emision")
    private LocalDate fechaEmision;

    @Column(name = "estado")
    private boolean estado;

    @Column(name = "propina_sugerida")
    private int propinaSugerida;

    @ManyToOne
    @JoinColumn(name = "id_garzon")
    private Garzon garzon;

    @ManyToOne
    @JoinColumn(name = "id_mesa")
    private Mesa mesa;

    @OneToMany(mappedBy = "idComanda")
    private List<ComandaDetalle> detalles;
}
