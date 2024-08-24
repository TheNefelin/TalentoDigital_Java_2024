package cl.praxis.restorant.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @Column(name = "id_producto")
    private int id;

    @Column(name = "codigo_producto")
    private String codigoProducto;

    @Column(name = "nombre_producto")
    private String nombre;

    @Column(name = "stock")
    private int stock;

    @Column(name = "precio_unitario")
    private double precioUnitario;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
}
