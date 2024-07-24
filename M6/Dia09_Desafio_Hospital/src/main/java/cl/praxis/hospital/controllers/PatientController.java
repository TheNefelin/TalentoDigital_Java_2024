package cl.praxis.hospital.controllers;

import cl.praxis.hospital.entities.Patient;
import cl.praxis.hospital.services.IBaseServiceCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private IBaseServiceCRUD<Patient> service;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("pacientes", service.findAll());
        return "patient_list";
    }
}
