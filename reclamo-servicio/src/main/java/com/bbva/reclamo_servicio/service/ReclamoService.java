package com.bbva.reclamo_servicio.service;




import com.bbva.reclamo_servicio.dto.ResponseDTO;
import com.bbva.reclamo_servicio.dto.TipoReclamoDTO;
import com.bbva.reclamo_servicio.model.entities.Reclamo;
import com.bbva.reclamo_servicio.repository.ReclamoRepository;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service


public class ReclamoService {

    private final RestTemplate restTemplate;

    private final ReclamoRepository reclamoRepository;


    @Autowired
    public ReclamoService(RestTemplate restTemplate, ReclamoRepository reclamoRepository) {
        this.restTemplate = restTemplate;
        this.reclamoRepository = reclamoRepository;
    }

    public List<Reclamo> listarReclamos() {
        return reclamoRepository.findAll();
    }

    public Reclamo crearReclamo(Reclamo reclamo) {
        return reclamoRepository.save(reclamo);
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

    public Reclamo obtenerReclamoPorId(Long id) {
        Optional<Reclamo> reclamoOptional = reclamoRepository.findById(id);
        return reclamoOptional.orElseThrow(() -> new RuntimeException("Reclamo no encontrado en la base de datos con codgio: " + id));
    }


/*
public ResponseDTO getReclamoByid(Long id) {
    ResponseDTO responseDTO = new ResponseDTO();
    Optional<Reclamo> reclamoOptional = reclamoRepository.findById(id);

    if (reclamoOptional.isPresent()) {
        Reclamo reclamo = reclamoOptional.get();
        responseDTO.setReclamo(reclamo);


        ResponseEntity<TipoReclamoDTO> responseEntity = restTemplate.getForEntity(
                "http://localhost:8084/tipo-reclamos/" + reclamo.getIdTipoReclamo(),
                TipoReclamoDTO.class);

        TipoReclamoDTO tipoReclamoDTO = responseEntity.getBody();
        if (tipoReclamoDTO != null) {
            responseDTO.setNombreTipoReclamo(tipoReclamoDTO.getNombreTipoReclamo());
        }
    }

    return responseDTO;
}
*/
}
