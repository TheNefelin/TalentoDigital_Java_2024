package cl.praxis.ejercicio.services.imp;

import cl.praxis.ejercicio.entities.Maneuver;
import cl.praxis.ejercicio.repositories.IManeuverRepository;
import cl.praxis.ejercicio.services.IBaseCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManeuverService implements IBaseCRUD<Maneuver> {
    @Autowired
    private IManeuverRepository repo;

    @Override
    public List<Maneuver> getAll() {
        return repo.findAll();
    }

    @Override
    public Maneuver getById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Maneuver add(Maneuver entity) {
        return repo.save(entity);
    }

    @Override
    public Maneuver update(int id, Maneuver entity) {
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
