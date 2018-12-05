package com.bus.sistema.app_reservacion.ModSeguridad.Controller;

import com.bus.sistema.app_reservacion.ModSeguridad.Domain.User;
import com.bus.sistema.app_reservacion.ModSeguridad.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/Usuario")
@Controller
public class UsuarioController {

    @Autowired
    @Qualifier("userRepository")
    private UserRepository userService;

    @GetMapping(value = {"/home", "/", "/index", "/Usuarios"})
    public ModelAndView index() {
        ModelAndView model = new ModelAndView("/modSeguridadView/Roles/index");
        return model;
    }

    @GetMapping("/MantenimientoUsuario/{id}")
    public ModelAndView mantenimientoUsuario(@PathVariable("id") int id) {
        return addUsuario(userService.findByUsuarioId(id));
    }

    @GetMapping("/AddUsuario")
    public ModelAndView addUsuario(@ModelAttribute("usuario") User usuario) {
        ModelAndView mv = new ModelAndView("/modSeguridadView/Roles/Mantenimiento");
        mv.addObject("usuarioObject", usuario);
        return mv;
    }
}
