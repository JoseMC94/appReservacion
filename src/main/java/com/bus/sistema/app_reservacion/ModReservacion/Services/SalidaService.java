package com.bus.sistema.app_reservacion.ModReservacion.Services;

import com.bus.sistema.app_reservacion.ModReservacion.Domain.Salida;

import java.util.List;

public interface SalidaService {
    public abstract List<Salida> listAllSalidas();

    public abstract Salida findOneById(int id);

    public abstract void addSalida(Salida salida);

    public abstract int removeSalida(int id);

    public abstract Salida save(Salida salida);
}
