package cl.praxis.veterinaria.repositories;

import cl.praxis.veterinaria.models.entities.TipoAtencion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoAtencionRepository extends JpaRepository<TipoAtencion, Integer> {
}
