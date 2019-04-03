package com.bus.sistema.app_reservacion.ModSeguridad.Controller;

import com.bus.sistema.app_reservacion.ModSeguridad.Domain.Menu;
import com.bus.sistema.app_reservacion.ModSeguridad.Domain.Persona;
import com.bus.sistema.app_reservacion.ModSeguridad.Domain.User;
import com.bus.sistema.app_reservacion.ModSeguridad.Repository.UserRepository;
import com.bus.sistema.app_reservacion.ModSeguridad.Services.MenuService;
import com.bus.sistema.app_reservacion.ModSeguridad.Util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;

@RequestMapping("/Usuario")
@Controller
public class UsuarioController {

    @Autowired
    @Qualifier("userRepository")
    private UserRepository userService;
    @Autowired
    @Qualifier("menuServiceImpl")
    private MenuService menuService;

    @GetMapping(value = {"/home", "/", "/index", "/Usuarios"})
    public ModelAndView index() {
        ModelAndView model = new ModelAndView("/modSeguridadView/Roles/index");
        model.addObject("listaUsuarios", userService.findAll());
        System.out.println("\n\n"+userService.findAll()+"\n\n");
        return model;
    }

    @GetMapping("/MantenimientoUsuario/{id}")
    public ModelAndView mantenimientoUsuario(@PathVariable("id") int id) {
        return addUsuario(userService.findByUsuarioId(id), (ArrayList<Menu>) menuService.listAllMenu());
    }

    @GetMapping("/AddUsuario")
    public ModelAndView addUsuario(@ModelAttribute("usuario") User usuario,@ModelAttribute("roles") ArrayList<Menu> menuArrayList) {
        ModelAndView mv = new ModelAndView("/modSeguridadView/Roles/Mantenimiento");
        mv.addObject("usuarioObject", usuario);
        mv.addObject("menuArrayList", menuArrayList);
        mv.addObject("listaMenu",menuService.listAllMenu());
        return mv;
    }

    @PostMapping("/SaveUsuario")
    public ModelAndView save(@Valid User user, BindingResult result, String single_cal3) {
        user.setPassword(Util.encriptarContrasena(user.getPassword()));
       /* if (result.hasErrors())
            return addUsuario(user);*/
        userService.save(user);
        return processForm();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView processForm() {
        String redirectUrl = "Usuario/home";
        return new ModelAndView("redirect:/" + redirectUrl);
    }


    @PostMapping("/SaveRoles")
    public ModelAndView saveRoles(@Valid ArrayList<Menu> menuArrayList, BindingResult result, String single_cal3) {
        menuService.guardarLista(menuArrayList);
        return processForm();
    }

}
