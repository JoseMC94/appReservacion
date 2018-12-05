package com.bus.sistema.app_reservacion.ModReservacion.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/Vehiculo")
@Controller
public class VehiculoController {
    @GetMapping(value = {"/home", "/", "/index", "/Vehiculo"})
    public ModelAndView index() {
        ModelAndView model = new ModelAndView("/modreservacionView/Vehiculo/index");
        return model;
    }
}
