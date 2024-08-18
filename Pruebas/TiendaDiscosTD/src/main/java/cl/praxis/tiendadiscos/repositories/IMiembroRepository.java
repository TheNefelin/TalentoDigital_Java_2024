package cl.praxis.tiendadiscos.repositories;

import cl.praxis.tiendadiscos.entities.Miembro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMiembroRepository extends JpaRepository<Miembro, Integer> {
    //List<Miembro> findAllByIdSucursalAndIdMembresia(int IdSucursal, int IdMembresia);
}
