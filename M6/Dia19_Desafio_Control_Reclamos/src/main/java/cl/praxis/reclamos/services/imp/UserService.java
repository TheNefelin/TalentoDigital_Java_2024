package cl.praxis.reclamos.services.imp;

import cl.praxis.reclamos.entities.Role;
import cl.praxis.reclamos.entities.User;
import cl.praxis.reclamos.repositories.IUserRepository;
import cl.praxis.reclamos.services.IServiceCRUD;
import cl.praxis.reclamos.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService, IServiceCRUD<User> {
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;  // Esto debería funcionar si BCryptPasswordEncoder es un bean

    @Override
    public User register(User user) {
        Role role = new Role();
        role.setId(2);

        user.setRole(role);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
