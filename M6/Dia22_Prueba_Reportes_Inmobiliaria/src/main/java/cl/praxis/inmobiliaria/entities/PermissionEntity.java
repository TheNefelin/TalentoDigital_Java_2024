package cl.praxis.inmobiliaria.entities;

import cl.praxis.inmobiliaria.entities.models.PermissionEnum;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "permisos")
public class PermissionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 50, unique = true, updatable = false)
    @Enumerated(EnumType.STRING)
    private PermissionEnum permissionEnum;
}
