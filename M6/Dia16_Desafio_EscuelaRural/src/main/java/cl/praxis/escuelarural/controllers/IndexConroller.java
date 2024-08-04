package cl.praxis.escuelarural.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/")
public class IndexConroller {

    @GetMapping
    public String index() {
        return "index";
    }
}
