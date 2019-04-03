package com.bus.sistema.app_reservacion.ModSeguridad.Repository;

import com.bus.sistema.app_reservacion.ModSeguridad.Domain.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("rolRepository")
public interface RolRepository extends JpaRepository<Rol, Serializable> {
}
