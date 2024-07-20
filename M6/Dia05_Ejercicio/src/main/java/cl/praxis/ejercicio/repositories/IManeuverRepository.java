package cl.praxis.ejercicio.repositories;

import cl.praxis.ejercicio.entities.Maneuver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IManeuverRepository extends JpaRepository<Maneuver, Integer> {
}
