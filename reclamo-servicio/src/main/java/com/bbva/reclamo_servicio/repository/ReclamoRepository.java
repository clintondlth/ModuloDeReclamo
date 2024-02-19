package com.bbva.reclamo_servicio.repository;


;
import com.bbva.reclamo_servicio.model.entities.Reclamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReclamoRepository  extends JpaRepository<Reclamo, Long> {


}
