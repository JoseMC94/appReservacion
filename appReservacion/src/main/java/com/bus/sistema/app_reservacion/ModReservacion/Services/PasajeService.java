package com.bus.sistema.app_reservacion.ModReservacion.Services;

import com.bus.sistema.app_reservacion.ModReservacion.Domain.Pasaje;

import java.util.List;

public interface PasajeService {
    public abstract List<Pasaje> listAllPasajes();

    public abstract Pasaje findOneById(int id);

    public abstract void addPasaje(Pasaje pasaje);

    public abstract int removePasaje(int id);

    public abstract Pasaje save(Pasaje pasaje);
}
