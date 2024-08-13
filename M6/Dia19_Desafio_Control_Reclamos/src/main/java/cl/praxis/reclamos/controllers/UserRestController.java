package cl.praxis.reclamos.controllers;

import cl.praxis.reclamos.entities.dtos.IdDTO;
import cl.praxis.reclamos.entities.UserEntitiy;
import cl.praxis.reclamos.services.IServiceCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserRestController {
    @Autowired
    IServiceCRUD<UserEntitiy> userService;

    @GetMapping
    public List<UserEntitiy> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserEntitiy getUserById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @PostMapping
    public UserEntitiy createUser(@RequestBody UserEntitiy user) {
        return userService.create(user);
    }

    @PutMapping
    public UserEntitiy updateUser(@RequestBody UserEntitiy user) {
        return userService.update(user);
    }

    @DeleteMapping
    public void deleteUser(@RequestBody IdDTO idDTO) {
        userService.delete(idDTO.getId());
    }
}
