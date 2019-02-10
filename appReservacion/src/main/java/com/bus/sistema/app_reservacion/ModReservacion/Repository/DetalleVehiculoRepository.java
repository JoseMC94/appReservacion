package com.bus.sistema.app_reservacion.ModReservacion.Repository;

import com.bus.sistema.app_reservacion.ModReservacion.Domain.Detallevehiculo;
import com.bus.sistema.app_reservacion.ModReservacion.Domain.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.ArrayList;

@Repository("detalleVehiculoRepository")
public interface DetalleVehiculoRepository extends JpaRepository<Detallevehiculo, Serializable> {
    public abstract ArrayList<Detallevehiculo> findAllByVehiculoByVehiculoId(Vehiculo id);

}
