package cl.praxis.demo.controllers;

import ch.qos.logback.core.model.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SaludoController {

    @GetMapping
    public String saludo(Model model) {
        return "Un Saludo para MalaPraxis!!!";
    }
}
