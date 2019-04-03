package com.bus.sistema.app_reservacion.ModReservacion.Controller;

import com.bus.sistema.app_reservacion.ModReservacion.Domain.Endoce;
import com.bus.sistema.app_reservacion.ModReservacion.Domain.Salida;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/Endoce")
@Controller
public class EndoceController {


    @GetMapping(value = {"/home", "/", "/index", "/Endoce"})
    public ModelAndView index() {
       /* ModelAndView model = new ModelAndView("/modreservacionView/Vehiculo/index");
        return model; */
        return addEndoce(new Endoce());
    }

    @GetMapping("/AddSalida")
    public ModelAndView addEndoce(@ModelAttribute("endoce") Endoce endoce) {
        ModelAndView mv = new ModelAndView("/modreservacionView/Endoce/index");
        mv.addObject("endoceObject", endoce);
        return mv;
    }

    @GetMapping("listaEndoce")
    public ModelAndView listaEndoce() {
        ModelAndView mv = new ModelAndView("/modreservacionView/Endoce/ListaEndoce");
        return mv;
    }
}
