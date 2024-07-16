package cl.praxis.persona.controllers;


import cl.praxis.persona.repositories.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private IPersonRepository iPersonRepository;
}
