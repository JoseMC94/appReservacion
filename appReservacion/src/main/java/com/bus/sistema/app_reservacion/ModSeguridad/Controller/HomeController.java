package com.bus.sistema.app_reservacion.ModSeguridad.Controller;

import com.bus.sistema.app_reservacion.ModSeguridad.Domain.RolMenu;
import com.bus.sistema.app_reservacion.ModSeguridad.Repository.RolMenuRepository;
import com.bus.sistema.app_reservacion.ModSeguridad.Repository.UserRolRepository;
import com.bus.sistema.app_reservacion.ModSeguridad.Services.MenuService;
import com.bus.sistema.app_reservacion.ModSeguridad.Services.UserServiceE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/Home")
@Controller
public class HomeController {

    @Autowired
    @Qualifier("rolMenuRepository")
    private RolMenuRepository rolMenuRepository;

    @Autowired
    @Qualifier("userServiceEImpl")
    private UserServiceE userService;

    @Autowired
    @Qualifier("userRolRepository")
    private UserRolRepository userRolRepository;

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
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addObject("menu",userService.findOne(user.getUsername()).getPersonaByPersonaId().getNombreCompleto());
        String username = userService.findOne(user.getUsername()).getUsername();
        int usuarioId = userService.findOne(user.getUsername()).getUsuarioId();
        int RolId =userRolRepository.findByUsuarioId(usuarioId).getRolId() ;
        model.addObject("menus",rolMenuRepository.findAllByRolId(RolId));
        return model;
    }




}
