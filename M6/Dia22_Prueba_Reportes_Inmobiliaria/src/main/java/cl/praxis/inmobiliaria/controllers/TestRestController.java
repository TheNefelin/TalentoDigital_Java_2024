package cl.praxis.inmobiliaria.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
@PreAuthorize("denyAll()")
public class TestRestController {

    @PreAuthorize("permitAll()")
    @GetMapping
    public String testGet() {
        return "GET ALL - permitAll()";
    }

    @PreAuthorize("hasAuthority('READ')")
    @GetMapping("/{id}")
    public String testGetById(@PathVariable String id) {
        return "GET BY ID - hasAuthority('READ')";
    }

    @PreAuthorize("hasRole('ADMIN') and hasAuthority('CREATE')")
    @PostMapping
    public String testPost() {
        return "POST - hasRole('ADMIN') and hasAuthority('CREATE')";
    }

    @PreAuthorize("hasAuthority('CREATE') or hasAuthority('UPDATE')")
    @PutMapping
    public String testPut() {
        return "PUT - hasRole('ADMIN') or hasAuthority('UPDATE')";
    }

    @PreAuthorize("hasAuthority('DELETE')")
    @DeleteMapping
    public String testDelete() {
        return "DELETE - hasAuthority('DELETE')";
    }

    @PreAuthorize("hasRole('USER')")
    @PatchMapping
    public String testPatch() {
        return "PATCH - hasRole('USER')";
    }
}
