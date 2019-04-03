package com.bus.sistema.app_reservacion.ModVenta.Controller;

import com.bus.sistema.app_reservacion.ModVenta.Domain.Producto;
import com.bus.sistema.app_reservacion.ModVenta.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Producto")
@Controller
public class ProductoController {

    @Autowired
    @Qualifier("productoRepository")
    private ProductoRepository productoRepository;

    @GetMapping(value = {"/home", "/Producto","", "/", "/index", "/Mantenimiento"})
    public ModelAndView index() {
        ModelAndView model = new ModelAndView("/ModReservacionView/venta/Producto");
        model.addObject("listaProductos", productoRepository.findAll());
        return model;
    }

    @GetMapping("/AddProducto")
    public ModelAndView addProducto( @ModelAttribute("venta") Producto producto) {
        ModelAndView model = new ModelAndView("/ModReservacionView/venta/productoAdd");
        model.addObject("ventaObject", producto);
        return model;
    }

    @PostMapping("/SaveProducto")
    public ModelAndView save(@Valid Producto producto, BindingResult result, String single_cal3) {
        if (result.hasErrors()){
            System.out.println("\n\n");
            System.out.println(result.getAllErrors());
            return addProducto(producto);
        }
        productoRepository.save(producto);
        return index();
    }

    @GetMapping("/EditProducto/{id}")
    public ModelAndView edit(@PathVariable("id") int id) {
        return addProducto(productoRepository.findOne(id));
    }


}
