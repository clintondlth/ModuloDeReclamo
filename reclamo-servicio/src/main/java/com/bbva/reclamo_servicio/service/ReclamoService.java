package com.bbva.reclamo_servicio.service;


import com.bbva.reclamo_servicio.model.entities.Reclamo;
import com.bbva.reclamo_servicio.repository.ReclamoRepository;
import com.bbva.tipo_reclamo.model.entities.TipoReclamo;
import com.bbva.tipo_reclamo.repository.TipoReclamoRepository;

import com.bbva.tipo_reclamo.service.TipoReclamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReclamoService {


    private final ReclamoRepository reclamoRepository;

    @Autowired
    public ReclamoService(ReclamoRepository reclamoRepository) {
        this.reclamoRepository = reclamoRepository;
    }

    public List<Reclamo> listarReclamos() {
        return reclamoRepository.findAll();
    }

    public Reclamo crearReclamo(Reclamo reclamo) {
        return reclamoRepository.save(reclamo);
    }

    public Optional<Reclamo> obtenerReclamoPorId(Long id) {
        return reclamoRepository.findById(id);
    }

    public Reclamo actualizarEstadoYRespuesta(Long id, String estadoReclamo, String respuestaReclamo) {
        Optional<Reclamo> reclamoOptional = reclamoRepository.findById(id);
        if (reclamoOptional.isPresent()) {
            Reclamo reclamo = reclamoOptional.get();
            reclamo.setEstadoReclamo(estadoReclamo);
            reclamo.setRespuestaReclamo(respuestaReclamo);
            return reclamoRepository.save(reclamo);
        } else {
            throw new RuntimeException("Reclamo no encontrado con ID: " + id);
        }
    }



    //public String obtenerDescripcionTipoReclamoPorCodigo(Long codigoTipoReclamo) {
        // Llamar al método en el servicio de tipo de reclamo para obtener la descripción
     //   return tipoReclamoService.obtenerDescripcionPorCodigo(codigoTipoReclamo);
    //}


}
