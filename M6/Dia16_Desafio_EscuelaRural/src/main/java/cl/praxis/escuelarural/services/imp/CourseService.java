package cl.praxis.escuelarural.services.imp;

import cl.praxis.escuelarural.entities.Course;
import cl.praxis.escuelarural.repositories.ICourseRepository;
import cl.praxis.escuelarural.services.IBaseServiceCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService implements IBaseServiceCRUD<Course> {
    @Autowired
    private ICourseRepository repository;

    @Autowired
    private StudentService studentService;

    @Override
    public List<Course> getAll() {
        return repository.findAll();
    }

    @Override
    public Course getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Course create(Course course) {
        return repository.save(course);
    }

    @Override
    public Course update(Course course) {
        return repository.save(course);
    }

    @Override
    public boolean delete(Long id) {
        Course course = repository.findById(id).orElse(null);
        if (course != null && !course.getStudent().isEmpty()) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}
