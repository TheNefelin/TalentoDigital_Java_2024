package cl.praxis.veterinaria.repositories;

import cl.praxis.veterinaria.models.entities.Atencion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAtencionRepository extends JpaRepository<Atencion, Integer> {
    List<Atencion> findBySucursalIdAndTipoAtencionId(int idSucursal, int idTipoAtencion);
}
