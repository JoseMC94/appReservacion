package com.bus.sistema.app_reservacion.ModVenta.Repository;

import com.bus.sistema.app_reservacion.ModVenta.Domain.Producto;
import com.bus.sistema.app_reservacion.ModVenta.Domain.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.ArrayList;

@Repository("productoRepository")
public interface ProductoRepository extends JpaRepository<Producto, Serializable> {
}
