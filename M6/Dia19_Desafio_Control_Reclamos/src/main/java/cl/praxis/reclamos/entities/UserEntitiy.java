package cl.praxis.reclamos.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class UserEntitiy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String name;

    @Column(name = "apellido", nullable = false, length = 50)
    private String surname;

    @Column(name = "correo", nullable = false, length = 100)
    private String email;

    @Column(name = "clave", nullable = false, length = 256)
    private String password;

    @Transient
    @Column(length = 256)
    private String passwordConfirmation;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_rol")
    private RoleEntity role;
}
