package com.bus.sistema.app_reservacion.ModSeguridad.Services.ServicesImpl;

import com.bus.sistema.app_reservacion.ModSeguridad.Domain.UserRole;
import com.bus.sistema.app_reservacion.ModSeguridad.Repository.UserRolRepository;
import com.bus.sistema.app_reservacion.ModSeguridad.Services.UserRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userRoleServiceImpl")
public class UserRoleServiceImpl implements UserRolService {

    @Autowired
    @Qualifier("userRolRepository")
    private UserRolRepository userRolRepository;

    @Override
    public List<UserRole> listAllUserRole() {
        return userRolRepository.findAll();
    }

    @Override
    public UserRole findOneById(int id) {
        return userRolRepository.findOne(id);
    }

    @Override
    public void addUserRole(UserRole userRole) {
        userRolRepository.save(userRole);
    }

    @Override
    public int removeUserRole(int id) {
        userRolRepository.delete(id);
        return 0;
    }

    @Override
    public UserRole save(UserRole userRole) {
        return userRolRepository.save(userRole);
    }


}
