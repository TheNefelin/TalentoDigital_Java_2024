package cl.praxis.ejercicio.services.imp;

import cl.praxis.ejercicio.entities.User;
import cl.praxis.ejercicio.repositories.IUserRepository;
import cl.praxis.ejercicio.services.IBaseServiceCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IBaseServiceCRUD<User> {
    @Autowired
    private IUserRepository repo;

    @Override
    public List<User> getAll() {
        return repo.findAll();
    }

    @Override
    public User getById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public User create(User user) {
        return repo.save(user);
    }

    @Override
    public User update(User user) {
        if (repo.existsById(user.getId())) {
            return repo.save(user);
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
