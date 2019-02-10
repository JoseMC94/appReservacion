package com.bus.sistema.app_reservacion.ModSeguridad.Services.ServicesImpl;

import com.bus.sistema.app_reservacion.ModSeguridad.Domain.Menu;
import com.bus.sistema.app_reservacion.ModSeguridad.Repository.MenuRepository;
import com.bus.sistema.app_reservacion.ModSeguridad.Services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("menuServiceImpl")
public class MenuServiceImpl implements MenuService {
    @Autowired
    @Qualifier("menuRepository")
    private MenuRepository menuJpaRepository;

    @Override
    public List<Menu> listAllMenu() {
        return menuJpaRepository.findAll();
    }

    @Override
    public Menu findOneById(int id) {
        return menuJpaRepository.findOne(id);
    }

    @Override
    public void addMenu(Menu menu) {
        menuJpaRepository.save(menu);
    }

    @Override
    public int removeMenu(int id) {
        menuJpaRepository.delete(id);
        return 0;
    }

    @Override
    public Menu save(Menu encargado) {
        return null;
    }

    public void guardarLista(ArrayList<Menu> listMenu){
        menuJpaRepository.save(listMenu);
    }
}
