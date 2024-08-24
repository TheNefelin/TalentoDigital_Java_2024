package cl.praxis.restorant.controllers.rest;

import cl.praxis.restorant.entities.Comanda;
import cl.praxis.restorant.services.IServiceCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comanda")
public class ComandaRestController {
    @Autowired
    private IServiceCRUD<Comanda> comandaService;

    @GetMapping
    public ResponseEntity<List<Comanda>> getAll() {
        List<Comanda> comanda = comandaService.findAll();
        if (comanda.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(comanda);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comanda> getById(@PathVariable int id) {
        if (id <= 0)
            return ResponseEntity.badRequest().build();

        Comanda comanda = comandaService.findById(id);
        if (comanda == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(comanda);
    }

    @PostMapping
    public ResponseEntity<Comanda> create(@RequestBody Comanda comanda) {
        Comanda created = comandaService.create(comanda);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping
    public ResponseEntity<Comanda> update(@RequestBody Comanda comanda) {
        Comanda updated = comandaService.update(comanda);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody Comanda comanda) {
        comandaService.delete(comanda.getId());
        return ResponseEntity.noContent().build();
    }
}
