package com.bus.sistema.app_reservacion.ModSeguridad.Services.ServicesImpl;

import com.bus.sistema.app_reservacion.ModSeguridad.Domain.Rol;
import com.bus.sistema.app_reservacion.ModSeguridad.Repository.RolRepository;
import com.bus.sistema.app_reservacion.ModSeguridad.Services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("rolServiceImpl")
public class RolServiceImpl implements RolService {
    @Autowired
    @Qualifier("rolRepository")
    private RolRepository rolRepository;

    @Override
    public List<Rol> listAllRol() {
        return rolRepository.findAll();
    }

    @Override
    public Rol findOneById(int id) {
        return rolRepository.findOne(id);
    }

    @Override
    public void addRol(Rol rol) {
        rolRepository.save(rol);
    }

    @Override
    public int removeRol(int id) {
        rolRepository.delete(id);
        return 0;
    }

    @Override
    public Rol save(Rol rol) {
        return rolRepository.save(rol);
    }
}
