package cl.praxis.veterinaria.controllers;

import cl.praxis.veterinaria.models.entities.Atencion;
import cl.praxis.veterinaria.models.entities.Sucursal;
import cl.praxis.veterinaria.services.imp.AtencionService;
import cl.praxis.veterinaria.services.imp.SucursalService;
import cl.praxis.veterinaria.services.imp.TipoAtencionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller()
@RequestMapping("/")
public class IndexController {
    @Autowired
    SucursalService sucursalService;

    @Autowired
    TipoAtencionService tipoAtencionService;

    @Autowired
    AtencionService atencionService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("sucursales", sucursalService.getAll());
        model.addAttribute("tipoAtenciones", tipoAtencionService.getAll());
        model.addAttribute("atenciones", atencionService.getAll());
        return "index";
    }

    @PostMapping
    public String getByIds(
            Model model,
            @RequestParam("idSucursal") int idSucursal,
            @RequestParam("idTipoAtencion") int idTipoAtencion
    ) {
        model.addAttribute("idSucursal", idSucursal);
        model.addAttribute("idTipoAtencion", idTipoAtencion);

        model.addAttribute("sucursales", sucursalService.getAll());
        model.addAttribute("tipoAtenciones", tipoAtencionService.getAll());
        model.addAttribute("atenciones", atencionService.getAllByIdSucursalAndIdTipoAtencion(idSucursal, idTipoAtencion));
        return "index";
    }
}
