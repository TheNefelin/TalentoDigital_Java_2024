package cl.praxis.inmobiliaria.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
@PreAuthorize("denyAll()")
public class TestRestController {

    @GetMapping("/public")
    @PreAuthorize("permitAll()")
    public String testPublic() {
        return "public";
    }

    @GetMapping("/private")
    @PreAuthorize("hasAuthority('READ')")
    public String testPrivate() {
        return "private";
    }

    @GetMapping("/auth")
    public String test() {
        return "auth";
    }
}
