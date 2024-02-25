package com.bbva.serviciodereclamo_cliente.repository;

import com.bbva.serviciodereclamo_cliente.model.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
