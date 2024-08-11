package cl.praxis.inmobiliaria.entities;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "reportes")
public class ReportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "direccion", length = 256, nullable = false)
    private String address;

    @Column(name = "precio", nullable = false)
    private int price;

    @Column(name = "habitacion", nullable = false)
    private int room;

    @Column(name = "baño", nullable = false)
    private int bathroom;

    @Column(name = "imagen", length = 256, nullable = false)
    private String img;
}
