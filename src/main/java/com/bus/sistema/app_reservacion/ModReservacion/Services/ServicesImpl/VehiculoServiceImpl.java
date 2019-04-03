package com.bus.sistema.app_reservacion.ModReservacion.Services.ServicesImpl;

import com.bus.sistema.app_reservacion.ModReservacion.Domain.Vehiculo;
import com.bus.sistema.app_reservacion.ModReservacion.Repository.VehiculoRepository;
import com.bus.sistema.app_reservacion.ModReservacion.Services.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("vehiculoServiceImpl")
public class VehiculoServiceImpl implements VehiculoService {

    @Autowired
    @Qualifier("vehiculoRepository")
    private VehiculoRepository vehiculoRepository;

    @Override
    public List<Vehiculo> listAllVehiculo() {
        return vehiculoRepository.findAll();
    }

    @Override
    public Vehiculo findOneById(int id) {
        return vehiculoRepository.findOne(id);
    }

    @Override
    public void addVehiculo(Vehiculo vehiculo) {
        vehiculoRepository.save(vehiculo);
    }

    @Override
    public int removeMenu(int id) {
        vehiculoRepository.delete(id);
        return 0;
    }

    @Override
    public Vehiculo save(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }
}
