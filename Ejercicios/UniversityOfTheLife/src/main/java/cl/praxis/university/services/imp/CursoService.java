package cl.praxis.university.services.imp;

import cl.praxis.university.entities.Curso;
import cl.praxis.university.repositories.ICursoRepository;
import cl.praxis.university.services.IServiceCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService implements IServiceCRUD<Curso> {
    @Autowired
    ICursoRepository cursoRepository;

    @Override
    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }
}
