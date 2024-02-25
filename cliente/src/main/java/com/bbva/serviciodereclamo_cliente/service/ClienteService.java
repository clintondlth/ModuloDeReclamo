package com.bbva.serviciodereclamo_cliente.service;
import com.bbva.serviciodereclamo_cliente.model.entities.Cliente;
import com.bbva.serviciodereclamo_cliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente buscarClientePorId(Long idCliente) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(idCliente);
        return clienteOptional.orElseThrow(() ->
                new RuntimeException("Cliente no encontrado con el ID: " + idCliente));
    }

    public Cliente agregarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}
