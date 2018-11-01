package com.bus.sistema.app_reservacion.ModReservacion;

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

@RequestMapping("/Reservacion")
@Controller
public class ReservacionController {

    @GetMapping("/Pasaje")
    public ModelAndView index() {
        ModelAndView model = new ModelAndView("/modreservacionView/index");
        return model;
    }
}
