package cl.praxis.ejercicio.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "autos")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "marca", nullable = false, length = 50)
    private String brand;

    @Column(name = "modelo", nullable = false, length = 50)
    private String model;

    @Column(name = "velocidad", nullable = false)
    private Float speed;

    @Column(name = "color", nullable = false, length = 50)
    private String color;

    @Column(name = "valor", nullable = false)
    private Float worth;

    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "fecha_modificacion", nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
