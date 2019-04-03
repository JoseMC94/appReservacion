package com.bus.sistema.app_reservacion.ModVenta.Services.ServicesImpl;

import com.bus.sistema.app_reservacion.ModVenta.Domain.Venta;
import com.bus.sistema.app_reservacion.ModVenta.Repository.VentaRepository;
import com.bus.sistema.app_reservacion.ModVenta.Services.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ventaService")
public class VentaServiceImpl implements VentaService {
    @Autowired
    VentaRepository ventaRepository;
    @Override
    public Venta save(Venta entity) {
        return ventaRepository.save(entity);
    }

    @Override
    public Venta update(Venta entity) {
        return null;
    }

    @Override
    public void delete(Venta entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void deleteInBatch(List<Venta> entities) {

    }

    @Override
    public Venta find(int id) {
        return null;
    }

    @Override
    public List<Venta> findAll() {
        return null;
    }
}
