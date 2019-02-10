package com.bus.sistema.app_reservacion.ModReservacion.Services.ServicesImpl;

import com.bus.sistema.app_reservacion.ModReservacion.Domain.Entradadiaria;
import com.bus.sistema.app_reservacion.ModReservacion.Repository.EntradaDiariaRepository;
import com.bus.sistema.app_reservacion.ModReservacion.Services.EntradaDiariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service("entradaDiariaServiceImpl")
public class EntradaDiariaServiceImpl implements EntradaDiariaService {

    @Autowired
    @Qualifier("entradaDiariaRepository")
    private EntradaDiariaRepository entradaDiariaRepository;

    @Override
    public List<Entradadiaria> listAllEntradadiarias() {
        return entradaDiariaRepository.findAll();
    }

    @Override
    public Entradadiaria findOneById(int id) {
        return entradaDiariaRepository.findOne(id);
    }

    @Override
    public void addEntradaDiaria(Entradadiaria entradadiaria) {
        entradaDiariaRepository.save(entradadiaria);
    }

    @Override
    public int removeEntradaDiaria(int id) {
        entradaDiariaRepository.delete(id);
        return 0;
    }

    @Override
    public Entradadiaria save(Entradadiaria entradadiaria) {
        return entradaDiariaRepository.save(entradadiaria);
    }

    @Override
    public List<Entradadiaria> listAllEntradadiariasXFecha(Date fecha){
        return entradaDiariaRepository.findAllByFechaEntrada(fecha);
    }
}
