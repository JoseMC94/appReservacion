package com.bus.sistema.app_reservacion.ModSeguridad.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

@RequestMapping("/Home")
@Controller
public class HomeController {

    @GetMapping(value = {"home", "/index", "/"})
    public ModelAndView index() {
        ModelAndView model = new ModelAndView("Home");
        DateFormat outFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        outFormat.setTimeZone(TimeZone.getTimeZone("America/Lima"));
        SimpleDateFormat dateformat3 = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        java.util.Date fechaPeru = null;
        try {
            fechaPeru = dateformat3.parse(outFormat.format(new java.util.Date()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        model.addObject("fechaPeru",fechaPeru);
        return model;
    }
}
