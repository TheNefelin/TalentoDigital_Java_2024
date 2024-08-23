package cl.praxis.restaurant.entities;

import jakarta.persistence.*;
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
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

//    @Column(name = "Mesa_ID")
//    private int idMesa;

//    @Column(name = "Camarero_ID")
//    private int idCamarero;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Mesa_ID")
    private Mesa mesa;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Camarero_ID")
    private Camarero camarero;

    @Column(name = "Fecha")
    private LocalDate fecha;

    @Column(name = "Total")
    private double total;
}
