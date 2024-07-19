package cl.praxis.ejercicio.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String index() {
        String html =
                "<h1>Bienvenido al Ejercicio</h1>" +
                "<a href=\"/supermarket\">SuperMarket</a>";
        return html;
    }

}
