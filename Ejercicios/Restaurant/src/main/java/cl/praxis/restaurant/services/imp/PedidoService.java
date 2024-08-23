package cl.praxis.restaurant.services.imp;

import cl.praxis.restaurant.entities.Pedido;
import cl.praxis.restaurant.repository.IPedidoRepository;
import cl.praxis.restaurant.services.IServiceCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PedidoService implements IServiceCRUD<Pedido> {
    @Autowired
    IPedidoRepository pedidoRepository;

    @Override
    public List<Pedido> getAll() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido getById(int id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    @Override
    public Pedido create(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido update(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public void delete(int id) {
        pedidoRepository.deleteById(id);
    }
}
