package cl.praxis.biblioteca.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "libros")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "titulo", nullable = false, length = 100)
    private String title;

    @Column(name = "autor", nullable = false, length = 100)
    private String author;

    @Column(name = "editorial", nullable = false, length = 100)
    private String publisher;
}
