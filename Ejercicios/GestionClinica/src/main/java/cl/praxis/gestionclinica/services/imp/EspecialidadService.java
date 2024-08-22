package cl.praxis.gestionclinica.services.imp;

import cl.praxis.gestionclinica.entities.Especialidad;
import cl.praxis.gestionclinica.repositories.IEspecialidadRepository;
import cl.praxis.gestionclinica.services.IServiceCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadService implements IServiceCRUD<Especialidad> {
    @Autowired
    IEspecialidadRepository repo;

    @Override
    public List<Especialidad> findAll() {
        return repo.findAll();
    }

    @Override
    public Especialidad findById(int id) {
        return null;
    }

    @Override
    public Especialidad create(Especialidad especialidad) {
        return null;
    }

    @Override
    public Especialidad update(Especialidad especialidad) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
