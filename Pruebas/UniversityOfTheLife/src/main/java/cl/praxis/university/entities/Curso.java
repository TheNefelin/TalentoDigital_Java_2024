package cl.praxis.university.entities;

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
@Table(name = "curso")
public class Curso {
    @Id
    @Column(name = "curso_id")
    private int id;

    @Column(name = "curso_descripcion")
    private String name;

    @Column(name = "especialidad_id")
    private int idEspecialidad;

    @Column(name = "profesor_id")
    private int idProfesor;
}
