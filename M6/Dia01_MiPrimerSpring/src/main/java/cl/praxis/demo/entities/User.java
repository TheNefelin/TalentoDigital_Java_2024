package cl.praxis.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "coreo", nullable = false, length = 50, unique = true)
    private String email;

    @Column(name = "nombre" , nullable = false, length = 50)
    private String nombre;

    @ManyToOne()
    @JoinColumn(name = "id_rol", nullable = false)
    private Rol rol;
}
