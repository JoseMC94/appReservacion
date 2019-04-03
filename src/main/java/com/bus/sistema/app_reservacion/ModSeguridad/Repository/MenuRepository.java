package com.bus.sistema.app_reservacion.ModSeguridad.Repository;

import com.bus.sistema.app_reservacion.ModSeguridad.Domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.ArrayList;

@Repository("menuRepository")
public interface MenuRepository extends JpaRepository<Menu, Serializable> {
}
