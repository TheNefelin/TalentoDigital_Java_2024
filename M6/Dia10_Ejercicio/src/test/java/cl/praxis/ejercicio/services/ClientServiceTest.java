package cl.praxis.ejercicio.services;

import cl.praxis.ejercicio.entities.Client;
import cl.praxis.ejercicio.services.imp.ClientService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ClientServiceTest {
    private final static Logger LOG = LoggerFactory.getLogger(ClientServiceTest.class);
    private static int id;

    @Autowired
    ClientService clientService;

    @Test
    @Order(1)
    public void createClientTest() {
        Client clientResult = clientService.create(new Client(0, "Isaac", "Netero", 123, "Japon", "netero@hxh.jp"));
        id = clientResult.getId();

        assertTrue(clientResult.getId() != 0, "Cliente Creado");
        LOG.info(id + " client created");
    }

    @Test
    @Order(2)
    public void getClientTest() {
        Client client = clientService.findById(id);

        assertNotNull(client, "Cliente Encontrado");
        LOG.info(id + " client found");
    }

    @Test
    @Order(3)
    public void updateClientTest() {
        Client client = clientService.findById(id);
        client.setAddress("Jamaica");

        boolean isUpdated = clientService.update(client);

        //assertTrue(isUpdated, "Cliente Actualizado");
        assertEquals("Jamaica", clientService.findById(id).getAddress(), "Cliente Actualizado");
        LOG.info(id + " client updated");
    }

//    @Test
//    @Order(4)
//    public void deleteClientTest() {
//        boolean isDeleted = clientService.delete(id);
//
//        //assertTrue(isDeleted, "Cliente Eliminado");
//        assertNull(clientService.findById(id), "Cliente no encontrado");
//        LOG.info(id + " client deleted");
//    }
}
