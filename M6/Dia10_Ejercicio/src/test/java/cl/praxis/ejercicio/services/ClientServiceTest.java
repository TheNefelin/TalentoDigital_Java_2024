package cl.praxis.ejercicio.services;

import cl.praxis.ejercicio.entities.Client;
import cl.praxis.ejercicio.repositories.IClientRepository;
import cl.praxis.ejercicio.services.imp.ClientService;
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

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

// permitiendo la creación automática de mocks
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ClientServiceTest {
    private final static Logger LOG = LoggerFactory.getLogger(ClientServiceTest.class);
    private Client client1;
    private Client client2;

    //crea un mock (objeto simulado) simular el comportamiento del repositorio
    @Mock
    private IClientRepository repository;

    //inyecte los mocks creados (como repository)
    @InjectMocks
    private ClientService service;

    @BeforeEach
    void setUp() {
        LOG.info("Instanciando Cliente de Prueba para el Test");
        client1 = new Client(1, "Isaac", "Netero", 123, "Japon", "netero@hxh.jp");
        client2 = new Client(2, "Chrollo", "Lucifer", 321, "Japon", "chrollo@hxh.jp");
    }

    @Test
    void createClientTest() {
        // Definición del comportamiento simulado
        when(repository.save(client1)).thenReturn(client1);

        // Llamada al método bajo prueba
        Client clientResult = service.create(client1);

        // verifica resultados
        assertThat(clientResult).isNotNull();
        assertThat(clientResult.getName()).isEqualTo("Isaac");
        assertThat(clientResult.getSurname()).isEqualTo("Netero");
        assertThat(clientResult.getPhone()).isEqualTo(123);
        assertThat(clientResult.getAddress()).isEqualTo("Japon");
        assertThat(clientResult.getEmail()).isEqualTo("netero@hxh.jp");

        verify(repository, times(1)).save(clientResult);
    }

    @Test
    void getClientTest() {
        List<Client> clients = Arrays.asList(client1, client2);
        when(repository.findAll()).thenReturn(clients);

        List<Client> clientsResult = service.getAll();
        assertThat(clientsResult).isNotNull();
        assertThat(clientsResult.size()).isEqualTo(2);
        assertThat(clientsResult.get(0)).isEqualTo(client1);
        assertThat(clientsResult.get(1)).isEqualTo(client2);

        verify(repository, times(1)).findAll();
    }

    @Test
    void updateClientTest() {
        client1.setPhone(666);
        client1.setAddress("Jamaica");
        when(repository.existsById(client1.getId())).thenReturn(true);
        when(repository.save(client1)).thenReturn(client1);

        Client clientResult = service.update(client1);
        assertThat(clientResult).isNotNull();
        assertThat(clientResult.getPhone()).isEqualTo(666);
        assertThat(clientResult.getAddress()).isEqualTo("Jamaica");

        verify(repository, times(1)).save(clientResult);
    }

    @Test
    void deleteClientTest() {
        int id = client1.getId();
        when(repository.existsById(id)).thenReturn(true);

        boolean idDeleted = service.delete(id);
        assertThat(idDeleted).isTrue();

        verify(repository, times(1)).deleteById(id);
    }
}