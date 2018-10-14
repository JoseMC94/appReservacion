package com.bus.sistema.app_reservacion.ModSeguridad.Services;


import com.bus.sistema.app_reservacion.ModSeguridad.Domain.UserRole;

import java.util.List;

public interface UserRolService {
    public abstract List<UserRole> listAllUserRole();

    public abstract UserRole findOneById(int id);

    public abstract void addUserRole(UserRole userRole);

    public abstract int removeUserRole(int id);

    public abstract UserRole save(UserRole userRole);
}
