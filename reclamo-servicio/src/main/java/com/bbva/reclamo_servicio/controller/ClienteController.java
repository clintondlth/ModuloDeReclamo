package com.bbva.reclamo_servicio.controller;


import com.bbva.reclamo_servicio.model.entities.Reclamo;
import com.bbva.reclamo_servicio.service.ClienteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService; // Declaración de la variable

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // Otros atributos y constructor

    @GetMapping("/{idCliente}/reclamos")
    public List<Reclamo> obtenerReclamosDeCliente(@PathVariable int idCliente) {
        return clienteService.obtenerReclamosDeCliente(idCliente);
    }
}