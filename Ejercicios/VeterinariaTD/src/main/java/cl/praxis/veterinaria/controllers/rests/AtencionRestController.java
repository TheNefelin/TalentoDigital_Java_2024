package cl.praxis.veterinaria.controllers.rests;

import cl.praxis.veterinaria.models.entities.Atencion;
import cl.praxis.veterinaria.services.imp.AtencionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/atencion")
public class AtencionRestController {
    @Autowired
    AtencionService atencionService;

    @GetMapping
    public List<Atencion> getAtencion() {
        return atencionService.getAll();
    }

    @GetMapping("/{idSucursal}/{idTipoAtencion}")
    public List<Atencion> getAtencionByIds(
            @PathVariable int idSucursal,
            @PathVariable  int idTipoAtencion) {
        return atencionService.getAllByIdSucursalAndIdTipoAtencion(idSucursal, idTipoAtencion);
    }

    @PostMapping
    public String test() {
        return "Test";
    }
}
