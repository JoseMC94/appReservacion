package com.bus.sistema.app_reservacion.ModSeguridad.Services.ServicesImpl;

import com.bus.sistema.app_reservacion.ModSeguridad.Domain.Persona;
import com.bus.sistema.app_reservacion.ModSeguridad.Repository.PersonaRepository;
import com.bus.sistema.app_reservacion.ModSeguridad.Services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("personaServiceImpl")
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    @Qualifier("personaRepository")
    private PersonaRepository personaJpaRepository;
    @Override
    public List<Persona> listAllPersona() {
        return personaJpaRepository.findAll();
    }

    @Override
    public Persona findOneById(int id) {
        return personaJpaRepository.findOne(id);
    }

    @Override
    public void addPersona(Persona persona) {
        personaJpaRepository.save(persona);
    }

    @Override
    public int removePersona(int id) {
        personaJpaRepository.delete(id);
        return 0;
    }

    @Override
    public Persona save(Persona persona) {
        return personaJpaRepository.save(persona);
    }
}
