package com.bus.sistema.app_reservacion.ModReservacion.Services.ServicesImpl;

import com.bus.sistema.app_reservacion.ModReservacion.Domain.Endocedetalle;
import com.bus.sistema.app_reservacion.ModReservacion.Repository.EndoceDetalleRepository;
import com.bus.sistema.app_reservacion.ModReservacion.Services.EndoceDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("endoceDetalleServiceImpl")
public class EndoceDetalleServiceImpl implements EndoceDetalleService {

    @Autowired
    @Qualifier("endoceDetalleRepository")
    private EndoceDetalleRepository endoceDetalleRepository;


    @Override
    public List<Endocedetalle> listAllEndocedetalles() {
        return endoceDetalleRepository.findAll();
    }

    @Override
    public Endocedetalle findOneById(int id) {
        return endoceDetalleRepository.findOne(id);
    }

    @Override
    public void addEndocedetalle(Endocedetalle endocedetalle) {
        endoceDetalleRepository.save(endocedetalle);
    }

    @Override
    public int removeEndocedetalle(int id) {
        endoceDetalleRepository.delete(id);
        return 0;
    }

    @Override
    public Endocedetalle save(Endocedetalle endocedetalle) {
        return endoceDetalleRepository.save(endocedetalle);
    }
}
