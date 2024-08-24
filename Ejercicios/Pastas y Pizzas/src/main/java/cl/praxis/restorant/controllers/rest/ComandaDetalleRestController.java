package cl.praxis.restorant.controllers.rest;

import cl.praxis.restorant.entities.ComandaDetalle;
import cl.praxis.restorant.services.IServiceCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalle")
public class ComandaDetalleRestController {
    @Autowired
    private IServiceCRUD<ComandaDetalle> comandaDetalleService;

    @GetMapping
    public ResponseEntity<List<ComandaDetalle>> getAll() {
        List<ComandaDetalle> detalles = comandaDetalleService.findAll();
        if (detalles.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(detalles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComandaDetalle> getById(@PathVariable int id) {
        if (id <= 0)
            return ResponseEntity.badRequest().build();

        ComandaDetalle comandaDetalle = comandaDetalleService.findById(id);
        if (comandaDetalle == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(comandaDetalle);
    }

    @PostMapping
    public ResponseEntity<ComandaDetalle> create(@RequestBody ComandaDetalle comandaDetalle) {
        ComandaDetalle created = comandaDetalleService.create(comandaDetalle);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping
    public ResponseEntity<ComandaDetalle> update(@RequestBody ComandaDetalle comandaDetalle) {
        ComandaDetalle updated = comandaDetalleService.update(comandaDetalle);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody ComandaDetalle comandaDetalle) {
        comandaDetalleService.delete(comandaDetalle.getId());
        return ResponseEntity.noContent().build();
    }
}
