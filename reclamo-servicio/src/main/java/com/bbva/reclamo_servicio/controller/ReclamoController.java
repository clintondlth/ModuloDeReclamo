package com.bbva.reclamo_servicio.controller;

import com.bbva.reclamo_servicio.model.entities.Reclamo;
import com.bbva.reclamo_servicio.service.ReclamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@RestController
@RequestMapping("/reclamos")
public class ReclamoController {

    private final ReclamoService reclamoService;

    @Autowired
    public ReclamoController(ReclamoService reclamoService) {
        this.reclamoService = reclamoService;
    }

    @GetMapping
    public ResponseEntity<List<Reclamo>> listarReclamos() {
        List<Reclamo> reclamos = reclamoService.listarReclamos();
        return ResponseEntity.ok(reclamos);
    }

    @PostMapping
    public ResponseEntity<Reclamo> crearReclamo(@RequestBody Reclamo reclamo) {
        Reclamo reclamoCreado = reclamoService.crearReclamo(reclamo);

        Date fechaReclamo =  new Date(System.currentTimeMillis());
        reclamoCreado.setFechaReclamo(fechaReclamo);
        reclamoCreado.setDescripcionReclamo("Rocio");
        return ResponseEntity.status(HttpStatus.CREATED).body(reclamoCreado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reclamo> actualizarReclamo(@PathVariable Long id,
                                                     @RequestParam String estadoReclamo,
                                                     @RequestParam String respuestaReclamo) {
        Reclamo reclamoActualizado = reclamoService.actualizarEstadoYRespuesta(id, estadoReclamo, respuestaReclamo);
        return ResponseEntity.ok(reclamoActualizado);
    }
}
