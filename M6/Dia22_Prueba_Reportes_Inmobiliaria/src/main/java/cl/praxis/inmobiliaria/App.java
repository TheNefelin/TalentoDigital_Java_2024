package cl.praxis.inmobiliaria;

import cl.praxis.inmobiliaria.entities.PermissionEntity;
import cl.praxis.inmobiliaria.entities.RoleEntity;
import cl.praxis.inmobiliaria.entities.models.PermissionEnum;
import cl.praxis.inmobiliaria.entities.models.RoleEnum;
import cl.praxis.inmobiliaria.entities.UserEntity;
import cl.praxis.inmobiliaria.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Set;

@SpringBootApplication
public class App {
    @Autowired
    IUserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    CommandLineRunner init() {
        return args -> {
            PermissionEntity permissionRead = PermissionEntity.builder()
                    .permissionEnum(PermissionEnum.READ)
                    .build();

            PermissionEntity permissionCreate = PermissionEntity.builder()
                    .permissionEnum(PermissionEnum.CREATE)
                    .build();

            PermissionEntity permissionUpdate = PermissionEntity.builder()
                    .permissionEnum(PermissionEnum.UPDATE)
                    .build();

            PermissionEntity permissionDelete = PermissionEntity.builder()
                    .permissionEnum(PermissionEnum.DELETE)
                    .build();

            RoleEntity roleAdmin = RoleEntity.builder()
                    .roleEnum(RoleEnum.ADMIN)
                    .permissions(Set.of(permissionRead, permissionCreate, permissionUpdate, permissionDelete))
                    .build();

            RoleEntity roleUser = RoleEntity.builder()
                    .roleEnum(RoleEnum.USER)
                    .permissions(Set.of(permissionRead))
                    .build();

            UserEntity adminUser = UserEntity.builder()
                    .username("usuario1")
                    .password("$2a$10$2EYQgqDOIOkPi9EvgZzctOq1f8S.0qT.QflTC/Ntj7ZMzEjVjRSlq")
                    .isEnabled(true)
                    .isAccountNonExpired(true)
                    .isAccountNonLocked(true)
                    .isCredentialsNonExpired(true)
                    .roles(Set.of(roleAdmin, roleUser))
                    .build();

            UserEntity userUser = UserEntity.builder()
                    .username("usuario2")
                    .password("$2a$10$2EYQgqDOIOkPi9EvgZzctOq1f8S.0qT.QflTC/Ntj7ZMzEjVjRSlq")
                    .isEnabled(true)
                    .isAccountNonExpired(true)
                    .isAccountNonLocked(true)
                    .isCredentialsNonExpired(true)
                    .roles(Set.of(roleUser))
                    .build();

            userRepository.saveAll(Set.of(adminUser, userUser));
        };
    }
}
