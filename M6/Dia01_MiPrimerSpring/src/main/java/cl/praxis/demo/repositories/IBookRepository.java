package cl.praxis.demo.repositories;

import cl.praxis.demo.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Integer> {
}
