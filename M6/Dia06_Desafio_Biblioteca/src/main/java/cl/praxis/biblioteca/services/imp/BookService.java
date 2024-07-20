package cl.praxis.biblioteca.services.imp;

import cl.praxis.biblioteca.entities.Book;
import cl.praxis.biblioteca.repositories.IBookRepository;
import cl.praxis.biblioteca.services.IBaseServiceCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBaseServiceCRUD<Book> {
    @Autowired
    private IBookRepository repo;


    @Override
    public List<Book> findAll() {
        return repo.findAll();
    }

    @Override
    public Book findById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Book create(Book book) {
        return repo.save(book);
    }

    @Override
    public boolean update(Book book) {
        if(repo.existsById(book.getId())) {
            repo.save(book);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if(repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}
