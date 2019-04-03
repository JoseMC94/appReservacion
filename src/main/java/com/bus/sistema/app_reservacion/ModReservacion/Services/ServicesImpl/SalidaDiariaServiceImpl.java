package com.bus.sistema.app_reservacion.ModReservacion.Services.ServicesImpl;

import com.bus.sistema.app_reservacion.ModReservacion.Domain.Salidadiaria;
import com.bus.sistema.app_reservacion.ModReservacion.Repository.SalidaDiariaRepository;
import com.bus.sistema.app_reservacion.ModReservacion.Services.SalidaDiariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service("salidaDiariaServiceImpl")
public class SalidaDiariaServiceImpl implements SalidaDiariaService {

    @Autowired
    @Qualifier("salidaDiariaRepository")
    private SalidaDiariaRepository salidaDiariaRepository;


    @Override
    public List<Salidadiaria> listAllSalidadiarias() {
        return salidaDiariaRepository.findAll();
    }

    @Override
    public Salidadiaria findOneById(int id) {
        return salidaDiariaRepository.findOne(id);
    }

    @Override
    public void addSalidaDiaria(Salidadiaria salidadiaria) {
        salidaDiariaRepository.save(salidadiaria);
    }

    @Override
    public int removeSalidaDiaria(int id) {
        salidaDiariaRepository.delete(id);
        return 0;
    }

    @Override
    public Salidadiaria save(Salidadiaria salidadiaria) {
        return salidaDiariaRepository.save(salidadiaria);
    }

    @Override
    public List<Salidadiaria> listAllSalidaDiariasXFecha(Date fecha) {
        return salidaDiariaRepository.findAllByFechaSalida(fecha);
    }
}
