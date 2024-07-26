package cl.praxis.ejercicio.repositories;

import cl.praxis.ejercicio.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarRepository extends JpaRepository<Car, Long> {
}
