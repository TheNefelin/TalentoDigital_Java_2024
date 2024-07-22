package cl.praxis.ejercicio.entities.others;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bomberos")
public class Firefighter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "mensaje_alarma", nullable = false, length = 256)
    private String alarm;

    @Column(name = "logar_incendio", nullable = false, length = 256)
    private String address;

    @Column(name = "fecha_inicio", nullable = false)
    private Date dateStart;

    @Column(name = "fecha_llegada")
    private Date dateArrival;

    @Column(name = "fecha_termino")
    private Date dateEnd;

    @ManyToOne
    @JoinColumn(name = "id_maniobra", nullable = false)
    private Maneuver maneuver;
}
