package com.bbva.serviciodereclamo_cliente.model.entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "CLIENTE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIENTE")
    private int idCliente;

    @Column(name = "NOMBRE_CLIENTE", length = 255)
    private String nombreCliente;

    @Column(name = "APELLIDO_PATERNO", length = 255)
    private String apellidoPaterno;

    @Column(name = "APELLIDO_MATERNO", length = 255)
    private String apellidoMaterno;

    @Column(name = "DNI", length = 20)
    private String dni;

    @Column(name = "TELEFONO", length = 20)
    private String telefono;

    @Column(name = "EMAIL", length = 255)
    private String email;

    @Column(name = "FECHA_AFILIACION")
    private Date fechaAfiliacion;

    @Column(name = "ESTADO", length = 50)
    private String estado;






    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", dni='" + dni + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", fechaAfiliacion=" + fechaAfiliacion +
                ", estado='" + estado + '\'' +
                '}';
    }
}
