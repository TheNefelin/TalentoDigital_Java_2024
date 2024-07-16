package cl.praxis.persona.repositories;

import cl.praxis.persona.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonRepository extends JpaRepository<Person, Integer> {
}
