package com.bbva.serviciodereclamo_producto.service;

import com.bbva.serviciodereclamo_producto.model.entities.Producto;
import com.bbva.serviciodereclamo_producto.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    public Optional<Producto> buscarProductoPorId(Long idProducto) {
        return productoRepository.findById(idProducto);
    }

    public Producto agregarProducto(Producto producto) {
        return productoRepository.save(producto);
    }
}
