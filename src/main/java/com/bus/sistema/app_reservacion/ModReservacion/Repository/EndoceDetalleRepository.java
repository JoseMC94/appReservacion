package com.bus.sistema.app_reservacion.ModReservacion.Repository;

import com.bus.sistema.app_reservacion.ModReservacion.Domain.Endocedetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
@Repository("endoceDetalleRepository")
public interface EndoceDetalleRepository extends JpaRepository<Endocedetalle, Serializable> {
}
