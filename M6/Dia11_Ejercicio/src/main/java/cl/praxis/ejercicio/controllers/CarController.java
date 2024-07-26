package cl.praxis.ejercicio.controllers;

import cl.praxis.ejercicio.entities.Car;
import cl.praxis.ejercicio.services.IBaseServiceCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class CarController {
    @Autowired
    private IBaseServiceCRUD<Car> service;

    // Route
    @RequestMapping
    public String index(Model model) {
        return "index";
    }

    // Route
    @RequestMapping("autos")
    public String carList(Model model) {
        return "car_list";
    }

    // Route
    @RequestMapping("crear")
    public String carForm(Model model) {
        return "car_form";
    }
}
