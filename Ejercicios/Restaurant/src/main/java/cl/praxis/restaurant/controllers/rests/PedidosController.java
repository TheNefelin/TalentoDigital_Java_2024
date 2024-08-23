package cl.praxis.restaurant.controllers.rests;

import cl.praxis.restaurant.entities.Pedido;
import cl.praxis.restaurant.services.imp.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedido")
public class PedidosController {
    @Autowired
    PedidoService pedidoService;

    @GetMapping
    public List<Pedido> getAll() {
        return pedidoService.getAll();
    }

    @GetMapping("/{id}")
    public Pedido getById(@PathVariable int id) {
        return pedidoService.getById(id);
    }

    @PostMapping
    public Pedido create(@RequestBody Pedido pedido) {
        return pedidoService.create(pedido);
    }

    @PutMapping
    public Pedido update(@RequestBody Pedido pedido) {
        return pedidoService.update(pedido);
    }

    @DeleteMapping
    public void delete(@RequestBody Pedido pedido) {
        pedidoService.delete(pedido.getId());
    }
}
