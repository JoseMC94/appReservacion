package com.bus.sistema.app_reservacion.ModSeguridad.Services.ServicesImpl;

import com.bus.sistema.app_reservacion.ModSeguridad.Domain.User;
import com.bus.sistema.app_reservacion.ModSeguridad.Repository.UserRepository;
import com.bus.sistema.app_reservacion.ModSeguridad.Services.UserServiceE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userServiceEImpl")
public class UserServiceImpl implements UserServiceE {

    @Autowired
    @Qualifier("userRepository")
    private UserRepository userJpaRepository;


    @Override
    public List<User> listAllUsers() {

        return userJpaRepository.findAll();
    }

    @Override
    public User findOne(String user) {
        return userJpaRepository.findByUsername(user);
    }

    @Override
    public void addUser(User encargado) {

    }



    @Override
    public int removeUser(int id) {
        return 0;
    }

    @Override
    public User saveUser(User encargado) {
        return null;
    }

    @Override
    public String toString() {
        return "user implement";
    }
}
