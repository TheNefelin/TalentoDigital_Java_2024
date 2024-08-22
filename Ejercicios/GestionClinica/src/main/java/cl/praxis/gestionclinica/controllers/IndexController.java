package cl.praxis.gestionclinica.controllers;

import cl.praxis.gestionclinica.services.imp.DoctorService;
import cl.praxis.gestionclinica.services.imp.EspecialidadService;
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
    EspecialidadService especialidadService;

    @Autowired
    DoctorService doctorService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("especialidades", especialidadService.findAll());
        model.addAttribute("doctores", doctorService.findAll());
        return "index";
    }

    @PostMapping
    private String serch(
            Model model,
            @RequestParam("idEspecialidad") int idEspecialidad,
            @RequestParam("buscar") String buscar
    ) {
        //model.addAttribute("doctores", doctorService.findDoctoresPrototipe(idEspecialidad, buscar));
        model.addAttribute("doctores", doctorService.findDoctoresByIdAndText(idEspecialidad, buscar));
        model.addAttribute("idEspecialidad", idEspecialidad);
        model.addAttribute("buscar", buscar);
        model.addAttribute("especialidades", especialidadService.findAll());

        return "index";
    }
}
