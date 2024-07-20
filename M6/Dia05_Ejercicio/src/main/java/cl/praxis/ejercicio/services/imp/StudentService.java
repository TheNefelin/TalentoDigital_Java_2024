package cl.praxis.ejercicio.services.imp;

import cl.praxis.ejercicio.entities.Student;
import cl.praxis.ejercicio.repositories.IStudentRepository;
import cl.praxis.ejercicio.services.IBaseCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IBaseCRUD<Student> {
    @Autowired
    private IStudentRepository repo;

    @Override
    public List<Student> getAll() {
        return repo.findAll();
    }

    @Override
    public Student getById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Student add(Student entity) {
        return repo.save(entity);
    }

    @Override
    public Student update(int id, Student entity) {
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
