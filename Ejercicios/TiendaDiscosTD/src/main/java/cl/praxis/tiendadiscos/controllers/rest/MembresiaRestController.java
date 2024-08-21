package cl.praxis.tiendadiscos.controllers.rest;

import cl.praxis.tiendadiscos.entities.Membresia;
import cl.praxis.tiendadiscos.services.imp.MembresiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/membresia")
public class MembresiaRestController {
    @Autowired
    MembresiaService membresiaService;

    @GetMapping
    public List<Membresia> getAll() {
        return membresiaService.findAll();
    }
}
