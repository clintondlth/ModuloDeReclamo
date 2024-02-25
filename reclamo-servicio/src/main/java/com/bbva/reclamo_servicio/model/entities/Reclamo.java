package com.bbva.reclamo_servicio.model.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
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

    @Column(name = "ID_TIPO_RECLAMO")
    private Long idTipoReclamo;

    @Column(name = "ID_PRODUCTO")
    private Long idTipoproducto;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "FECHA_RECLAMO")
    private Date fechaReclamo;

    @Column(name = "FECHA_RESPUESTA")
    private Date fechaRespuesta;

    @Column(name = "DESCRIPCION_RECLAMO", columnDefinition = "TEXT")
    private String descripcionReclamo;

    @Column(name = "RESPUESTA_RECLAMO", columnDefinition = "TEXT")
    private String respuestaReclamo;

    @Column(name = "ESTADO_RECLAMO", length = 255)
    private String estadoReclamo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CLIENTE")
    private Cliente cliente;

    // Getters and setters

    @Override
    public String toString() {
        return "Reclamo{" +
                "id=" + id +
                ", idTipoReclamo=" + idTipoReclamo +
                ", idTipoproducto=" + idTipoproducto +
                ", fechaReclamo=" + fechaReclamo +
                ", fechaRespuesta=" + fechaRespuesta +
                ", descripcionReclamo='" + descripcionReclamo + '\'' +
                ", respuestaReclamo='" + respuestaReclamo + '\'' +
                ", estadoReclamo='" + estadoReclamo + '\'' +
                '}';
    }
}
