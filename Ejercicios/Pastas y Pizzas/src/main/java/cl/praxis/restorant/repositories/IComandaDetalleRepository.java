package cl.praxis.restorant.repositories;

import cl.praxis.restorant.entities.ComandaDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IComandaDetalleRepository extends JpaRepository<ComandaDetalle, Integer> {
    List<ComandaDetalle> findByIdComanda(int idComanda);
}
