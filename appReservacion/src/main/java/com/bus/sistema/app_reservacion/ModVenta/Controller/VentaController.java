package com.bus.sistema.app_reservacion.ModVenta.Controller;

import com.bus.sistema.app_reservacion.ModSeguridad.Services.PersonaService;
import com.bus.sistema.app_reservacion.ModVenta.Domain.Venta;
import com.bus.sistema.app_reservacion.ModVenta.Repository.VentaRepository;
import com.bus.sistema.app_reservacion.ModVenta.Services.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.ArrayList;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Venta")
@Controller
public class VentaController {


    @Autowired
    @Qualifier("personaServiceImpl")
    private PersonaService personaService;
    @Autowired
    @Qualifier("ventaService")
    private VentaService ventaService;
    @Autowired
    @Qualifier("VentaRepository")
    private VentaRepository ventaRepository;

    @GetMapping(value = {"/home", "", "/Venta", "/", "/index", "/Mantenimiento"})
    public ModelAndView index() {
        ModelAndView model = new ModelAndView("/ModReservacionView/venta/Clientelist");
        model.addObject("listaPersonas", personaService.listAllPersona());

        System.out.println("\n\nLista: "+ ventaRepository.listarPorUsuarioyFecha(3,4,2019)+"\n\n");
        return model;
    }

    @GetMapping("/AddVenta/{id}")
    public ModelAndView addVenta(@PathVariable("id") int id, @ModelAttribute("venta") Venta venta) {
        ModelAndView model = new ModelAndView("/ModReservacionView/venta/Venta");
        venta.setPersonaId(id);
        venta.setPersonaByPersonaId(personaService.findOneById(id));
        model.addObject("listaVentaPorPersona", ventaRepository.findAllByPersonaId(id));
        model.addObject("ventaObject", venta);
        ArrayList<Venta> listVenta = ventaRepository.findAllByPersonaId(venta.getPersonaId());
        if (!listVenta.isEmpty()) {
            model.addObject("saldo", listVenta.get(listVenta.size() - 1).getMontoSaldo());
        }
        else{
            model.addObject("saldo", 0);

        }

        return model;
    }



    @PostMapping("/SaveVentaDescontar")
    public ModelAndView save(@Valid Venta venta, BindingResult result, String single_cal3) {
        if (result.hasErrors())
            return addVenta(venta.getPersonaId(), venta);
        ArrayList<Venta> listVenta = ventaRepository.findAllByPersonaId(venta.getPersonaId());
        if (!listVenta.isEmpty()) {
            venta.setMontoSaldo(listVenta.get(listVenta.size() - 1).getMontoSaldo().subtract(venta.getMontoDescuento()));
        }
        ventaService.save(venta);
        return addVenta(venta.getPersonaId(), venta);
    }

    @PostMapping("/SaveVentaAgregar")
    public ModelAndView saveAgregar(@Valid Venta venta, BindingResult result, String single_cal3) {
        if (result.hasErrors())
            return addVenta(venta.getPersonaId(), venta);
        // logica guardar
        // si es el primer producto o deuda lista null
        ArrayList<Venta> listVenta = ventaRepository.findAllByPersonaId(venta.getPersonaId());
        System.out.println("\n\n" + listVenta + "\n\n");
        if (!listVenta.isEmpty()) {
            venta.setMontoSaldo(listVenta.get(listVenta.size() - 1).getMontoSaldo().add(venta.getMontoSaldo()));
        }
        venta.setMontoDescuento(BigDecimal.valueOf(0));
        ventaService.save(venta);
        return addVenta(venta.getPersonaId(), venta);
    }
}
