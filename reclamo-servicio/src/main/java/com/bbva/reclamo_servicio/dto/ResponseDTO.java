package com.bbva.reclamo_servicio.dto;

import com.bbva.reclamo_servicio.model.entities.Reclamo;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {

    private Reclamo reclamo;
    private String nombreTipoReclamo;
}
