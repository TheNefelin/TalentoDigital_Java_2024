package cl.praxis.university.services.imp;

import cl.praxis.university.entities.Especialidad;
import cl.praxis.university.repositories.IEspecialidadRepository;
import cl.praxis.university.services.IServiceCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadService implements IServiceCRUD<Especialidad> {
    @Autowired
    IEspecialidadRepository especialidadRepository;

    @Override
    public List<Especialidad> findAll() {
        return especialidadRepository.findAll();
    }
}
