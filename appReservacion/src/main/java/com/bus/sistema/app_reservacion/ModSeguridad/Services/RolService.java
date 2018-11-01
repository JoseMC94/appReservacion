package com.bus.sistema.app_reservacion.ModSeguridad.Services;

import com.bus.sistema.app_reservacion.ModSeguridad.Domain.Rol;

import java.util.List;

public interface RolService {
    public abstract List<Rol> listAllRol();

    public abstract Rol findOneById(int id);

    public abstract void addRol(Rol rol);

    public abstract int removeRol(int id);

    public abstract Rol save(Rol rol);
}
