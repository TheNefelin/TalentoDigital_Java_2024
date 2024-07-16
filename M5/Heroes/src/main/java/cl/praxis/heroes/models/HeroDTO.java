package cl.praxis.heroes.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HeroDTO {
    private int id;
    private String name;
    private GenderDTO gender;
    private ClassDTO clase;
    private UserDTO user;
}
