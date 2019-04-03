package com.bus.sistema.app_reservacion.ModReservacion.Controller;

import com.bus.sistema.app_reservacion.ModReservacion.Domain.Entradadiaria;
import com.bus.sistema.app_reservacion.ModReservacion.Domain.Pasaje;
import com.bus.sistema.app_reservacion.ModReservacion.Domain.Salida;
import com.bus.sistema.app_reservacion.ModReservacion.Domain.Vehiculo;
import com.bus.sistema.app_reservacion.ModReservacion.Repository.PasajeRepository;
import com.bus.sistema.app_reservacion.ModReservacion.Services.*;
import com.bus.sistema.app_reservacion.ModSeguridad.Domain.Persona;
import com.bus.sistema.app_reservacion.ModSeguridad.Domain.User;
import com.bus.sistema.app_reservacion.ModSeguridad.Services.PersonaService;
import com.bus.sistema.app_reservacion.ModSeguridad.Services.UserServiceE;
import com.bus.sistema.app_reservacion.ModSeguridad.Util.CustomErrorType;
import com.bus.sistema.app_reservacion.ModSeguridad.Util.DTOPasaje;
import com.bus.sistema.app_reservacion.ModSeguridad.Util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Reservacion")
@Controller
public class ReservacionController {
    public static final Logger logger = LoggerFactory.getLogger(VehiculoController.class);

    @Autowired
    @Qualifier("personaServiceImpl")
    private PersonaService personaService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView processForm() {
        String redirectUrl = "Reservacion/Calendario";
        return new ModelAndView("redirect:/" + redirectUrl);
    }

    @GetMapping(value = {"/home", "/", "/index", "/Calendario"})
    public ModelAndView index() {
        ModelAndView model = new ModelAndView("/ModReservacionView/Pasaje/Calendario");
        model.addObject("listaPersonas", personaService.listAllPersona());
        return model;
    }

    @GetMapping("/Pasaje")
    public ModelAndView Pasaje() {
        ModelAndView model = new ModelAndView("/modreservacionView/Pasaje/Pasaje");
        model.addObject("listaPersonas", personaService.listAllPersona());
        return model;
    }


    @Autowired
    @Qualifier("salidaServiceImpl")
    private SalidaService salidaService;

    @Autowired
    @Qualifier("endoceServiceImpl")
    private EndoceService endoceService;

    @Autowired
    @Qualifier("userServiceEImpl")
    private UserServiceE userService;


    @GetMapping("/VentaPasaje/{id}")
    public ModelAndView indexPasaje(@ModelAttribute("pasaje") DTOPasaje pasaje, @PathVariable("id") int id,@ModelAttribute("persona") Persona persona) {
        ModelAndView mv = new ModelAndView("/modreservacionView/Pasaje/Pasaje");
        User user = userService.findOne(SecurityContextHolder.getContext().getAuthentication().getName());
        Salida sld = salidaService.findOneById(id);
        mv.addObject("fecha", sld.getFechaSalida());
        pasaje.setFechaSalida(sld.getFechaSalida());
        mv.addObject("salida", sld.getDenominacion());
        mv.addObject("precio", sld.getPrecio());
        pasaje.setPrecio(Double.parseDouble(sld.getPrecio() + ""));
        mv.addObject("chofer", sld.getChofer());
        mv.addObject("ListaEndoces", endoceService.listAllEndoce());
        mv.addObject("usuarioConectado", userService.findOne(user.getUsername()).getPersonaByPersonaId().getNombres() + " " + userService.findOne(user.getUsername()).getPersonaByPersonaId().getPaterno());
        int numAsiento = sld.getPasajesBySalidaId().size() + 1;
        int capacidad = sld.getVehiculoByVehiculoId().getCapacidad();
        if (numAsiento <= capacidad) {
            mv.addObject("asiento", numAsiento);
            pasaje.setNumeroAsiento(numAsiento);
        } else {
            mv.addObject("asiento", "Vehiculo Lleno");
        }

        // Mandando ID's Foraneos
        mv.addObject("salidaId", sld.getSalidaId());
        pasaje.setSalidaId(sld.getSalidaId() + "");
        mv.addObject("usuarioId", userService.findOne(user.getUsername()).getUsuarioId());
        pasaje.setUsuarioId(userService.findOne(user.getUsername()).getUsuarioId());
        mv.addObject("pasajeObject", pasaje);
        mv.addObject("personaObject", persona);
        return mv;
    }

    @Autowired
    @Qualifier("PasajeServiceImpl")
    private PasajeService pasajeService;

    @Autowired
    @Qualifier("entradaDiariaServiceImpl")
    private EntradaDiariaService entradaDiariaService;

    @PostMapping("/SavePasaje")
    public ModelAndView save(@Valid DTOPasaje pasaje, BindingResult result, String single_cal3) {
        /*if (result.hasErrors()) {
            System.out.println(pasaje);
            System.out.println("\n\n" + result.toString());
            return processForm();
        }*/
        pasajeService.save(Util.convertPasaje(pasaje));
        Entradadiaria p =new Entradadiaria() ;
        p.setFechaEntrada(new Date(new java.util.Date().getTime()));
        p.setDenominacion("Venta pasaje: "+pasaje.getNombre());
        p.setValor(BigDecimal.valueOf(pasaje.getAbono()));
        entradaDiariaService.save(p);
        return processForm();
    }


    @GetMapping("/EditPasaje/{id}")
    public ModelAndView edit(@PathVariable("id") int id) {
        return indexPasaje(new DTOPasaje(), 0, new Persona());
    }

    @GetMapping("/DeletePasaje/{id}")
    public ModelAndView delete(@PathVariable("id") int id) {
        pasajeService.removePasaje(id);
        return indexPasaje(new DTOPasaje(), 0,new Persona());
    }

    @Autowired
    @Qualifier("pasajeRepository")
    private PasajeRepository pasajeRepository;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/pasajeros/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getPasajerps(@PathVariable("id") int id) {
        logger.info("Fetching User with id {}", id);

        List<Pasaje> pasajes = pasajeRepository.findAllBySalidaBySalidaId(salidaService.findOneById(id));
        List<Persona> personas = new ArrayList<>();

        for (Pasaje p : pasajes) {
            personas.add(p.getPersonaByPersonaId());
        }
        if (pasajes == null) {
            logger.error("User with id {} not found. ", id);
            return new ResponseEntity(new CustomErrorType("User with id " + id
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Persona>>(personas, HttpStatus.OK);
    }

}
