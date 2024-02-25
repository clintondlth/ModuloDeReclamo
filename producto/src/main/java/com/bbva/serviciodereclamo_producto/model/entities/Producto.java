package com.bbva.serviciodereclamo_producto.model.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PRODUCTO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRODUCTO")
    private int idProducto;

    @Column(name = "NOMBRE_PRODUCTO", length = 255)
    private String nombreProducto;

    @Column(name = "DESCRIPCION_PRODUCTO", columnDefinition = "TEXT")
    private String descripcionProducto;

    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + idProducto +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", descripcionProducto='" + descripcionProducto + '\'' +
                '}';
    }
}
