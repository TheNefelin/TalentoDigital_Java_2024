package cl.praxis.biblioteca.controllers.imp;

import cl.praxis.biblioteca.controllers.IBaseControllerCRUD;
import cl.praxis.biblioteca.entities.Book;
import cl.praxis.biblioteca.services.IBaseServiceCRUD;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book-controller")
public class BookRestController implements IBaseControllerCRUD<Book> {
    private final static Logger LOG = LoggerFactory.getLogger(BookRestController.class);

    @Autowired
    private IBaseServiceCRUD<Book> service;

    @GetMapping
    @Override
    public List<Book> findAll() {
        LOG.info("--> Consultando Todos los Libros");
        return service.findAll();
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Book> findById(@PathVariable int id) {
        LOG.warn("--> Consultando Libro con ID: " + id);
        Book book = service.findById(id);

        if (book != null) {
            LOG.info("--> Consulta de Libro Exitosa");
            return ResponseEntity.ok(book);
        }

        LOG.error("--> Consulta de Libro Fallida");
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Override
    public ResponseEntity<Book> create(@RequestBody Book book) {
        LOG.warn("--> Creando Nuevo Libro");
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(book));
    }

    @PutMapping
    @Override
    public ResponseEntity<Book> update(Book book) {
        LOG.warn("--> Modificando Libro");

        if (service.update(book)) {
            LOG.info("--> Libro Modificado con Exito");
            return ResponseEntity.ok(book);
        }

        LOG.error("--> Modificacion del Libro Fallida");
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> delete(@PathVariable int id) {
        LOG.warn("--> Eliminando Libro");

        if (service.delete(id)) {
            LOG.info("--> Libro Eliminado con Exito");
            return ResponseEntity.noContent().build();
        }

        LOG.error("--> Eliminacion del Libro Fallida");
        return ResponseEntity.notFound().build();
    }
}
