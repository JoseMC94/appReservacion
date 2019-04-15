package com.bus.sistema.app_reservacion.ModVenta.Controller;

import com.bus.sistema.app_reservacion.ModSeguridad.Services.PersonaService;
import com.bus.sistema.app_reservacion.ModSeguridad.Util.Util;
import com.bus.sistema.app_reservacion.ModVenta.Domain.Venta;
import com.bus.sistema.app_reservacion.ModVenta.Repository.VentaRepository;
import com.bus.sistema.app_reservacion.ModVenta.Services.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.TimeZone;

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

    @GetMapping(value = {"/home", "", "/Venta", "/", "/index", "/Mantenimiento","/Cobranza"})
    public ModelAndView index() {
        ModelAndView model = new ModelAndView("ModReservacionView/venta/Clientelist");
        model.addObject("listaPersonas", personaService.listAllPersona());

/*
        System.out.println("\n\nLista: " + ventaRepository.listarPorUsuarioyFecha(3, 4, 2019) + "\n\n");
*/
        return model;
    }

    @GetMapping("/AddVenta/{id}")
    public ModelAndView addVenta(@PathVariable("id") int id, @ModelAttribute("venta") Venta venta) {
        DateFormat outFormat = new SimpleDateFormat("dd/MM/yyyy");
        outFormat.setTimeZone(TimeZone.getTimeZone("America/Lima"));
        SimpleDateFormat dateformat3 = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date fechaPeru = null;
        try {
            fechaPeru = dateformat3.parse(outFormat.format(new java.util.Date()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ModelAndView model = new ModelAndView("ModReservacionView/venta/Venta");
        venta.setPersonaId(id);
        venta.setFecha(new Date(fechaPeru.getTime()));
        venta.setPersonaByPersonaId(personaService.findOneById(id));
        model.addObject("listaVentaPorPersona", ventaRepository.findAllByPersonaIdOrderByVentaIdAsc(id));
        model.addObject("ventaObject", venta);
        ArrayList<Venta> listVenta = ventaRepository.findAllByPersonaIdOrderByVentaIdAsc(venta.getPersonaId());
        model.addObject("deudaAgregar", true);
        model.addObject("admin", false);
        if (!listVenta.isEmpty()) {
            model.addObject("saldo", listVenta.get(listVenta.size() - 1).getMontoSaldo());

            // Pruebas
            int finalLista = ventaRepository.findAllByPersonaIdOrderByVentaIdAsc(venta.getPersonaId()).size() - 1;
            System.out.println("\n\n utimo registro fecha" + ventaRepository.findAllByPersonaIdOrderByVentaIdAsc(venta.getPersonaId()).get(finalLista).getFecha() + "\n\n");
            //validacionRegistrosDiarios(ventaRepository.findAllByPersonaIdOrderByVentaIdAsc(venta.getPersonaId()).get(finalLista).getFecha(), venta, model);

            model.addObject("diasDeuda", contarDeudasDiarias(venta));

            if (contarDeudasDiarias(venta) > 15)
                model.addObject("deudaAgregar", false);


        } else
            model.addObject("saldo", 0);
        if (SecurityContextHolder.getContext().getAuthentication().getName().equalsIgnoreCase("admin"))
            model.addObject("admin", true);
        return model;
    }


    @PostMapping("/SaveVentaDescontar")
    public ModelAndView save(@Valid Venta venta, BindingResult result, String single_cal3) {
        DateFormat outFormat = new SimpleDateFormat("dd/MM/yyyy");
        outFormat.setTimeZone(TimeZone.getTimeZone("America/Lima"));
        SimpleDateFormat dateformat3 = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date fechaPeru = null;
        try {
            fechaPeru = dateformat3.parse(outFormat.format(new java.util.Date()));
        } catch (ParseException e) {
            System.out.println("\n\nerror convesion fecha: " + e + "\n\n");
            ;
        }
        System.out.println("\n\n Fecha por defecto" + venta.getFecha() + "\n\n");
        System.out.println("setting fecha");
        LocalDate fech = convertToLocalDateViaInstant(fechaPeru);
        venta.setFecha(Date.valueOf(fech));
        venta.setDescripcion("cobro Diario");
        if (result.hasErrors())
            return addVenta(venta.getPersonaId(), venta);
        ArrayList<Venta> listVenta = ventaRepository.findAllByPersonaIdOrderByVentaIdAsc(venta.getPersonaId());
        if (!listVenta.isEmpty()) {
            venta.setMontoSaldo(listVenta.get(listVenta.size() - 1).getMontoSaldo().subtract(venta.getMontoDescuento()));
        }
        ventaService.save(venta);
        // return addVenta(venta.getPersonaId(), venta);
        return index();
    }

    @PostMapping("/SaveVentaAgregar")
    public ModelAndView saveAgregar(@Valid Venta venta, BindingResult result, String single_cal3) {
        if (result.hasErrors())
            return addVenta(venta.getPersonaId(), venta);
        // logica guardar
        // si es el primer producto o deuda lista null
        ArrayList<Venta> listVenta = ventaRepository.findAllByPersonaIdOrderByVentaIdAsc(venta.getPersonaId());
        System.out.println("\n\n" + listVenta + "\n\n");
        if (!listVenta.isEmpty()) {
            venta.setMontoSaldo(listVenta.get(listVenta.size() - 1).getMontoSaldo().add(venta.getMontoSaldo()));
        }
        venta.setMontoDescuento(BigDecimal.valueOf(0));
        ventaService.save(venta);
        //return addVenta(venta.getPersonaId(), venta);
        return index();
    }

    // Ejecutar al cargar vista venta cobrar
    public void validacionRegistrosDiarios(Date ultimoRegistro, Venta venta, ModelAndView model) {
        if (Util.numeroDiasEntreDosFechas(ultimoRegistro, new Date(System.currentTimeMillis())) != 0) {
            // lista
            if (venta.getPersonaByPersonaId().getGrupo().equalsIgnoreCase("GRUPO A - MERCADO NERY GARCIA")) {
                // cobro Diario
                System.out.println("\n\n Dias pasados desde la ultima fecha " + Util.numeroDiasEntreDosFechas(ultimoRegistro, new Date(System.currentTimeMillis())) + "\n\n");
                ;
                System.out.println("Se hara " + Util.numeroDiasEntreDosFechas(ultimoRegistro, new Date(System.currentTimeMillis())) + "inserts: ");
                Date fechaActual = ultimoRegistro;
                for (int i = 1; i < Util.numeroDiasEntreDosFechas(ultimoRegistro, new Date(System.currentTimeMillis())); i++) {
                    Venta venta1 = new Venta();
                    venta1.setPersonaId(venta.getPersonaId());
                    venta1.setMontoDescuento(BigDecimal.valueOf(0));
                    venta1.setDescripcion("No hubo pago");
                    fechaActual.setTime((long) fechaActual.getTime() + (86400000 * 2));
                    System.out.println(fechaActual);
                    venta1.setFecha(fechaActual);
                    ArrayList<Venta> listVenta = ventaRepository.findAllByPersonaIdOrderByVentaIdAsc(venta.getPersonaId());
                    venta1.setMontoSaldo(listVenta.get(listVenta.size() - 1).getMontoSaldo());
                    venta1.setPersonaByPersonaId(venta.getPersonaByPersonaId());
                    ventaRepository.save(venta1);
                    System.out.println("Se guardo registro");
                }
            }


            if (venta.getPersonaByPersonaId().getGrupo().equalsIgnoreCase("GRUPO B - MERCADO MAGDALENA")) {
                // si no hay 20 dias de cobro Amarillo
            }

        }


    }

    public int contarDeudasDiarias(Venta venta) {
        // 7 dias Verde
        ArrayList<Venta> listVentaDiaria = ventaRepository.findAllByPersonaIdOrderByVentaIdAsc(venta.getPersonaId());
        int verde = 0;
        for (Venta ventasSinCobrar : listVentaDiaria) {
            if (ventasSinCobrar.getMontoDescuento().compareTo(BigDecimal.valueOf(0)) == 0) {
                verde = verde + 1;
            } else {
                verde = 0;
            }
        }

        System.out.println("verdes:" + verde);
        return verde;

    }


    public LocalDate convertToLocalDateViaInstant(java.util.Date dateToConvert) {
        return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
