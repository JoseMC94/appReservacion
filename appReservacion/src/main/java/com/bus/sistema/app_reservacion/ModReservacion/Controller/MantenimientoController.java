package com.bus.sistema.app_reservacion.ModReservacion.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@RequestMapping("/MantenimientoReservaon")
@Controller
public class MantenimientoController {
    @GetMapping(value = {"/home", "/", "/index", "/Mantenimiento"})
    public ModelAndView index() {
        ModelAndView model = new ModelAndView("/modreservacionView/Mantenimiento/index");
        return model;
    }

}
