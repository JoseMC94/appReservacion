package com.bus.sistema.app_reservacion.ModReservacion.Services;

import com.bus.sistema.app_reservacion.ModReservacion.Domain.Endocedetalle;

import java.util.List;

public interface EndoceDetalleService {
    public abstract List<Endocedetalle> listAllEndocedetalles();

    public abstract Endocedetalle findOneById(int id);

    public abstract void addEndocedetalle(Endocedetalle endocedetalle);

    public abstract int removeEndocedetalle(int id);

    public abstract Endocedetalle save(Endocedetalle endocedetalle);
}
