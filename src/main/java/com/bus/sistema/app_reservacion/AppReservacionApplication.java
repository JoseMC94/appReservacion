package com.bus.sistema.app_reservacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


@SpringBootApplication(scanBasePackages = {"com.bus.sistema.app_reservacion"})
public class AppReservacionApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppReservacionApplication.class, args);
       
        System.out.println("\n\nApplication started http://localhost:8080/appReservacion/Home/home ... launching browser now");
        Browse("http://localhost:8090/appReservacion/Home/home");
        System.out.println("\n\nServidor Levantado\n\n");
    }

    public static void Browse(String url) {
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        } else {
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("rundll32 url.dll,FileProtocolHandler " + url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
