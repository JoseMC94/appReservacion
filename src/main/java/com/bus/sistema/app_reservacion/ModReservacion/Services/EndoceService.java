package com.bus.sistema.app_reservacion.ModReservacion.Services;

import com.bus.sistema.app_reservacion.ModReservacion.Domain.Endoce;

import java.util.List;

public interface EndoceService {
    public abstract List<Endoce> listAllEndoce();

    public abstract Endoce findOneById(int id);

    public abstract void addEndoce(Endoce endoce);

    public abstract int removeEndoce(int id);

    public abstract Endoce save(Endoce endoce);
}
