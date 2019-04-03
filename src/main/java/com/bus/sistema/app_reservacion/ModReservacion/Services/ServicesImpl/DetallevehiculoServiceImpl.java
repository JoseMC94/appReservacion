package com.bus.sistema.app_reservacion.ModReservacion.Services.ServicesImpl;

import com.bus.sistema.app_reservacion.ModReservacion.Domain.Detallevehiculo;
import com.bus.sistema.app_reservacion.ModReservacion.Repository.DetalleVehiculoRepository;
import com.bus.sistema.app_reservacion.ModReservacion.Services.DetalleVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("detallevehiculoServiceImpl")
public class DetallevehiculoServiceImpl implements DetalleVehiculoService {

    @Autowired
    @Qualifier("detalleVehiculoRepository")
    private DetalleVehiculoRepository detalleVehiculoRepository;

    @Override
    public List<Detallevehiculo> listAllDetallevehiculos() {
        return detalleVehiculoRepository.findAll();
    }

    @Override
    public Detallevehiculo findOneById(int id) {
        return detalleVehiculoRepository.findOne(id);
    }

    @Override
    public void addDetallevehiculo(Detallevehiculo detallevehiculo) {
        detalleVehiculoRepository.save(detallevehiculo);
    }

    @Override
    public int removeDetallevehiculo(int id) {
        detalleVehiculoRepository.delete(id);
        return 0;
    }

    @Override
    public Detallevehiculo save(Detallevehiculo detallevehiculo) {
        return detalleVehiculoRepository.save(detallevehiculo);
    }


}
