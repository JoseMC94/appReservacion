package com.bus.sistema.app_reservacion.ModSeguridad.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/Home")
@Controller
public class HomeController {

    @GetMapping("/index")
    public String home() {
        return "Home";
    }

    @GetMapping("/")
    public String index() {
        return "Home";
    }

    @GetMapping("/form")
    public String form() {
        return "/form";
    }

    @GetMapping("/list")
    public String list() {
        return "/list";
    }

    @GetMapping("/home")
    public ModelAndView home1() {
        ModelAndView model = new ModelAndView("Home");
        //User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //model.addObject("user", user.getUsername());
        //model.addObject("miembros",miembroconsejofacultadService.listAllEncargado());
        return model;
    }


}
