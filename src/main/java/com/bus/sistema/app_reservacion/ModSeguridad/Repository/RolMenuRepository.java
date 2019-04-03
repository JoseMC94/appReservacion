package com.bus.sistema.app_reservacion.ModSeguridad.Repository;

import com.bus.sistema.app_reservacion.ModSeguridad.Domain.RolMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("rolMenuRepository")
public interface RolMenuRepository extends JpaRepository<RolMenu, Serializable> {
    public abstract List<RolMenu> findAllByRolId(int id);
}
