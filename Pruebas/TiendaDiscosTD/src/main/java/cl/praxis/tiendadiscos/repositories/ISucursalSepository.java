package cl.praxis.tiendadiscos.repositories;

import cl.praxis.tiendadiscos.entities.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISucursalSepository extends JpaRepository<Sucursal, Integer> {
}
