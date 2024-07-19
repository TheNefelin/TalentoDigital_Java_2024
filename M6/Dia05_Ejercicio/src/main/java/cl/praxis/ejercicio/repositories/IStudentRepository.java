package cl.praxis.ejercicio.repositories;

import cl.praxis.ejercicio.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student, Integer> {
}
