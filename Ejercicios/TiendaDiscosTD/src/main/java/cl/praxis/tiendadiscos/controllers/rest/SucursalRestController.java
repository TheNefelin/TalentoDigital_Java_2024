package cl.praxis.tiendadiscos.controllers.rest;

import cl.praxis.tiendadiscos.applicationjava.Service;
import cl.praxis.tiendadiscos.entities.Sucursal;
import cl.praxis.tiendadiscos.services.imp.SucursalService;
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
    public List<Sucursal> listaSucursales(){
        return sucursalService.findAll();
    }
}
