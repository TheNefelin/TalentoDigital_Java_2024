package cl.praxis.reclamos.controllers;

import cl.praxis.reclamos.entities.IdDTO;
import cl.praxis.reclamos.entities.User;
import cl.praxis.reclamos.services.IServiceCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest_user")
public class UserRestController {
    @Autowired
    IServiceCRUD<User> userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping
    public void deleteUser(@RequestBody IdDTO idDTO) {
        userService.delete(idDTO.getId());
    }
}
