package com.bus.sistema.app_reservacion.ModSeguridad.Controller;

import com.bus.sistema.app_reservacion.ModReservacion.Controller.VehiculoController;
import com.bus.sistema.app_reservacion.ModSeguridad.Domain.Persona;
import com.bus.sistema.app_reservacion.ModSeguridad.Repository.PersonaRepository;
import com.bus.sistema.app_reservacion.ModSeguridad.Services.PersonaService;
import com.bus.sistema.app_reservacion.ModSeguridad.Util.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Persona")
@Controller
public class PersonaController {
    public static final Logger logger = LoggerFactory.getLogger(VehiculoController.class);

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
        if (result.hasErrors()) {
            System.out.println("\n\nerror: " + result.getAllErrors());
            return addPersona(persona);
        }
        personaService.save(persona);
        return index();
    }


    @GetMapping("/EditPersona/{id}")
    public ModelAndView edit(@PathVariable("id") int id) {
        return addPersona(personaService.findOneById(id));
    }


    @Autowired
    @Qualifier("personaRepository")
    private PersonaRepository personaRepository;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<List<Persona>> listAllUsers() {
        List<Persona> users = personaService.listAllPersona();
        if (users.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Persona>>(users, HttpStatus.OK);
    }


    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable("id") String id) {
        //logger.info("Fetching User with id {}", id);
        Persona user = personaRepository.findPersonaByDni(id);
        if (user == null) {
            logger.error("User with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("User with id " + id
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Persona>(user, HttpStatus.OK);
    }


    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public ResponseEntity<List<Persona>> listAllPerson() {
        List<Persona> persons = personaService.listAllPersona();
        for (Persona p : personaService.listAllPersona()) {
            persons.add(
                  new Persona(p.getPersonaId(),p.getNombreCompleto())
            );
        }
        if (persons.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Persona>>(persons, HttpStatus.OK);
    }

}
