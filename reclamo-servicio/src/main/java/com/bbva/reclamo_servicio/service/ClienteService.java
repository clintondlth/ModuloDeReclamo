package com.bbva.reclamo_servicio.service;

import com.bbva.reclamo_servicio.model.entities.Cliente;
import com.bbva.reclamo_servicio.model.entities.Reclamo;
import com.bbva.reclamo_servicio.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

      private  final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Reclamo> obtenerReclamosDeCliente(int idCliente) {
        Cliente cliente = clienteRepository.findByIdCliente(idCliente);
        if (cliente != null) {
            return cliente.getReclamos();
        } else {
            throw new RuntimeException("Cliente no encontrado con ID: " + idCliente);
        }
    }
}