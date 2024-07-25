package cl.praxis.ejercicio.services;

import cl.praxis.ejercicio.entities.User;
import cl.praxis.ejercicio.services.imp.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    void createUser() {
        User user1 = new User();
        user1.setName("BestoFrendo");
        user1.setEmail("bestofrendo@gmail.com");
        user1.setAge(10);

        User user2 = new User();
        user2.setName("Tatana");
        user2.setEmail("tatana@gmail.com");
        user2.setAge(20);

        User userResult1 = userService.create(user1);
        User userResult2 = userService.create(user2);

        assertTrue(userResult1.getId() != 0 && userResult2.getId() != 0);
    }

    @Test
    void getAllUser() {

        assertEquals(2, userService.findAll().size());
    }
}
