package com.bus.sistema.app_reservacion.ModSeguridad.Services;

import com.bus.sistema.app_reservacion.ModSeguridad.Domain.Persona;

import java.util.List;

public interface PersonaService {
    public abstract List<Persona> listAllPersona();
    public abstract Persona findOneById(int id);
    public abstract void addPersona(Persona menu);
    public abstract int removePersona(int id);
    public abstract Persona save(Persona menu);
}
