package cl.praxis.reclamos.services.imp;

import cl.praxis.reclamos.entities.RoleEntity;
import cl.praxis.reclamos.entities.UserEntitiy;
import cl.praxis.reclamos.repositories.IUserRepository;
import cl.praxis.reclamos.services.IServiceCRUD;
import cl.praxis.reclamos.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService, IServiceCRUD<UserEntitiy> {
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;  // Esto debería funcionar si BCryptPasswordEncoder es un bean

    @Override
    public UserEntitiy register(UserEntitiy user) {
        RoleEntity role = new RoleEntity();
        role.setId(2);

        user.setRole(role);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    @Override
    public List<UserEntitiy> getAll() {
        return userRepository.findAll();
    }

    @Override
    public UserEntitiy getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public UserEntitiy create(UserEntitiy user) {
        return userRepository.save(user);
    }

    @Override
    public UserEntitiy update(UserEntitiy user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
