package com.bus.sistema.app_reservacion.ModReservacion.Services.ServicesImpl;

import com.bus.sistema.app_reservacion.ModReservacion.Domain.Salida;
import com.bus.sistema.app_reservacion.ModReservacion.Repository.SalidaRepository;
import com.bus.sistema.app_reservacion.ModReservacion.Services.SalidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("salidaServiceImpl")
public class SalidaServiceImpl implements SalidaService {

    @Autowired
    @Qualifier("salidaRepository")
    private SalidaRepository salidaService;

    @Override
    public List<Salida> listAllSalidas() {
        return salidaService.findAll();
    }

    @Override
    public Salida findOneById(int id) {
        return salidaService.findOne(id);
    }

    @Override
    public void addSalida(Salida salida) {
        salidaService.save(salida);
    }

    @Override
    public int removeSalida(int id) {
        salidaService.delete(id);
        return 0;
    }

    @Override
    public Salida save(Salida salida) {
        return salidaService.save(salida);
    }
}
