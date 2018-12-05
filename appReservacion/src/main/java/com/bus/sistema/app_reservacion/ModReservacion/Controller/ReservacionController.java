package com.bus.sistema.app_reservacion.ModReservacion.Controller;

import com.bus.sistema.app_reservacion.ModSeguridad.Services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/Reservacion")
@Controller
public class ReservacionController {
    @Autowired
    @Qualifier("personaServiceImpl")
    private PersonaService personaService;


    @GetMapping(value = {"/home", "/", "/index", "/Pasaje"})
    public ModelAndView index() {
        ModelAndView model = new ModelAndView("/modreservacionView/Pasaje/index");
        model.addObject("listaPersonas", personaService.listAllPersona());
        return model;
    }
}
