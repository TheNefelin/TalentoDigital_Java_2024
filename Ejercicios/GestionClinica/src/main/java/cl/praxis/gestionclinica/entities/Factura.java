package cl.praxis.gestionclinica.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "facturas")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "Monto", precision = 8, scale = 2)
    private BigDecimal monto;

    @Column(name = "Fecha_Pago")
    private LocalDate fechaPago;

}