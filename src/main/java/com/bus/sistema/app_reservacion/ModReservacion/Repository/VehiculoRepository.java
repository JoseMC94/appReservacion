package com.bus.sistema.app_reservacion.ModReservacion.Repository;

import com.bus.sistema.app_reservacion.ModReservacion.Domain.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("vehiculoRepository")
public interface VehiculoRepository extends JpaRepository<Vehiculo, Serializable> {
}
