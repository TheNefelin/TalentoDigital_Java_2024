package cl.praxis.demo.repositories;

import cl.praxis.demo.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthorRepository extends JpaRepository<Author, Long> {
}
