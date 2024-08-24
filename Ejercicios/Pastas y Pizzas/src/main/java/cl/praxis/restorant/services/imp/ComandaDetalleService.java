package cl.praxis.restorant.services.imp;

import cl.praxis.restorant.entities.ComandaDetalle;
import cl.praxis.restorant.repositories.IComandaDetalleRepository;
import cl.praxis.restorant.services.IComandaDetalleService;
import cl.praxis.restorant.services.IServiceCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComandaDetalleService implements IComandaDetalleService, IServiceCRUD<ComandaDetalle> {
    @Autowired
    private IComandaDetalleRepository repo;

    @Override
    public List<ComandaDetalle> findByIdComanda(int idComanda) {
        return repo.findByIdComanda(idComanda);
    }

    @Override
    public List<ComandaDetalle> findAll() {
        return repo.findAll();
    }

    @Override
    public ComandaDetalle findById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public ComandaDetalle create(ComandaDetalle comandaDetalle) {
        comandaDetalle.setId(0);
        return repo.save(comandaDetalle);
    }

    @Override
    public ComandaDetalle update(ComandaDetalle comandaDetalle) {
        return repo.save(comandaDetalle);
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }
}
