package cl.praxis.inmobiliaria.controllers;

import cl.praxis.inmobiliaria.entities.dto.AuthLoginRequestDTO;
import cl.praxis.inmobiliaria.entities.dto.AuthResponseDTO;
import cl.praxis.inmobiliaria.services.imp.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthRestController {
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody AuthLoginRequestDTO authLoginRequestDTO) {
        return new ResponseEntity<>(customUserDetailsService.loginUser(authLoginRequestDTO), HttpStatus.OK);
    }
}
