package cl.praxis.tiendadiscos.controllers;

import cl.praxis.tiendadiscos.services.imp.MembresiaService;
import cl.praxis.tiendadiscos.services.imp.MiembroService;
import cl.praxis.tiendadiscos.services.imp.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    SucursalService sucursalService;

    @Autowired
    MembresiaService membresiaService;

    @Autowired
    MiembroService miembroService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("sucursales", sucursalService.findAll());
        model.addAttribute("membresias", membresiaService.findAll());
        model.addAttribute("miembros", miembroService.findAll());
        return "index";
    }

    @PostMapping
    public String findAll(
            Model model,
            @RequestParam("idSucursal") int idSucursal,
            @RequestParam("idMembresia") int idMembresia
    ) {
        model.addAttribute("miembros", miembroService.findAllByIdSucursalAndIdMembresia(idSucursal, idMembresia));
        return "index";
    }
}
