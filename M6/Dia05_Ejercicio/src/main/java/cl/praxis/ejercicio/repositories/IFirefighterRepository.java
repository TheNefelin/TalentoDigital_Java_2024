package cl.praxis.ejercicio.repositories;

import cl.praxis.ejercicio.entities.Firefighter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFirefighterRepository extends JpaRepository<Firefighter, Integer> {
}
