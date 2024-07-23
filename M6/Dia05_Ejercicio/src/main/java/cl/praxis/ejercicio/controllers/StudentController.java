package cl.praxis.ejercicio.controllers;

import cl.praxis.ejercicio.entities.Student;
import cl.praxis.ejercicio.services.IBaseCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IBaseCRUD<Student> service;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("estudiantes", service.getAll());
        return "students";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("student", new Student());
        return "student-form";
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute Student student) {
        service.add(student);
        return "redirect:/student";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable int id, Model model) {
        Student student = service.getById(id);
        if (student != null) {
            model.addAttribute("student", student);
            return "student-form";
        }
        return "redirect:/student";
    }

    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable int id, @ModelAttribute Student student) {
        service.update(id, student);
        return "redirect:/student";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        service.delete(id);
        return "redirect:/student";
    }
}
