package com.bus.sistema.app_reservacion.ModReservacion.Services;

import com.bus.sistema.app_reservacion.ModReservacion.Domain.Entradadiaria;

import java.sql.Date;
import java.util.List;

public interface EntradaDiariaService {
    public abstract List<Entradadiaria> listAllEntradadiarias();

    public abstract Entradadiaria findOneById(int id);

    public abstract void addEntradaDiaria(Entradadiaria entradadiaria);

    public abstract int removeEntradaDiaria(int id);

    public abstract Entradadiaria save(Entradadiaria entradadiaria);

    public List<Entradadiaria> listAllEntradadiariasXFecha(Date fecha);
}
