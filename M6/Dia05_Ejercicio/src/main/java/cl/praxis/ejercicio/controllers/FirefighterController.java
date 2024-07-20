package cl.praxis.ejercicio.controllers;

import cl.praxis.ejercicio.entities.Firefighter;
import cl.praxis.ejercicio.services.imp.FirefighterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/firefighter")
public class FirefighterController {
    @Autowired
    private FirefighterService service;

    @GetMapping
    public List<Firefighter> getAll() {
        return service.getAll();
    }
}
