package cl.praxis.veterinaria.repositories;

import cl.praxis.veterinaria.models.entities.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISucursalRepository extends JpaRepository<Sucursal, Integer> {
}
