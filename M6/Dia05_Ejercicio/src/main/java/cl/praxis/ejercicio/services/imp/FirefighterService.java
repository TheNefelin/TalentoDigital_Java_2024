package cl.praxis.ejercicio.services.imp;

import cl.praxis.ejercicio.entities.Firefighter;
import cl.praxis.ejercicio.services.IBaseCRUD;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FirefighterService implements IBaseCRUD<Firefighter> {
    @Override
    public List<Firefighter> getAll() {
        return List.of();
    }

    @Override
    public Firefighter getById(int id) {
        return null;
    }

    @Override
    public Firefighter add(Firefighter entity) {
        return null;
    }

    @Override
    public Firefighter update(int id, Firefighter entity) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
