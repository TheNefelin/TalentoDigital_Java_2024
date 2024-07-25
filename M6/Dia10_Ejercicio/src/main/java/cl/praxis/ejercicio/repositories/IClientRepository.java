package cl.praxis.ejercicio.repositories;

import cl.praxis.ejercicio.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository extends JpaRepository<Client, Integer> {
}
