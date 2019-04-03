package com.bus.sistema.app_reservacion.ModReservacion.Controller;

import com.bus.sistema.app_reservacion.ModReservacion.Domain.Endoce;
import com.bus.sistema.app_reservacion.ModReservacion.Domain.Salida;
import com.bus.sistema.app_reservacion.ModReservacion.Services.EndoceService;
import com.bus.sistema.app_reservacion.ModReservacion.Services.SalidaService;
import com.bus.sistema.app_reservacion.ModReservacion.Services.VehiculoService;
import com.bus.sistema.app_reservacion.ModSeguridad.Util.DTOEvents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/MantenimientoReservacion")
@Controller
public class SalidaController {

    @Autowired
    @Qualifier("salidaServiceImpl")
    private SalidaService salidaService;

    @Autowired
    @Qualifier("vehiculoServiceImpl")
    private VehiculoService vehiculoService;

    @Autowired
    @Qualifier("endoceServiceImpl")
    private EndoceService endoceService;

    @GetMapping(value = {"/home", "/", "/index", "/Mantenimiento"})
    public ModelAndView index() {
       /* ModelAndView model = new ModelAndView("/modreservacionView/Vehiculo/index");
        return model;*/
        return addSalida(new Salida(), new Endoce());
    }


    @GetMapping("/AddSalida")
    public ModelAndView addSalida(@ModelAttribute("salida") Salida salida, @ModelAttribute("endoce") Endoce endoce) {
        ModelAndView mv = new ModelAndView("/modreservacionView/Mantenimiento/index");
        mv.addObject("salidaObject", salida);
        mv.addObject("listaVehiculos", vehiculoService.listAllVehiculo());
        mv.addObject("listaSalidas", salidaService.listAllSalidas());

        mv.addObject("endoceObject", endoce);
        mv.addObject("listaEndoces", endoceService.listAllEndoce());

        return mv;
    }

    @PostMapping("/SaveSalida")
    public ModelAndView save(@Valid Salida salida, BindingResult result, String single_cal3) {
        if (result.hasErrors()) {
            return addSalida(salida, new Endoce());
        }
        salidaService.save(salida);
        return addSalida(new Salida(), new Endoce());
    }

    @PostMapping("/SaveEndoce")
    public ModelAndView saveEndoce(@Valid Endoce endoce, BindingResult result, String single_cal3) {
        if (result.hasErrors()) {
            return addSalida(new Salida(), endoce);
        }
        endoceService.save(endoce);
        return addSalida(new Salida(), new Endoce());
    }


    @GetMapping("/EditSalidao/{id}")
    public ModelAndView edit(@PathVariable("id") int id) {
        return addSalida(salidaService.findOneById(id), new Endoce());
    }

    @GetMapping("/DeleteSalida/{id}")
    public ModelAndView delete(@PathVariable("id") int id) {
        salidaService.removeSalida(id);
        return addSalida(new Salida(), new Endoce());
    }

    @GetMapping("/DeleteEndoce/{id}")
    public ModelAndView deleteEndoce(@PathVariable("id") int id) {
        endoceService.removeEndoce(id);
        return addSalida(new Salida(), new Endoce());
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/getEventos", method = RequestMethod.GET)
    public ResponseEntity<List<DTOEvents>> listAllUsers() {
        List<DTOEvents> eventos = new ArrayList<>();
        for (Salida salida : salidaService.listAllSalidas()) {
            //aumentar un dia

            eventos.add(
                    new DTOEvents(
                            salida.getSalidaId() + "",
                            salida.getDenominacion() + "",
                            new SimpleDateFormat("yyyy-MM-dd").format(salida.getFechaSalida()) + "T12:00:00",
//                            new SimpleDateFormat("yyyy-MM-dd").format(salida.getFechaSalida()) + "T0:00:00",
                            null,
                            null,
                            "#81d8d0"
                    )
            );
        }
        if (eventos.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<DTOEvents>>(eventos, HttpStatus.OK);
    }


}
