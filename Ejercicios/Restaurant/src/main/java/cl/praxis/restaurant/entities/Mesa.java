package cl.praxis.restaurant.entities;

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
@Table(name = "mesa")
public class Mesa {
    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "Numero")
    private int numero;

    @Column(name = "Capacidad")
    private int capacidad;

    @Column(name = "Ubicacion")
    private String ubicacion;
}
