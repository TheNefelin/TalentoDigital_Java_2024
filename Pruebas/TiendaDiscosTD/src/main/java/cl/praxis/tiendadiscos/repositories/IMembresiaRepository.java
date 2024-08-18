package cl.praxis.tiendadiscos.repositories;

import cl.praxis.tiendadiscos.entities.Membresia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMembresiaRepository extends JpaRepository<Membresia, Integer> {
}
