package cl.praxis.escuelarural.controllers;

import cl.praxis.escuelarural.entities.Course;
import cl.praxis.escuelarural.services.imp.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller()
@RequestMapping("/courses")
public class CourseController {
    private final static Logger LOG = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    private CourseService courseService;

    // ROUTE
    @GetMapping("/create")
    public String create() {
        LOG.info("Navigate new course");
        return "course_form";
    }

    // ROUTE
    @PutMapping("/update")
    public String getById(@RequestParam Long id, Model model) {
        LOG.info("--> Get course by id");
        model.addAttribute("course", courseService.getById(id));
        return "course_form";
    }

    // CRUD
    @GetMapping
    public String getAll(Model model) {
        LOG.info("--> Get all courses");
        model.addAttribute("courses", courseService.getAll());
        return "course_list";
    }

    // CRUD
    @PostMapping
    public String create(Course course) {
        LOG.info("--> Create new course");
        courseService.create(course);
        return "redirect:/courses";
    }

    // CRUD
    @PutMapping
    public String update(Course course) {
        LOG.info("--> Update course");
        courseService.update(course);
        return "redirect:/courses";
    }

    // CRUD
    @DeleteMapping
    public String delete(Course course, RedirectAttributes redirectAttributes) {
        LOG.info("--> Delete course");
        boolean isDeleted = courseService.delete(course.getId());

        if (!isDeleted) {
            redirectAttributes.addFlashAttribute("msge", "No se Puede Eliminar el Curso, Aun tiene Estudiantes Asociados");
        }

        return "redirect:/courses";
    }
}
