package cl.praxis.veterinaria.controllers.rests;

import cl.praxis.veterinaria.models.entities.TipoAtencion;
import cl.praxis.veterinaria.services.imp.TipoAtencionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/topo-atencion")
public class TopoAtencionRestController {
    @Autowired
    TipoAtencionService tipoAtencionService;

    @GetMapping
    public List<TipoAtencion> getTopoAtencion() {
        return tipoAtencionService.getAll();
    }
}
