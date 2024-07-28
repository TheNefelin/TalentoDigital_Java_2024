package cl.praxis.hospital.controllers;

import cl.praxis.hospital.entities.Patient;
import cl.praxis.hospital.services.IBaseServiceCRUD;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/patient")
public class PatientController {
    private final static Logger LOG = LoggerFactory.getLogger(PatientController.class);

    @Autowired
    private IBaseServiceCRUD<Patient> service;

    // ROUTE
    @GetMapping("/create")
    public String routeCreate() {
        return "patient_form";
    }

    // ROUTE
    @PutMapping("/update")
    public String routeUpdate(@RequestParam int id, Model model) {
        Patient patient = service.findById(id);

        if (patient != null) {
            model.addAttribute("paciente", patient);
            return "patient_form";
        } else
            return "redirect:/patient";
    }

    // CRUD
    @GetMapping
    public String findAll(Model model) {
        LOG.info("--> Find all patients");

        model.addAttribute("pacientes", service.findAll());
        return "patient_list";
    }

    // CRUD
    @PostMapping()
    public String create(@ModelAttribute Patient patient) {
        LOG.info("--> Create patient");

        service.save(patient);
        return "redirect:/patient";
    }

    // CRUD
    @PutMapping()
    public String update(@ModelAttribute Patient patient) {
        LOG.info("--> Update patient");

        service.update(patient);
        return "redirect:/patient";
    }

    // CRUD
    @DeleteMapping
    public String delete(@RequestParam int id) {
        LOG.info("--> Delete patient");

        service.delete(id);
        return "redirect:/patient";
    }
}
