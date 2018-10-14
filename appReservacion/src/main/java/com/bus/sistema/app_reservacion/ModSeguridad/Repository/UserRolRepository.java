package com.bus.sistema.app_reservacion.ModSeguridad.Repository;

import com.bus.sistema.app_reservacion.ModSeguridad.Domain.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("userRolRepository")
public interface UserRolRepository extends JpaRepository<UserRole, Serializable> {
    public abstract List<UserRole> findAllById(int id);
    public abstract UserRole findByUsuarioId(int id);
}
