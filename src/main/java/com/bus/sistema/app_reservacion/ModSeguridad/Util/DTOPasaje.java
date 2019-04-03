package com.bus.sistema.app_reservacion.ModSeguridad.Util;

import java.sql.Date;

public class DTOPasaje {
    private int pasajeId = 0;
    private int usuarioId;
    private String salidaId;
    private int personaId;

    private Date fechaSalida;
    private String usuario;
    private String Dni;
    private String nombre;
    private String apellido;
    private int numeroAsiento;
    private double precio;
    private double abono;
    private double saldo;
    private String endoce;
    private String nombreHotel;
    private Date fechaIngresoHotel;
    private Date fechaSalidaHotel;
    private double precioHotel;


    public int getPersonaId() {
        return personaId;
    }

    public void setPersonaId(int personaId) {
        this.personaId = personaId;
    }

    public DTOPasaje(Date fechaSalida, String usuario, String dni, String nombre, String apellido, int numeroAsiento, double precio, double abono, double saldo, String endoce, String nombreHotel, Date fechaIngresoHotel, Date fechaSalidaHotel, double precioHotel, int usuarioId, String salidaId, int personaId) {
        this.setPasajeId(0);
        this.setFechaSalida(fechaSalida);
        this.setUsuario(usuario);
        setDni(dni);
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setNumeroAsiento(numeroAsiento);
        this.setPrecio(precio);
        this.setAbono(abono);
        this.setSaldo(saldo);
        this.setEndoce(endoce);
        this.setNombreHotel(nombreHotel);
        this.setFechaIngresoHotel(fechaIngresoHotel);
        this.setFechaSalidaHotel(fechaSalidaHotel);
        this.setPrecioHotel(precioHotel);
        this.setUsuarioId(usuarioId);
        this.setSalidaId(salidaId);
        this.personaId = personaId;

    }

    public DTOPasaje() {
    }



    public int getPasajeId() {
        return pasajeId;
    }

    public void setPasajeId(int pasajeId) {
        this.pasajeId = pasajeId;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String dni) {
        Dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getAbono() {
        return abono;
    }

    public void setAbono(double abono) {
        this.abono = abono;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getEndoce() {
        return endoce;
    }

    public void setEndoce(String endoce) {
        this.endoce = endoce;
    }

    public String getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    public Date getFechaIngresoHotel() {
        return fechaIngresoHotel;
    }

    public void setFechaIngresoHotel(Date fechaIngresoHotel) {
        this.fechaIngresoHotel = fechaIngresoHotel;
    }

    public Date getFechaSalidaHotel() {
        return fechaSalidaHotel;
    }

    public void setFechaSalidaHotel(Date fechaSalidaHotel) {
        this.fechaSalidaHotel = fechaSalidaHotel;
    }

    public double getPrecioHotel() {
        return precioHotel;
    }

    public void setPrecioHotel(double precioHotel) {
        this.precioHotel = precioHotel;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getSalidaId() {
        return salidaId;
    }

    public void setSalidaId(String salidaId) {
        this.salidaId = salidaId;
    }

    @Override
    public String toString() {
        return "\npasajeId" + pasajeId
                + "\n fechaSalida :" + fechaSalida
                + "\nusuario :" + usuario
                + "\nDni :" + Dni
                + "\nnombre :" + nombre
                + "\napellido :" + apellido
                + "\nnumeroAsiento :" + numeroAsiento
                + "\nprecio: " + precio
                + "\nabono: " + abono
                + "\nsaldo:" + saldo
                + "\nendoce:" + endoce
                + "\nnombreHotel :" + nombreHotel
                + "\nfechaIngresoHotel:" + fechaIngresoHotel
                + "\nfechaSalidaHotel :" + fechaSalidaHotel
                + "\nprecioHotel :" + precioHotel
                + "\nusuarioId :" + usuarioId
                + "\npersonaId :" + personaId
                + "\nsalidaId :" + salidaId + "\n";


    }
}
