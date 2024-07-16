package cl.praxis.persona.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController {

    @GetMapping
    public String index() {
        String html =
                "<h1>Un Saludo para MalaPraxis!!!</h1>" +
                "<a href=\"/persons\">GetAll Person</a>";
        return html;
    }
}
