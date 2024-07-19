package cl.praxis.demo.repositories;

import cl.praxis.demo.entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPublisherRepository extends JpaRepository<Publisher, Integer> {
}
