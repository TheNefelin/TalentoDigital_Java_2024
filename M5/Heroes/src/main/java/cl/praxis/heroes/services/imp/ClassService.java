package cl.praxis.heroes.services.imp;

import cl.praxis.heroes.daos.imp.ClassDAO;
import cl.praxis.heroes.models.ClassDTO;
import cl.praxis.heroes.services.IClassService;

import java.util.List;

public class ClassService implements IClassService {
    ClassDAO classDAO = new ClassDAO();

    @Override
    public List<ClassDTO> getAllClass() {
        return classDAO.getAllClass();
    }
}
