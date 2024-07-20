package cl.praxis.ejercicio.controllers;

import cl.praxis.ejercicio.App;
import cl.praxis.ejercicio.entities.Product;

import cl.praxis.ejercicio.services.imp.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supermarket")
public class ProductController {
    private final static Logger LOG = LoggerFactory.getLogger(App.class);

    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> getAll() {
        LOG.info("Cotizar Productos.");
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable int id) {
        Product product = service.getById(id);

        if (product != null) {
            LOG.info("Elegir Productos.");
            return ResponseEntity.ok(product);
        } else {
            LOG.info("No se Encontro el Producto.");
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Product> add(@RequestBody Product product) {
        Product newProduct = service.add(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable int id, @RequestBody Product product) {
        Product updatedProduct = service.update(id, product);

        if (updatedProduct != null)
            return ResponseEntity.ok(product);
        else
            return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        boolean isDeleted = service.delete(id);

        if (isDeleted)
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.notFound().build();
    }
}
