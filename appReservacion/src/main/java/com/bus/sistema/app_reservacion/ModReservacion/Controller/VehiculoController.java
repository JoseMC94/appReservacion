package com.bus.sistema.app_reservacion.ModReservacion.Controller;

import com.bus.sistema.app_reservacion.ModReservacion.Domain.Vehiculo;
import com.bus.sistema.app_reservacion.ModReservacion.Services.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Vehiculo")
@Controller
public class VehiculoController {

    @Autowired
    @Qualifier("vehiculoServiceImpl")
    private VehiculoService vehiculoService;

    @GetMapping(value = {"/home", "/", "/index", "/Vehiculo"})
    public ModelAndView index() {
       /* ModelAndView model = new ModelAndView("/modreservacionView/Vehiculo/index");
        return model;*/
        return addVehicula(new Vehiculo());
    }


    @GetMapping("/AddVehiculo")
    public ModelAndView addVehicula(@ModelAttribute("vehiculo") Vehiculo vehiculo) {
        ModelAndView mv = new ModelAndView("/modreservacionView/Vehiculo/index");
        mv.addObject("vehiculoObject", vehiculo);
        mv.addObject("listaVehiculos",vehiculoService.listAllVehiculo());
        return mv;
    }

    @PostMapping("/SaveVehiculo")
    public ModelAndView save(@Valid Vehiculo vehiculo, BindingResult result, String single_cal3) {
        //vehiculo.setNombreCompleto(vehiculo.getNombres() + " " + vehiculo.getPaterno() + " " + vehiculo.getMaterno());
        if (result.hasErrors())
            return addVehicula(vehiculo);
        vehiculoService.save(vehiculo);
        return addVehicula(new Vehiculo());
    }


    @GetMapping("/EditVehiculo/{id}")
    public ModelAndView edit(@PathVariable("id") int id) {
        return addVehicula(vehiculoService.findOneById(id));
    }

    @GetMapping("/DeleteVehiculo/{id}")
    public ModelAndView delete(@PathVariable("id") int id) {
        vehiculoService.removeMenu(id);
        return addVehicula(new Vehiculo());
    }


}

