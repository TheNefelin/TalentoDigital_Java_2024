package cl.praxis.gestionclinica.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "historia_clinica")
public class HistoriaClinica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Paciente_ID")
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Doctor_ID")
    private Doctor doctor;

    @Column(name = "Fecha_Cita")
    private LocalDate fechaCita;

    @Lob
    @Column(name = "Sintomas")
    private String sintomas;

    @Lob
    @Column(name = "Diagnostico")
    private String diagnostico;

    @Lob
    @Column(name = "Tratamiento")
    private String tratamiento;

}