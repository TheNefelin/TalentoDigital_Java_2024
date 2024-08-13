package cl.praxis.reclamos.controllers;

import cl.praxis.reclamos.entities.UserEntitiy;
import cl.praxis.reclamos.entities.dtos.LoginDTO;
import cl.praxis.reclamos.services.imp.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    CustomUserDetailsService userDetailsService;

    // ROUTE
    @GetMapping
    public String indexRoute() {
        return "index";
    }

    // ROUTE
    @GetMapping("/private")
    public String privateRoute() {
        return "private";
    }

    // ROUTE
    @GetMapping("/register")
    public String registerRoute() {
        return "register";
    }

    // ROUTE
    @GetMapping("/login")
    public String loginRoute() {
        return "login";
    }

    // CRUD
    @PostMapping("/register")
    public String registerRequest(@ModelAttribute UserEntitiy user, Model model) {
        UserEntitiy newUser = userDetailsService.register(user);

        if (newUser != null && user.getId() != 0) {
            model.addAttribute("msge", "Usuario Registrado Correctamente");
            return "login";
        }

        model.addAttribute("msge", "NO se ha Podido Regitrar el Usuario");
        return "redirect:/register";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO loginDTO) {
        if (userDetailsService.authenticate(loginDTO))
            return "private";
        else
            return "redirect:/login";
    }
}
