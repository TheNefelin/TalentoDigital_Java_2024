package cl.praxis.ejercicio.services;

import cl.praxis.ejercicio.entities.User;
import cl.praxis.ejercicio.repositories.IUserRepository;
import cl.praxis.ejercicio.services.imp.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

//Integra Mockito con JUnit 5.
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class UserServiceTest {
    private final static Logger LOG = LoggerFactory.getLogger(UserServiceTest.class);
    private User user1;
    private User user2;

    //Crea un mock del repositorio de usuarios.
    @Mock
    private IUserRepository repository;

    //Inyecta los mocks en el servicio de usuario.
    @InjectMocks
    private UserService service;

    @BeforeEach
    public void setUp() {
        LOG.info("--> Iniciando la service");
        user1 = new User(1, "Netero", "isaac@hxh.cl", 156);
        user2 = new User(2, "Chrollo", "lucifer@hxh.cl", 26);
    }

    @Test
    public void testGetAll() {
        LOG.info("--> Iniciando testGetAll");
        List<User> users = Arrays.asList(user1, user2);
        when(repository.findAll()).thenReturn(users);

        List<User> usersResult = service.getAll();
        assertThat(usersResult).isEqualTo(users);
        assertThat(usersResult.size()).isEqualTo(2);

        verify(repository, times(1)).findAll();
        LOG.info("<-- Finalizando testGetAll");
    }

    @Test
    public void testGetById() {
        LOG.info("--> Iniciando testGetById");
        int id = user1.getId();
        when(repository.findById(id)).thenReturn(Optional.of(user1));

        User userResult = service.getById(1);
        assertThat(userResult).isEqualTo(user1);

        verify(repository, times(1)).findById(id);
        LOG.info("<-- Finalizando testGetById");
    }

    @Test
    public void testCreate() {
        LOG.info("--> Iniciando testCreate");
        when(repository.save(user1)).thenReturn(user1);

        User userResult = service.create(user1);
        assertThat(userResult).isEqualTo(user1);

        verify(repository, times(1)).save(user1);
        LOG.info("<-- Finalizando testCreate");
    }

    @Test
    public void testUpdate() {
        LOG.info("--> Iniciando testUpdate");
        user1.setName("Hizoka");
        user1.setEmail("morow@hxh.cl");
        user1.setAge(28);
        when(repository.save(user1)).thenReturn(user1);
        when(repository.existsById(user1.getId())).thenReturn(true);

        User userResult = service.update(user1);
        assertThat(userResult).isEqualTo(user1);
        assertThat(userResult.getName()).isEqualTo("Hizoka");
        assertThat(userResult.getEmail()).isEqualTo("morow@hxh.cl");
        assertThat(userResult.getAge()).isEqualTo(28);

        verify(repository, times(1)).save(user1);
        verify(repository, times(1)).existsById(user1.getId());
        LOG.info("<-- Finalizando testUpdate");
    }

    @Test
    public void testUpdateFail() {
        LOG.info("--> Iniciando testUpdateFail");
        when(repository.existsById(user1.getId())).thenReturn(false);

        User userResult = service.update(user1);
        assertThat(userResult).isNull();

        verify(repository, times(0)).save(user1);
        LOG.info("<-- Finalizando testUpdateFail");
    }

    @Test
    public void testDelete() {
        LOG.info("--> Iniciando testDelete");
        int id = user1.getId();
        when(repository.existsById(id)).thenReturn(true);

        boolean isDeleted = service.delete(id);
        assertThat(isDeleted).isTrue();

        verify(repository, times(1)).deleteById(id);
        LOG.info("<-- Finalizando testDelete");
    }

    @Test
    public void testDeleteFail() {
        LOG.info("--> Iniciando testDeleteFail");
        int id = 0;
        when(repository.existsById(id)).thenReturn(false);

        boolean isDeleted = service.delete(id);
        assertThat(isDeleted).isFalse();

        verify(repository, times(0)).deleteById(id);
        LOG.info("<-- Finalizando testDeleteFail");
    }
}
