package com.bus.sistema.app_reservacion.ModSeguridad.Controller;

import com.bus.sistema.app_reservacion.ModSeguridad.Domain.Menu;
import com.bus.sistema.app_reservacion.ModSeguridad.Domain.RolMenu;
import com.bus.sistema.app_reservacion.ModSeguridad.Repository.MenuRepository;
import com.bus.sistema.app_reservacion.ModSeguridad.Repository.RolMenuRepository;
import com.bus.sistema.app_reservacion.ModSeguridad.Repository.UserRolRepository;
import com.bus.sistema.app_reservacion.ModSeguridad.Services.UserServiceE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/Home")
@Controller
public class HomeController {

    @GetMapping("/index")
    public ModelAndView home() {
        return home1();
    }

    @GetMapping("/")
    public ModelAndView index() {
        return home1();
    }

    @GetMapping("/home")
    public ModelAndView home1() {
        ModelAndView model = new ModelAndView("Home");
        return model;
    }



}
