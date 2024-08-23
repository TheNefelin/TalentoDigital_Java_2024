package cl.praxis.restaurant.controllers;

import cl.praxis.restaurant.services.imp.CamareroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    CamareroService camareroService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("fechas", camareroService.getAllDates());
        model.addAttribute("camareros", camareroService.getAll());
        return "index";
    }

    @PostMapping
    public String filter(
            Model model,
            @RequestParam("fecha") String fecha,
            @RequestParam("buscar") String buscar
    ) {
        model.addAttribute("fechas", camareroService.getAllDates());
        model.addAttribute("camareros", camareroService.getAllByDateAndText(fecha, buscar));
        model.addAttribute("isFecha", fecha);
        model.addAttribute("isBuscar", buscar);
        return "index";
    }
}
