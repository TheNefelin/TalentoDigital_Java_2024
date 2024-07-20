package cl.praxis.ejercicio.services.imp;

import cl.praxis.ejercicio.entities.Firefighter;
import cl.praxis.ejercicio.repositories.IFirefighterRepository;
import cl.praxis.ejercicio.services.IBaseCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FirefighterService implements IBaseCRUD<Firefighter> {
    @Autowired
    private IFirefighterRepository repo;

    @Override
    public List<Firefighter> getAll() {
        return repo.findAll();
    }

    @Override
    public Firefighter getById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Firefighter add(Firefighter entity) {
        return repo.save(entity);
    }

    @Override
    public Firefighter update(int id, Firefighter entity) {
        if (repo.existsById(id)) {
            entity.setId(id);
            return repo.save(entity);
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}
