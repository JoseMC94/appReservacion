package com.bus.sistema.app_reservacion.ModSeguridad.Util;

import com.bus.sistema.app_reservacion.ModReservacion.Domain.Entradadiaria;
import com.bus.sistema.app_reservacion.ModReservacion.Domain.Pasaje;
import com.bus.sistema.app_reservacion.ModReservacion.Domain.Salidadiaria;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;


public class Util {

    public static Pasaje convertPasaje(DTOPasaje dtoPasaje) {
        Pasaje pasaje = new Pasaje();

        /**
         *     private int pasajeId;
         *     private Date fechaPasaje;
         *     private BigDecimal abono;
         *     private BigDecimal saldo;
         *     private int numeroAsiento;
         *     private Salida salida;
         *     persona
         *     usuario
         */

        pasaje.setPasajeId(0);
        pasaje.setFechaPasaje(dtoPasaje.getFechaSalida());
        pasaje.setAbono(BigDecimal.valueOf(dtoPasaje.getAbono()));
        pasaje.setSaldo(BigDecimal.valueOf(dtoPasaje.getSaldo()));
        pasaje.setNumeroAsiento(dtoPasaje.getNumeroAsiento());
        pasaje.setSalidaId(Integer.parseInt(dtoPasaje.getSalidaId()));
        pasaje.setPersonaId(dtoPasaje.getPersonaId());
        pasaje.setUsuarioId(dtoPasaje.getUsuarioId());
        return pasaje;
    }

    public static double totalEntrada(List<Entradadiaria> list) {
        double total = 0;
        for (Entradadiaria var : list) {
            total = total + Double.parseDouble(var.getValor() + "");
        }
        return total;
    }

    public static double totalSalida(List<Salidadiaria> list) {
        double total = 0;
        for (Salidadiaria var : list) {
            total = total + Double.parseDouble(var.getValor() + "");
        }
        return total;
    }

    /**
     * Encripyat contraseña Bcry
     */
    public static String encriptarContrasena(String pass) {
        return new BCryptPasswordEncoder().encode(pass);
    }

    public Stream<String> streamOf(List<String> list) {
        return list == null || list.isEmpty () ? Stream.empty() : list.stream();
    }

    public static int numeroDiasEntreDosFechas(Date fecha1, Date fecha2) {
        long startTime = fecha1.getTime();
        long endTime = fecha2.getTime();
        long diffTime = endTime - startTime;
        return (int) TimeUnit.DAYS.convert(diffTime, TimeUnit.MILLISECONDS);
    }

    public static void main(String[] args) {

        System.out.println(encriptarContrasena("vendedor@"));

        /*for (int i = 0; i < 5; i++)
            System.out.println(encriptarContrasena("admin"));

        Stream<String> streamEmpty = Stream.empty();

        System.out.println(numeroDiasEntreDosFechas(new Date(System.currentTimeMillis()), Date.valueOf("2019-04-10")));
*/
    }
}
