package cl.praxis.inmobiliaria.entities.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonPropertyOrder({"username", "message", "jwt", "status"})
public class AuthResponseDTO {
   private  String username;
   private String message;
   private String jwt;
   private boolean status;
}
