package com.bus.sistema.app_reservacion.ModReservacion.Services;

import com.bus.sistema.app_reservacion.ModReservacion.Domain.Entradadiaria;
import com.bus.sistema.app_reservacion.ModReservacion.Domain.Salidadiaria;

import java.sql.Date;
import java.util.List;

public interface SalidaDiariaService {
    public abstract List<Salidadiaria> listAllSalidadiarias();

    public abstract Salidadiaria findOneById(int id);

    public abstract void addSalidaDiaria(Salidadiaria salidadiaria);

    public abstract int removeSalidaDiaria(int id);

    public abstract Salidadiaria save(Salidadiaria salidadiaria);

    public List<Salidadiaria> listAllSalidaDiariasXFecha(Date fecha);

}
