package cl.praxis.restorant.services.imp;

import cl.praxis.restorant.entities.Comanda;
import cl.praxis.restorant.repositories.IComandaRepository;
import cl.praxis.restorant.services.IServiceCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComandaService implements IServiceCRUD<Comanda> {
    @Autowired
    private IComandaRepository repo;

    @Override
    public List<Comanda> findAll() {
        return repo.findAll();
    }

    @Override
    public Comanda findById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Comanda create(Comanda comanda) {
        comanda.setId(0);
        return repo.save(comanda);
    }

    @Override
    public Comanda update(Comanda comanda) {
        return repo.save(comanda);
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }
}
