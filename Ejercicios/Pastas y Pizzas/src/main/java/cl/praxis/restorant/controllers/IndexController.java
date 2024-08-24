package cl.praxis.restorant.controllers;

import cl.praxis.restorant.entities.Comanda;
import cl.praxis.restorant.entities.ComandaDetalle;
import cl.praxis.restorant.services.IServiceCRUD;
import cl.praxis.restorant.services.imp.ComandaDetalleService;
import cl.praxis.restorant.services.imp.ComandaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    private IServiceCRUD<Comanda> comandaService;

    @Autowired
    private ComandaDetalleService comandaDetalleService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("comandas", comandaService.findAll());
        return "index";
    }

    // Navegate
    @PostMapping
    public String detalle(Model model, Comanda comanda) {
        model.addAttribute("detalles", comandaDetalleService.findByIdComanda(comanda.getId()));
        return "comanda_detalle";
    }
}
