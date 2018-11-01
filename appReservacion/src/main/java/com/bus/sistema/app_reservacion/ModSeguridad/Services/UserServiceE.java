package com.bus.sistema.app_reservacion.ModSeguridad.Services;

import com.bus.sistema.app_reservacion.ModSeguridad.Domain.User;

import java.util.List;

public interface UserServiceE {
    public abstract List<User> listAllUsers();
    public abstract User findOne(String username);
    public abstract void addUser(User encargado);
    public abstract int removeUser(int id);
    public abstract User saveUser(User encargado);
}
