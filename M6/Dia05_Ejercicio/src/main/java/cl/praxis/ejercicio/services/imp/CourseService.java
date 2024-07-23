package cl.praxis.ejercicio.services.imp;

import cl.praxis.ejercicio.entities.Course;
import cl.praxis.ejercicio.repositories.ICourseRepository;
import cl.praxis.ejercicio.services.IBaseCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService implements IBaseCRUD<Course> {
    @Autowired
    private ICourseRepository repo;

    @Override
    public List<Course> getAll() {
        return repo.findAll();
    }

    @Override
    public Course getById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Course add(Course entity) {
        return repo.save(entity);
    }

    @Override
    public Course update(int id, Course entity) {
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
