package com.bus.sistema.app_reservacion.ModReservacion.Services.ServicesImpl;

import com.bus.sistema.app_reservacion.ModReservacion.Domain.Pasaje;
import com.bus.sistema.app_reservacion.ModReservacion.Repository.PasajeRepository;
import com.bus.sistema.app_reservacion.ModReservacion.Services.PasajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("PasajeServiceImpl")
public class PasajeServiceImpl implements PasajeService {
    @Autowired
    @Qualifier("pasajeRepository")
    private PasajeRepository pasajeRepository;

    @Override
    public List<Pasaje> listAllPasajes() {
        return pasajeRepository.findAll();
    }

    @Override
    public Pasaje findOneById(int id) {
        return pasajeRepository.findOne(id);
    }

    @Override
    public void addPasaje(Pasaje pasaje) {
        pasajeRepository.save(pasaje);
    }

    @Override
    public int removePasaje(int id) {
        pasajeRepository.delete(id);
        return 0;
    }

    @Override
    public Pasaje save(Pasaje pasaje) {
        return pasajeRepository.save(pasaje);
    }
}
