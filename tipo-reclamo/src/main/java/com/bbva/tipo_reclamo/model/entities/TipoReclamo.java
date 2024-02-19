package com.bbva.tipo_reclamo.model.entities;

import jakarta.persistence.*;
import lombok.*;


import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tipo_reclamo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TipoReclamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TIPO_RECLAMO")
    private int idTipoReclamo;

    @Column(name = "TIPO_RECLAMO", columnDefinition = "TEXT")
    private String tipoReclamo;

    // Getters and setters

    @Override
    public String toString() {
        return "Reclamo{" +
                "idTipoReclamo=" + idTipoReclamo +
                ", tipoReclamo='" + tipoReclamo + '\'' +
                             '}';
    }
}
