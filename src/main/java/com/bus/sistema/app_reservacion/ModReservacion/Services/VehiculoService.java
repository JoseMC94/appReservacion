package com.bus.sistema.app_reservacion.ModReservacion.Services;

import com.bus.sistema.app_reservacion.ModReservacion.Domain.Vehiculo;

import java.util.List;

public interface VehiculoService {
    public abstract List<Vehiculo> listAllVehiculo();

    public abstract Vehiculo findOneById(int id);

    public abstract void addVehiculo(Vehiculo menu);

    public abstract int removeMenu(int id);

    public abstract Vehiculo save(Vehiculo menu);

}
