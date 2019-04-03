package com.bus.sistema.app_reservacion.ModReservacion.Services;

import com.bus.sistema.app_reservacion.ModReservacion.Domain.Detallevehiculo;

import java.util.List;

public interface DetalleVehiculoService {
    public abstract List<Detallevehiculo> listAllDetallevehiculos();

    public abstract Detallevehiculo findOneById(int id);

    public abstract void addDetallevehiculo(Detallevehiculo detallevehiculo);

    public abstract int removeDetallevehiculo(int id);

    public abstract Detallevehiculo save(Detallevehiculo detallevehiculo);
}
