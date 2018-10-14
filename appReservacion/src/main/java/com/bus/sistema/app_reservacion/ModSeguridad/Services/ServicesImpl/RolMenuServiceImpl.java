package com.bus.sistema.app_reservacion.ModSeguridad.Services.ServicesImpl;

import com.bus.sistema.app_reservacion.ModSeguridad.Domain.RolMenu;
import com.bus.sistema.app_reservacion.ModSeguridad.Repository.RolMenuRepository;
import com.bus.sistema.app_reservacion.ModSeguridad.Services.RolMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("rolMenuServiceImpl")
public class RolMenuServiceImpl implements RolMenuService {

    @Autowired
    @Qualifier("rolMenuRepository")
    private RolMenuRepository rolMenuRepository;

    @Override
    public List<RolMenu> listAllRolMenu() {
        return rolMenuRepository.findAll();
    }

    @Override
    public RolMenu findOneById(int id) {
        return rolMenuRepository.findOne(id);
    }

    @Override
    public void addRolMenu(RolMenu rolMenu) {
        rolMenuRepository.save(rolMenu);
    }

    @Override
    public int removeRolMenu(int id) {
        rolMenuRepository.delete(id);
        return 0;
    }

    @Override
    public RolMenu save(RolMenu rolMenu) {
        return rolMenuRepository.save(rolMenu);
    }
}
