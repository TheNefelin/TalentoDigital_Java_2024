package cl.praxis.tiendadiscos.controllers.rest;

import cl.praxis.tiendadiscos.entities.Miembro;
import cl.praxis.tiendadiscos.services.imp.MiembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/miembro")
public class MiembroRestController {
    @Autowired
    MiembroService miembroService;

    @GetMapping
    public List<Miembro> listaMiembros() {
        return miembroService.findAll();
    }

    @GetMapping("/{idSucursal}/{idMembresia}")
    public List<Miembro> getMiembroByIds(
            @PathVariable int idSucursal,
            @PathVariable  int idMembresia) {
        return miembroService.findAllByIdSucursalAndIdMembresia(idSucursal, idMembresia);
    }
}
