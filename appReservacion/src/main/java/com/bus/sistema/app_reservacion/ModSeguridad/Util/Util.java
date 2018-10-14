package com.bus.sistema.app_reservacion.ModSeguridad.Util;

import com.bus.sistema.app_reservacion.ModSeguridad.Domain.Menu;
import com.bus.sistema.app_reservacion.ModSeguridad.Domain.User;
import com.bus.sistema.app_reservacion.ModSeguridad.Repository.UserRepository;
import com.bus.sistema.app_reservacion.ModSeguridad.Services.MenuService;
import com.bus.sistema.app_reservacion.ModSeguridad.Services.UserServiceE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Util {

    @Autowired
    @Qualifier("userRepository")
    private static com.bus.sistema.app_reservacion.ModSeguridad.Repository.UserRepository UserRepository;

    @Autowired
    @Qualifier("userServiceEImpl")
    private static UserServiceE userServiceE;

    @Autowired
    @Qualifier("menuServiceEImpl")
    private static MenuService menuServiceImpl;

    public static void main(String[] args) {



        // @PreAuthorize("hasRole('ROLE_USER')")


       /* BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
        System.out.println(pe.encode("user"));
        System.out.println(pe.encode("admin"));*/

        User u = new User();
        u.setUsuarioId(1);
        //System.out.println("\n\n\n" + userServiceE.findOne(1) + "\n\n\n");

        for (Menu menu : menuServiceImpl.listAllMenu()) {
            System.out.println(menu.getDenominacion());
        }



    }
}
