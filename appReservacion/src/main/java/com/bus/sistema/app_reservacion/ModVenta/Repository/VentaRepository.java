package com.bus.sistema.app_reservacion.ModVenta.Repository;

import com.bus.sistema.app_reservacion.ModVenta.Domain.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.ArrayList;

@Repository("VentaRepository")
public interface VentaRepository extends JpaRepository<Venta, Serializable> {
    public ArrayList<Venta> findAllByPersonaId(int idPersona);

    @Query(value = "SELECT * FROM Venta u WHERE u.PersonaId = ?1 and MONTH(u.Fecha) = ?2 and YEAR(u.Fecha) = ?3", nativeQuery = true)
    ArrayList<Venta> listarPorUsuarioyFecha(int personaId,int mes,int anio);

}
