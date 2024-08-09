package cl.praxis.inmobiliaria.controllers;

import cl.praxis.inmobiliaria.entities.User;
import cl.praxis.inmobiliaria.services.IServiceCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    @Autowired
    IServiceCRUD<User> userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        user.getRole().setId(2L);
        return userService.create(user);
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        user.setId(0L);
        user.getRole().setId(2L);
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }
}
