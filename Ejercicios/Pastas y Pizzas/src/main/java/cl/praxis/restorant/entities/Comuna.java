package cl.praxis.restorant.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "comunas")
public class Comuna {
    @Id
    @Column(name = "id_comuna")
    private int id;

    @Column(name = "nombre")
    private String nombre;
}
