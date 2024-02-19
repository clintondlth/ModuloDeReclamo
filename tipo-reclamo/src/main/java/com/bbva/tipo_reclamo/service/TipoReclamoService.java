package com.bbva.tipo_reclamo.service;


import com.bbva.tipo_reclamo.model.entities.TipoReclamo;
import com.bbva.tipo_reclamo.repository.TipoReclamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoReclamoService {

    private final TipoReclamoRepository tipoReclamoRepository;

    @Autowired
    public TipoReclamoService(TipoReclamoRepository tipoReclamoRepository) {
        this.tipoReclamoRepository = tipoReclamoRepository;
    }

    public List<TipoReclamo> listarTipoReclamos() {
        return tipoReclamoRepository.findAll();
    }

    public TipoReclamo crearTipoReclamo(TipoReclamo tipoReclamo) {
        return tipoReclamoRepository.save(tipoReclamo);
    }

    public Optional<TipoReclamo> obtenerTipoReclamoPorId(Long idTipoReclamo) {
        return tipoReclamoRepository.findById(idTipoReclamo);
    }

    public TipoReclamo actualizarEstadoYRespuesta(Long idTipoReclamo, String name) {
        Optional<TipoReclamo> tipoReclamoOptional = tipoReclamoRepository.findById(idTipoReclamo);
        if (tipoReclamoOptional.isPresent()) {
            TipoReclamo tipoReclamo = tipoReclamoOptional.get();
            tipoReclamo.setTipoReclamo(name);
            return tipoReclamoRepository.save(tipoReclamo);
        } else {
            throw new RuntimeException("Reclamo no encontrado con ID: " + idTipoReclamo);
        }
    }

    public String obtenerDescripcionPorCodigo(Long codigoTipoReclamo) {
        Optional<TipoReclamo> tipoReclamoOptional = tipoReclamoRepository.findById(codigoTipoReclamo);
        if (tipoReclamoOptional.isPresent()) {
            TipoReclamo tipoReclamo = tipoReclamoOptional.get();
            return tipoReclamo.getTipoReclamo();
        } else {
            throw new RuntimeException("Tipo de reclamo no encontrado con código: " + codigoTipoReclamo);
        }
    }

}
