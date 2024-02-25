package com.bbva.serviciodereclamo_producto.repository;

import com.bbva.serviciodereclamo_producto.model.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
