package cl.praxis.university.controllers.rests;

import cl.praxis.university.entities.Especialidad;
import cl.praxis.university.services.imp.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/especialidad")
public class EspecialidadRestController {
    @Autowired
    EspecialidadService especialidadService;

    @GetMapping
    public List<Especialidad> getAll() {
        return especialidadService.findAll();
    }
}
