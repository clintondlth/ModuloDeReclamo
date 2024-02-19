package com.bbva.tipo_reclamo.controller;

import com.bbva.tipo_reclamo.model.entities.TipoReclamo;
import com.bbva.tipo_reclamo.service.TipoReclamoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipo-reclamos")
public class TipoReclamoController {

    private final TipoReclamoService tipoReclamoService;

    @Autowired
    public TipoReclamoController(TipoReclamoService tipoReclamoService) {
        this.tipoReclamoService = tipoReclamoService;
    }

    @GetMapping
    public ResponseEntity<List<TipoReclamo>> listarTipoReclamos() {
        List<TipoReclamo> tipoReclamos = tipoReclamoService.listarTipoReclamos();
        return ResponseEntity.ok(tipoReclamos);
    }

    @PostMapping
    public ResponseEntity<TipoReclamo> crearTipoReclamo(@RequestBody TipoReclamo tipoReclamo) {
        TipoReclamo tipoReclamoCreado = tipoReclamoService.crearTipoReclamo(tipoReclamo);
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoReclamoCreado);
    }

    @PutMapping("/{idTipoReclamo}")
    public ResponseEntity<TipoReclamo> actualizarTipoReclamo(@PathVariable Long idTipoReclamo,
                                                     @RequestParam String tipoReclamo) {
        TipoReclamo tipoReclamoActualizado = tipoReclamoService.actualizarEstadoYRespuesta(idTipoReclamo, tipoReclamo);
        return ResponseEntity.ok(tipoReclamoActualizado);
    }
}
