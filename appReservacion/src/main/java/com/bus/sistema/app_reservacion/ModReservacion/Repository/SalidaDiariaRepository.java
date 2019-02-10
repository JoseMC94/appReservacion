package com.bus.sistema.app_reservacion.ModReservacion.Repository;

import com.bus.sistema.app_reservacion.ModReservacion.Domain.Salidadiaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

@Repository("salidaDiariaRepository")
public interface SalidaDiariaRepository extends JpaRepository<Salidadiaria, Serializable> {
    public abstract ArrayList<Salidadiaria> findAllByFechaSalida(Date fecha);
}
