package com.bus.sistema.app_reservacion.ModSeguridad.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.lang.annotation.*;

@Controller
public class LoginController {

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface Layout {
        String value() default "";
    }


    @Layout(value = "layouts/login")
    @GetMapping("/")
    public String home() {
        return "redirect:/login";
        //return "login";
    }


    @GetMapping("/login")
    @Layout(value = "layouts/login")
    public ModelAndView showLoginForm(ModelAndView model,
                                @RequestParam(name = "error", required = false) String error,
                                @RequestParam(name = "logout", required = false) String logout) {
        model.addObject("error", error);
        model.addObject("logout", logout);
        //return  ViewConstant.LOGIN;
        return model;
    }

    @GetMapping({"/loginsucces"})
    public String loginCheck() {
        return "redirect:/Home/home";
    }

}

