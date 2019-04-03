package com.bus.sistema.app_reservacion.ModSeguridad.Repository;

import com.bus.sistema.app_reservacion.ModSeguridad.Domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.ArrayList;

@Repository("personaRepository")
public interface PersonaRepository extends JpaRepository<Persona, Serializable> {
    public abstract Persona findPersonaByDni(String id);
    Persona findByNombreCompleto(String nombreCompleto);

}
