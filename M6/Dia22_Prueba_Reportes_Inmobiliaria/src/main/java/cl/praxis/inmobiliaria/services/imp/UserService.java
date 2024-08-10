package cl.praxis.inmobiliaria.services.imp;

import cl.praxis.inmobiliaria.entities.UserEntity;
import cl.praxis.inmobiliaria.repositories.IUserRepository;
import cl.praxis.inmobiliaria.services.IServiceCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IServiceCRUD<UserEntity> {
    @Autowired
    IUserRepository userRepository;

    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public UserEntity create(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public UserEntity update(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
