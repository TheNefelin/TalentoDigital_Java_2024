package cl.praxis.biblioteca.controllers.imp;

import cl.praxis.biblioteca.entities.Book;
import cl.praxis.biblioteca.services.IBaseServiceCRUD;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    private final static Logger LOG = LoggerFactory.getLogger(BookRestController.class);

    @Autowired
    private IBaseServiceCRUD<Book> service;

    // metodo CRUD
    @GetMapping()
    public String getAll(Model model) {
        LOG.info("--> Consultando Todos los Libros");

        model.addAttribute("libros", service.findAll());
        return "book_list";
    }

    // metodo CRUD
    @PostMapping()
    public String create(@ModelAttribute Book book) {
        LOG.warn("--> Creando Nuevo Libro");

        service.create(book);
        return "redirect:/book";
    }

    // metodo CRUD
    @PutMapping()
    public String update(@ModelAttribute Book book) {
        LOG.warn("--> Modificando Libro");
        service.update(book);

        return "redirect:/book";
    }

    // metodo CRUD
    @DeleteMapping()
    public String delete(@RequestParam int id) {
        LOG.warn("--> Eliminando Libro");

        if (service.delete(id)) {
            LOG.info("--> Libro Eliminado con Exito");
        } else {
            LOG.error("--> Eliminacion del Libro Fallida");
        }

        return "redirect:/book";
    }

    // metodo de enrutado para crear
    @GetMapping("/create")
    public String routeCreate(Model model) {
        LOG.warn("--> Enrutado para Crear Nuevo Libro");

        return "book_form";
    }

    // metodo de enrutado para modificar
    @PutMapping("/update")
    public String routeUpdate(@RequestParam int id, Model model) {
        LOG.warn("--> Enrutado para Modificar Libro");

        Book book = service.findById(id);
        System.out.println(book);
        if (book == null) {
            LOG.error("--> Libro no encontrado");
            return "redirect:/book";
        } else {
            model.addAttribute("libro", book);
            return "book_form";
        }
    }
}
