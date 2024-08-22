package cl.praxis.gestionclinica.repositories;

import cl.praxis.gestionclinica.entities.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEspecialidadRepository extends JpaRepository<Especialidad, Integer> {
}
