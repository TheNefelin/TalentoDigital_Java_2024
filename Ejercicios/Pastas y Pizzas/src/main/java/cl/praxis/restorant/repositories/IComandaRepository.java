package cl.praxis.restorant.repositories;

import cl.praxis.restorant.entities.Comanda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IComandaRepository extends JpaRepository<Comanda, Integer> {
}
