package com.bbva.reclamo_servicio.Security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class TokenController {

    @GetMapping("/token")
    public ResponseEntity<String> generateToken() {
        // Clave secreta para firmar el token (sustitúyela por una clave segura en un entorno real)
        String secretKey = "miClaveSecreta";

        // Tiempo de expiración del token (en milisegundos)
        long expirationTime = 3600000; // 1 hora

        // Fecha de expiración del token
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

        // Generar el token
        String token = Jwts.builder()
                .setSubject("usuario") // Puedes establecer cualquier identificador de usuario aquí
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();

        return ResponseEntity.ok(token);
    }
}
