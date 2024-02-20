package com.bbva.reclamo_servicio.controller;

import com.bbva.reclamo_servicio.dto.ResponseDTO;
import com.bbva.reclamo_servicio.model.entities.Reclamo;
import com.bbva.reclamo_servicio.service.ReclamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;


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

        Date fechaReclamo = new Date(System.currentTimeMillis());
        reclamoCreado.setFechaReclamo(fechaReclamo);

        return ResponseEntity.status(HttpStatus.CREATED).body(reclamoCreado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reclamo> actualizarReclamo(@PathVariable Long id,
                                                     @RequestParam String estadoReclamo,
                                                     @RequestParam String respuestaReclamo) {
        Reclamo reclamoActualizado = reclamoService.actualizarEstadoYRespuesta(id, estadoReclamo, respuestaReclamo);
        return ResponseEntity.ok(reclamoActualizado);
    }

 /*   @GetMapping("reclamo/{id}")
    public ResponseEntity<Reclamo> obtenerReclamoPorId(@PathVariable Long id) {
        Reclamo reclamo = reclamoService.obtenerReclamoPorId(id);
        if (reclamo != null) {
            return ResponseEntity.ok(reclamo);
        } else {
            return ResponseEntity.notFound().build();
        }


    }
*/
 @GetMapping("/{id}")
 public ResponseEntity<ResponseDTO> getReclamoById(@PathVariable Long id) {
     ResponseDTO responseDTO = reclamoService.getReclamoByid(id);
     return ResponseEntity.ok(responseDTO);
 }

}