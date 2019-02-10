package com.bus.sistema.app_reservacion.ModReservacion.Services.ServicesImpl;

import com.bus.sistema.app_reservacion.ModReservacion.Domain.Endoce;
import com.bus.sistema.app_reservacion.ModReservacion.Repository.EndoceRepository;
import com.bus.sistema.app_reservacion.ModReservacion.Services.EndoceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("endoceServiceImpl")
public class EndoceServiceImpl implements EndoceService {
    @Autowired
    @Qualifier("endoceRepository")
    private EndoceRepository endoceRepository;

    @Override
    public List<Endoce> listAllEndoce() {
        return endoceRepository.findAll();
    }

    @Override
    public Endoce findOneById(int id) {
        return endoceRepository.findOne(id);
    }

    @Override
    public void addEndoce(Endoce endoce) {
        endoceRepository.save(endoce);
    }

    @Override
    public int removeEndoce(int id) {
        endoceRepository.delete(id);
        return 0;
    }

    @Override
    public Endoce save(Endoce endoce) {
        return endoceRepository.save(endoce);
    }
}
