package com.bus.sistema.app_reservacion.ModReservacion;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/Reservacion")
@Controller
public class ReservacionController {

    @GetMapping("/Pasaje")
    public ModelAndView index() {
        ModelAndView model = new ModelAndView("/modreservacionView/index");
        return model;
    }
}
