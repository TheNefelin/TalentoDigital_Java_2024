package cl.praxis.inmobiliaria.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

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

    @Column(name = "usuario", nullable = false, length = 50)
    private String username;

    @Column(name = "clave", nullable = false)
    private String password;

    @Column(name = "activo", nullable = false)
    private boolean isEnabled;

    @Column(name = "cuenta_no_expira", nullable = false)
    private boolean isAccountNonExpired;

    @Column(name = "cuenta_no_bloqueada", nullable = false)
    private boolean isAccountNonLocked;

    @Column(name = "credencial_no_expira", nullable = false)
    private boolean isCredentialsNonExpired;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "rol_usuario",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_rol")
    )
    private Set<RoleEntity> roles = new HashSet<>();
}
