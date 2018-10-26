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

@RequestMapping("/Persona")
@Controller
public class PersonaController {

    @Autowired
    @Qualifier("rolMenuRepository")
    private RolMenuRepository rolMenuRepository;

    @Autowired
    @Qualifier("userServiceEImpl")
    private UserServiceE userService;

    @Autowired
    @Qualifier("userRolRepository")
    private UserRolRepository userRolRepository;

    @Autowired
    @Qualifier("menuRepository")
    private MenuRepository menuRepository;

    @GetMapping("/index")
    public ModelAndView home() {
        return home1();
    }

    @GetMapping("/")
    public ModelAndView persona() {
        return home1();
    }
    @GetMapping("/Persona")
    public ModelAndView index() {
        return home1();
    }
    @GetMapping("/home")
    public ModelAndView home1() {
        ModelAndView model = new ModelAndView("/modSeguridadView/Persona");
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addObject("menu", userService.findOne(user.getUsername()).getPersonaByPersonaId().getNombreCompleto());
        List<RolMenu> listRolMenu = rolMenuRepository.findAllByRolId(userRolRepository.findByUsuarioId(userService.findOne(user.getUsername()).getUsuarioId()).getRolId());
        List<Menu> listMenu = menuRepository.findAll();
        ArrayList<Menu> listaMenuUsuario = new ArrayList<>();
        for (RolMenu rolMenu : listRolMenu) {
            for (Menu menu : listMenu) {
                if (rolMenu.getMenuId() == menu.getMenuId()) {
                    listaMenuUsuario.add(menu);
                }
            }
        }
        model.addObject("menus", listMenu);
        model.addObject("menus2", listMenu);
        return model;
    }



}
