package cl.praxis.game.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Personaje {
    private int id;
    private String nombre;
    private Genero genero;
    private int fuerza;
    private int defensa;
    private int vida;
}
