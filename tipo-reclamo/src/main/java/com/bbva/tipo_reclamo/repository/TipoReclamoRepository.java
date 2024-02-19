package com.bbva.tipo_reclamo.repository;

import com.bbva.tipo_reclamo.model.entities.TipoReclamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoReclamoRepository  extends JpaRepository<TipoReclamo, Long> {


}
