package cl.praxis.inmobiliaria.entities;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "usuarios")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String name;

    @Column(name = "apellido", nullable = false, length = 50)
    private String surname;

    @Column(name = "correo", nullable = false, length = 100, unique = true)
    private String email;

    @Column(name = "clave", nullable = false)
    private String password;

    @Transient
    private String passwordConfirmation;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_rol")
    private RoleEntity role;
}
