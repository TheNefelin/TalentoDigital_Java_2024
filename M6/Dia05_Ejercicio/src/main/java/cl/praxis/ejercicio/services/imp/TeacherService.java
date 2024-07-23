package cl.praxis.ejercicio.services.imp;

import cl.praxis.ejercicio.entities.Teacher;
import cl.praxis.ejercicio.repositories.ITeacherRepository;
import cl.praxis.ejercicio.services.IBaseCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService implements IBaseCRUD<Teacher> {
    @Autowired
    private ITeacherRepository repo;

    @Override
    public List<Teacher> getAll() {
        return repo.findAll();
    }

    @Override
    public Teacher getById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Teacher add(Teacher entity) {
        return repo.save(entity);
    }

    @Override
    public Teacher update(int id, Teacher entity) {
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
