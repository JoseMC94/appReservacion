package com.bus.sistema.app_reservacion.ModReservacion.Repository;

import com.bus.sistema.app_reservacion.ModReservacion.Domain.Entradadiaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

@Repository("entradaDiariaRepository")
public interface EntradaDiariaRepository extends JpaRepository<Entradadiaria, Serializable> {
    public abstract ArrayList<Entradadiaria> findAllByFechaEntrada(Date fecha);

}
