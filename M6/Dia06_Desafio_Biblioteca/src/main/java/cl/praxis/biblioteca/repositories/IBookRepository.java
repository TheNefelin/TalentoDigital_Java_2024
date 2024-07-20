package cl.praxis.biblioteca.repositories;

import cl.praxis.biblioteca.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Integer> {
}
