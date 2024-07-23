package cl.praxis.ejercicio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CourseController {

    @GetMapping("/course") //Modelo
    @ResponseBody
    public String HolaMundo() {
        return "Hola mundo!";
    }
}
