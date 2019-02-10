package com.bus.sistema.app_reservacion.ModReservacion.Repository;

import com.bus.sistema.app_reservacion.ModReservacion.Domain.Salida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("salidaRepository")
public interface SalidaRepository extends JpaRepository<Salida, Serializable> {

}
