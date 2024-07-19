package cl.praxis.demo.repositories;

import cl.praxis.demo.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRollRepository extends JpaRepository<Rol, Integer> {
}
