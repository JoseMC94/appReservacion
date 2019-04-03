package com.bus.sistema.app_reservacion.ModVenta.Controller;

import com.bus.sistema.app_reservacion.ModSeguridad.Repository.PersonaRepository;
import com.bus.sistema.app_reservacion.ModVenta.Domain.Venta;
import com.bus.sistema.app_reservacion.ModVenta.Repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Reporte")
@Controller
public class ReporteController {

    @Autowired
    @Qualifier("VentaRepository")
    private VentaRepository ventaRepository;
    @Autowired
    @Qualifier("personaRepository")
    PersonaRepository personaRepository;

    @GetMapping(value = {"/home", "/Reporte", "", "/", "/index", "/Mantenimiento"})
    public ModelAndView index(ArrayList<Venta> l) {
        ModelAndView model = new ModelAndView("/ModReservacionView/venta/Reportes");
        model.addObject("lista", l);
        double ingresos = 0;
        double egresos = 0;
        if (!l.isEmpty()) {
            for (Venta v : l) {
                if (v.getMontoDescuento().doubleValue() == 0) {
                    egresos = egresos + v.getMontoSaldo().doubleValue();
                }
                ingresos = ingresos + v.getMontoDescuento().doubleValue();
            }
        }
        model.addObject("ingresos", ingresos);
        model.addObject("egresos", egresos);
        return model;
    }

    @PostMapping("/Mostrar")
    public ModelAndView save(@RequestParam("nombreCompleto") String nombreCompleto, @RequestParam("mes") int mes, @RequestParam("ano") int ano) {
        return index(ventaRepository.listarPorUsuarioyFecha(personaRepository.findByNombreCompleto(nombreCompleto).getPersonaId(), mes, ano));
    }
}
