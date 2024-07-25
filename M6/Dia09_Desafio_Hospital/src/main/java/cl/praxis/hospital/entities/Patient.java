package cl.praxis.hospital.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pacientes")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String name;

    @Column(name = "apellido", nullable = false, length = 50)
    private String surname;

    @Column(name = "admision", nullable = false)
    private LocalDate admission;

    @Column(name = "diagnostico", nullable = false, length = 100)
    private String diagnosis;

    @Column(name = "habitacion", nullable = false, length = 50)
    private String room;

    @Column(name = "cama", nullable = false)
    private int bed;
}
