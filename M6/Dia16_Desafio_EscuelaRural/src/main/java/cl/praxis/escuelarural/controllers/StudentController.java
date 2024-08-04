package cl.praxis.escuelarural.controllers;

import cl.praxis.escuelarural.entities.Course;
import cl.praxis.escuelarural.entities.Student;
import cl.praxis.escuelarural.services.imp.CourseService;
import cl.praxis.escuelarural.services.imp.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {
    private final static Logger LOG = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    // ROUTE
    @GetMapping("/create")
    public String create(Model model) {
        LOG.info("Navigate new course");
        model.addAttribute("courses", courseService.getAll());
        return "student_form";
    }

    // ROUTE
    @PutMapping("/update")
    public String getById(@RequestParam Long id, Model model) {
        LOG.info("--> Get student by id");
        model.addAttribute("student", studentService.getById(id));
        model.addAttribute("courses", courseService.getAll());
        return "student_form";
    }

    // CRUD
    @GetMapping
    public String getAll(Model model) {
        LOG.info("--> Get all students");
        model.addAttribute("students", studentService.getAll());
        return "student_list";
    }

    // CRUD
    @PostMapping
    public String create(Student student) {
        LOG.info("--> Create new student");
        studentService.create(student);
        return "redirect:/students";
    }

    // CRUD
    @PutMapping
    public String update(Student student) {
        LOG.info("--> Update student");
        studentService.update(student);
        return "redirect:/students";
    }

    // CRUD
    @DeleteMapping
    public String delete(Student student) {
        LOG.info("--> Delete student");
        studentService.delete(student.getId());
        return "redirect:/students";
    }
}
