package com.bus.sistema.app_reservacion.ModReservacion.Controller;

import com.bus.sistema.app_reservacion.ModReservacion.Domain.Entradadiaria;
import com.bus.sistema.app_reservacion.ModReservacion.Domain.Salidadiaria;
import com.bus.sistema.app_reservacion.ModReservacion.Services.EntradaDiariaService;
import com.bus.sistema.app_reservacion.ModReservacion.Services.SalidaDiariaService;
import com.bus.sistema.app_reservacion.ModSeguridad.Util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Date;

/**
 * Controladores de la Caja Chica
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/CajaChica")
@Controller
public class CajaChicaController {
    /**
     * Inyecciond de Dependencias (IoD) del servicio de entrada se inyecta con el servicio implementaado
     */
    @Autowired
    @Qualifier("entradaDiariaServiceImpl")
    private EntradaDiariaService entradaDiariaService;

    @Autowired
    @Qualifier("salidaDiariaServiceImpl")
    private SalidaDiariaService salidaDiariaService;

    @GetMapping(value = {"/home", "/", "/index", "/Mantenimiento", "/Diario"})
    public ModelAndView index() {
        return addEntradaSalida(new Entradadiaria(), new Salidadiaria());
    }


    /**
     * Metodo Para mostrar una vista  "/modreservacionView/CajaChica/CajaChica"
     * @param entradadiaria objeto de entrada Diaria
     * @param salidadiaria objeto de salida Diaria
     * @return retorn una vista con los objetos mencionados
     */
    @GetMapping("/AddEntradaSalida")
    public ModelAndView addEntradaSalida(@ModelAttribute("entradadiaria") Entradadiaria entradadiaria, @ModelAttribute("salidadiaria") Salidadiaria salidadiaria) {
        ModelAndView mv = new ModelAndView("/modreservacionView/CajaChica/CajaChica");

        mv.addObject("entradadiariaObject", entradadiaria);
        mv.addObject("listaEntradasDiarias", entradaDiariaService.listAllEntradadiariasXFecha(new java.sql.Date(new Date().getTime())));
        mv.addObject("totalEntrada", Util.totalEntrada(entradaDiariaService.listAllEntradadiariasXFecha(new java.sql.Date(new Date().getTime()))));

        mv.addObject("listaSalidas", salidaDiariaService.listAllSalidaDiariasXFecha(new java.sql.Date(new Date().getTime())));
        mv.addObject("salidadiariaObject", salidadiaria);
        mv.addObject("totalSalida", Util.totalSalida(salidaDiariaService.listAllSalidaDiariasXFecha(new java.sql.Date(new Date().getTime()))));

        mv.addObject("total", Util.totalEntrada(entradaDiariaService.listAllEntradadiariasXFecha(new java.sql.Date(new Date().getTime()))) -
                Util.totalSalida(salidaDiariaService.listAllSalidaDiariasXFecha(new java.sql.Date(new Date().getTime()))));

        return mv;
    }


    @PostMapping("/SaveEntrada")
    public ModelAndView save(@Valid Entradadiaria entradadiaria, BindingResult result, String single_cal3) {
        entradadiaria.setFechaEntrada(new java.sql.Date(new Date().getTime()));
        if (result.hasErrors())
            return addEntradaSalida(new Entradadiaria(), new Salidadiaria());
        entradaDiariaService.save(entradadiaria);
        return index();
    }


    @PostMapping("/SaveSalida")
    public ModelAndView saveSalida(@Valid Salidadiaria salidadiaria, BindingResult result, String single_cal3) {
        salidadiaria.setFechaSalida(new java.sql.Date(new Date().getTime()));
        if (result.hasErrors())
            return addEntradaSalida(new Entradadiaria(), new Salidadiaria());
        salidaDiariaService.save(salidadiaria);
        return index();
    }

    @GetMapping("/DeleteSalidaDiaria/{id}")
    public ModelAndView delete(@PathVariable("id") int id) {
        salidaDiariaService.removeSalidaDiaria(id);
        return addEntradaSalida(new Entradadiaria(), new Salidadiaria());
    }

    @GetMapping("/DeleteEntradaDiaria/{id}")
    public ModelAndView deleteEntradaDiaria(@PathVariable("id") int id) {
        entradaDiariaService.removeEntradaDiaria(id);
        return addEntradaSalida(new Entradadiaria(), new Salidadiaria());
    }


    @GetMapping("/AddEntradaSalidaFecha")
    public ModelAndView addEntradaSalidaFecha(@ModelAttribute("entradadiaria") Entradadiaria entradadiaria, @ModelAttribute("salidadiaria") Salidadiaria salidadiaria, @PathVariable("date") java.sql.Date date) {
        ModelAndView mv = new ModelAndView("/modreservacionView/CajaChica/CajaChica");

        mv.addObject("entradadiariaObject", entradadiaria);
        mv.addObject("listaEntradasDiarias", entradaDiariaService.listAllEntradadiariasXFecha(date));
        mv.addObject("totalEntrada", Util.totalEntrada(entradaDiariaService.listAllEntradadiariasXFecha(date)));

        mv.addObject("listaSalidas", salidaDiariaService.listAllSalidaDiariasXFecha(date));
        mv.addObject("salidadiariaObject", salidadiaria);
        mv.addObject("totalSalida", Util.totalSalida(salidaDiariaService.listAllSalidaDiariasXFecha(date)));

        mv.addObject("total", Util.totalEntrada(entradaDiariaService.listAllEntradadiariasXFecha(date)) -
                Util.totalSalida(salidaDiariaService.listAllSalidaDiariasXFecha(date)));

        return mv;
    }

    @GetMapping("/VistaFecha/{fecha}")
    public ModelAndView cargarVistaFecha(@PathVariable("fecha") java.sql.Date fecha) {
        System.out.println("\n\n" + fecha + "\n");
        return addEntradaSalidaFecha(new Entradadiaria(), new Salidadiaria(), fecha);
        //return addEntradaSalidaFecha(new Entradadiaria(), new Salidadiaria(),fecha);
    }

}
