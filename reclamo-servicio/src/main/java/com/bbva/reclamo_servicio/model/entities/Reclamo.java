package com.bbva.reclamo_servicio.model.entities;

import jakarta.persistence.*;

import lombok.*;

import java.util.Date;

@Entity
@Table(name = "reclamo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Reclamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_RECLAMO")
    private Long id;

    @JoinColumn(name = "ID_TIPO_RECLAMO")
    private int idTipoReclamo;

    @Column(name = "FECHA_RECLAMO", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date fechaReclamo;

    @Column(name = "FECHA_RESPUESTA")
    private Date fechaRespuesta;

    @Column(name = "DESCRIPCION_RECLAMO", columnDefinition = "TEXT")
    private String descripcionReclamo;

    @Column(name = "RESPUESTA_RECLAMO", columnDefinition = "TEXT")
    private String respuestaReclamo;

    @Column(name = "ESTADO_RECLAMO", length = 255)
    private String estadoReclamo;

    // Getters and setters

    @Override
    public String toString() {
        return "Reclamo{" +
                "id=" + id +
                ", idTipoReclamo=" + idTipoReclamo +
                ", fechaReclamo=" + fechaReclamo +
                ", fechaRespuesta=" + fechaRespuesta +
                ", descripcionReclamo='" + descripcionReclamo + '\'' +
                ", respuestaReclamo='" + respuestaReclamo + '\'' +
                ", estadoReclamo='" + estadoReclamo + '\'' +
                '}';
    }
}
