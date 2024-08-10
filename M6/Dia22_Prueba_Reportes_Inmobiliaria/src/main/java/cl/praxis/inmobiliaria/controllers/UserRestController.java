package cl.praxis.inmobiliaria.controllers;

import cl.praxis.inmobiliaria.entities.UserEntity;
import cl.praxis.inmobiliaria.services.IServiceCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    @Autowired
    IServiceCRUD<UserEntity> userService;

    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PutMapping
    public UserEntity updateUser(@RequestBody UserEntity user) {
        user.setId(0L);
        user.getRole().setId(2L);
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }
}
