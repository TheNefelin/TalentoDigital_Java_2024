package cl.praxis.inmobiliaria.services.imp;

import cl.praxis.inmobiliaria.entities.UserEntity;
import cl.praxis.inmobiliaria.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("El Usuario: " + email + " No Existe"));

        return new User(userEntity.getEmail(), userEntity.getPassword(), AuthorityUtils.createAuthorityList(userEntity.getRole().getRoleEnum().name()));
    }
}
