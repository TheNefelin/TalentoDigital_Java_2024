package cl.praxis.inmobiliaria;

import cl.praxis.inmobiliaria.entities.RoleEntity;
import cl.praxis.inmobiliaria.entities.RoleEnum;
import cl.praxis.inmobiliaria.entities.UserEntity;
import cl.praxis.inmobiliaria.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;

import java.util.List;

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
            RoleEntity roleAdmin = RoleEntity
                    .builder()
                    .roleEnum(RoleEnum.ROLE_ADMIN)
                    .build();

            RoleEntity roleUser = RoleEntity
                    .builder()
                    .roleEnum(RoleEnum.ROLE_USER)
                    .build();

            UserEntity adminUser = UserEntity
                    .builder()
                    .name("El")
                    .surname("Administrador")
                    .email("admin@admin.cl")
                    .password("123")
                    .role(roleAdmin)
                    .build();

            UserEntity userUser = UserEntity
                    .builder()
                    .name("El")
                    .surname("Usuario")
                    .email("usuario@usuario.cl")
                    .password("123")
                    .role(roleUser)
                    .build();

            userRepository.saveAll(List.of(adminUser, userUser));
        };
    }
}
