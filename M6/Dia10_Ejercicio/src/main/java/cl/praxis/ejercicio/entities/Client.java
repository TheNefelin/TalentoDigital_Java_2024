package cl.praxis.ejercicio.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clientes")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String name;

    @Column(name = "apellido", nullable = false, length = 50)
    private String surname;

    @Column(name = "telefono" , nullable = false)
    private int phone;

    @Column(name = "direccion", nullable = false, length = 256)
    private String address;

    @Column(name = "correo", nullable = false, length = 100)
    private String email;
}
