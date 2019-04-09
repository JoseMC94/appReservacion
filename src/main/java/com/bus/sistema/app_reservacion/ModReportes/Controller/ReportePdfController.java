package com.bus.sistema.app_reservacion.ModReportes.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

import java.util.HashMap;
import java.util.Map;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/ReportePdf")
@Controller
public class ReportePdfController {


    @Autowired
    private ApplicationContext appContext;



    @GetMapping( "/pdf")
    public ModelAndView report() {

        JasperReportsPdfView view = new JasperReportsPdfView();
        view.setUrl("classpath:Reportes/report1.jrxml");
        view.setApplicationContext(appContext);
        Map<String, Object> params = new HashMap<>();
        //params.put("datasource", InicidenciaService.listAllIncidencia());
        return new ModelAndView(view, params);
    }

}
