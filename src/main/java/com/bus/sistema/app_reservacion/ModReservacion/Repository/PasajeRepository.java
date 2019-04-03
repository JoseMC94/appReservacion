package com.bus.sistema.app_reservacion.ModReservacion.Repository;

import com.bus.sistema.app_reservacion.ModReservacion.Domain.Pasaje;
import com.bus.sistema.app_reservacion.ModReservacion.Domain.Salida;
import com.bus.sistema.app_reservacion.ModSeguridad.Domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.ArrayList;

@Repository("pasajeRepository")
public interface PasajeRepository extends JpaRepository<Pasaje, Serializable> {
    public abstract ArrayList<Pasaje> findAllBySalidaBySalidaId(Salida id);
}


















