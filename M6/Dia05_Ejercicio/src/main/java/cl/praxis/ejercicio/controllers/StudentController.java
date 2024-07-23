package cl.praxis.ejercicio.controllers;

import cl.praxis.ejercicio.entities.Student;
import cl.praxis.ejercicio.services.IBaseCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IBaseCRUD<Student> service;

    @GetMapping("/getAll")
    public String getAll(Model model) {
        model.addAttribute("estudiantes", service.getAll());
        return "students";
    }

    @GetMapping("/{id}")
    public String getById(Model model) {
        model.addAttribute("estudiantes", service.getAll());
        return "students";
    }
}
