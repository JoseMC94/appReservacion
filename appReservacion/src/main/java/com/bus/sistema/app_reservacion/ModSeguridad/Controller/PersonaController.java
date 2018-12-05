package com.bus.sistema.app_reservacion.ModSeguridad.Controller;

import com.bus.sistema.app_reservacion.ModSeguridad.Domain.Persona;
import com.bus.sistema.app_reservacion.ModSeguridad.Services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RequestMapping("/Persona")
@Controller
public class PersonaController {
    @Autowired
    @Qualifier("personaServiceImpl")
    private PersonaService personaService;

    @GetMapping(value = {"/home", "/", "/index", "/Persona"})
    public ModelAndView index() {
        ModelAndView model = new ModelAndView("/modSeguridadView/Persona/Persona");
        model.addObject("listaPersonas", personaService.listAllPersona());
        return model;
    }

    @GetMapping("/AddPersona")
    public ModelAndView addPersona(@ModelAttribute("persona") Persona persona) {
        ModelAndView mv = new ModelAndView("/modSeguridadView/Persona/PersonaEdit");
        mv.addObject("personaObject", persona);
        return mv;
    }

    @PostMapping("/SavePersona")
    public ModelAndView save(@Valid Persona persona, BindingResult result, String single_cal3) {
        persona.setNombreCompleto(persona.getNombres() + " " + persona.getPaterno() + " " + persona.getMaterno());
        if (result.hasErrors())
            return addPersona(persona);
        personaService.save(persona);
        return index();
    }


    @GetMapping("/EditPersona/{id}")
    public ModelAndView edit(@PathVariable("id") int id) {
        return addPersona(personaService.findOneById(id));
    }


}
