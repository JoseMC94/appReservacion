package com.bus.sistema.app_reservacion.ModReservacion;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/Reservacion")
@Controller
public class ReservacionController {

    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView model = new ModelAndView("/modreservacionView/index");
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addObject("detalle","Vista de Bus - Venta reservacion de pasaje");
        model.addObject("user", user.getUsername());
        return model;
    }
}
