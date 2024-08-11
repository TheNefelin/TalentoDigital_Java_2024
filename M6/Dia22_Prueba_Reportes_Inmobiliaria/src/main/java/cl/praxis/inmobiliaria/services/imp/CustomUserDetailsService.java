package cl.praxis.inmobiliaria.services.imp;

import cl.praxis.inmobiliaria.entities.UserEntity;
import cl.praxis.inmobiliaria.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username).orElseThrow(() -> new  UsernameNotFoundException("El Usuario: " + username + " No Existe"));

        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();

        userEntity.getRoles()
                .forEach(role -> authorityList.add(new SimpleGrantedAuthority("ROLE_".concat(role.getRoleEnum().name()))));

        userEntity.getRoles()
                .stream().flatMap(role -> role.getPermissions().stream())
                .forEach(permission -> authorityList.add(new SimpleGrantedAuthority(permission.getPermissionEnum().name())));

        return new User(
                userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.isEnabled(),
                userEntity.isAccountNonExpired(),
                userEntity.isCredentialsNonExpired(),
                userEntity.isAccountNonLocked(),
                authorityList
        );

//        return User.builder()
//                .username(userEntity.getUsername())
//                .password(userEntity.getPassword())
//                .accountExpired(userEntity.isAccountNonExpired())
//                .accountLocked(userEntity.isAccountNonLocked())
//                .credentialsExpired(userEntity.isCredentialsNonExpired())
//                .disabled(userEntity.isEnabled())
//                .authorities(authorityList)
//                .build();
    }
}
