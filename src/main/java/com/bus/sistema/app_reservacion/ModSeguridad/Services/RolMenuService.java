package com.bus.sistema.app_reservacion.ModSeguridad.Services;

import com.bus.sistema.app_reservacion.ModSeguridad.Domain.RolMenu;

import java.util.List;

public interface RolMenuService {
    public abstract List<RolMenu> listAllRolMenu();

    public abstract RolMenu findOneById(int id);

    public abstract void addRolMenu(RolMenu rolMenu);

    public abstract int removeRolMenu(int id);

    public abstract RolMenu save(RolMenu rolMenu);
}
