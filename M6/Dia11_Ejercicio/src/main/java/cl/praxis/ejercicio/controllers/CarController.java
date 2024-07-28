package cl.praxis.ejercicio.controllers;

import cl.praxis.ejercicio.entities.Car;
import cl.praxis.ejercicio.services.IBaseServiceCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/car")
public class CarController {
    @Autowired
    private IBaseServiceCRUD<Car> service;

    // Route
    @RequestMapping("form_create")
    public String carFormCreate(Model model) {
        return "car_form";
    }

    // Route
    @PutMapping("form_update")
    public String carFormUpdate(Model model, @RequestParam Long id) {
        model.addAttribute("car", service.getById(id));
        return "car_form";
    }

    // CRUD
    @GetMapping()
    public String carList(Model model) {
        model.addAttribute("cars", service.getAll());
        return "car_list";
    }

    // CRUD
    @PostMapping()
    public String carCreate(@ModelAttribute Car car) {
        service.create(car);
        return "redirect:/car";
    }

    // CRUD
    @PutMapping()
    public String carUpdate(@ModelAttribute Car car) {
        service.update(car);
        return "redirect:/car";
    }


    @DeleteMapping()
    public String carDelete(@RequestParam Long id) {
        service.delete(id);
        return "redirect:/car";
    }
}
