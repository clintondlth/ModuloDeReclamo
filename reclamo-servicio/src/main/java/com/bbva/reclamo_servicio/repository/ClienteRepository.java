package com.bbva.reclamo_servicio.repository;

import com.bbva.reclamo_servicio.model.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Cliente findByIdCliente(int idCliente);
}