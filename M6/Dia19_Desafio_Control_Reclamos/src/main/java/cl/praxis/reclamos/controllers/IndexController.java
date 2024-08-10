package cl.praxis.reclamos.controllers;

import cl.praxis.reclamos.entities.UserEntitiy;
import cl.praxis.reclamos.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    IUserService userService;

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
        UserEntitiy newUser = userService.register(user);

        if (newUser != null && user.getId() != 0) {
            model.addAttribute("msge", "Usuario Registrado Correctamente");
            return "login";
        }

        model.addAttribute("msge", "NO se ha Podido Regitrar el Usuario");
        return "redirect:/register";
    }
}
