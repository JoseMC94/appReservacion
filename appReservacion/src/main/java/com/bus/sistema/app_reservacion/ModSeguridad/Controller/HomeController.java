package com.bus.sistema.app_reservacion.ModSeguridad.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/Home")
@Controller
public class HomeController {

    @GetMapping(value = {"home", "/index", "/"})
    public ModelAndView index() {
        ModelAndView model = new ModelAndView("Home");
        return model;
    }
}
