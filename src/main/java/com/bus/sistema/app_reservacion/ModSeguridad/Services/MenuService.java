package com.bus.sistema.app_reservacion.ModSeguridad.Services;

import com.bus.sistema.app_reservacion.ModSeguridad.Domain.Menu;

import java.util.ArrayList;
import java.util.List;

public interface MenuService {
    public abstract List<Menu> listAllMenu();

    public abstract Menu findOneById(int id);

    public abstract void addMenu(Menu menu);

    public abstract int removeMenu(int id);

    public abstract Menu save(Menu menu);

    public void guardarLista(ArrayList<Menu> listMenu);
}
