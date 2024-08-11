package cl.praxis.inmobiliaria.entities.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AuthLoginRequestDTO {
    private String username;
    private String password;
}
