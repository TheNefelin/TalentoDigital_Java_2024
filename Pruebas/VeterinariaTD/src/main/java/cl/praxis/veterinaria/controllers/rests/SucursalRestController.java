package cl.praxis.veterinaria.controllers.rests;

import cl.praxis.veterinaria.models.entities.Sucursal;
import cl.praxis.veterinaria.services.imp.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sucursal")
public class SucursalRestController {
    @Autowired
    SucursalService sucursalService;

    @GetMapping
    public List<Sucursal> getAll() {
        return sucursalService.getAll();
    }
}
