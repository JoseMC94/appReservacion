package com.bus.sistema.app_reservacion.ModReservacion.Domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Salida {
    private int salidaId;
    private String denominacion;
    private Date fechaSalida;
    private Date fechaLlegada;
    private Integer vehiculoId;
    private BigDecimal precio;
    private String chofer;
    private Collection<Pasaje> pasajesBySalidaId;
    private Vehiculo vehiculoByVehiculoId;

    @Id
    @Column(name = "SalidaId", nullable = false)
    public int getSalidaId() {
        return salidaId;
    }

    public void setSalidaId(int salidaId) {
        this.salidaId = salidaId;
    }

    @Basic
    @Column(name = "Denominacion", nullable = false, length = 255)
    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    @Basic
    @Column(name = "FechaSalida", nullable = false)
    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    @Basic
    @Column(name = "FechaLlegada", nullable = false)
    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    @Basic
    @Column(name = "VehiculoId", nullable = true)
    public Integer getVehiculoId() {
        return vehiculoId;
    }

    public void setVehiculoId(Integer vehiculoId) {
        this.vehiculoId = vehiculoId;
    }

    @Basic
    @Column(name = "Precio", nullable = true, precision = 2)
    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salida salida = (Salida) o;
        return salidaId == salida.salidaId &&
                Objects.equals(denominacion, salida.denominacion) &&
                Objects.equals(fechaSalida, salida.fechaSalida) &&
                Objects.equals(fechaLlegada, salida.fechaLlegada) &&
                Objects.equals(vehiculoId, salida.vehiculoId) &&
                Objects.equals(precio, salida.precio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(salidaId, denominacion, fechaSalida, fechaLlegada, vehiculoId, precio);
    }

    @Basic
    @Column(name = "Chofer", nullable = true, length = 120)
    public String getChofer() {
        return chofer;
    }

    public void setChofer(String chofer) {
        this.chofer = chofer;
    }

    @OneToMany(mappedBy = "salidaBySalidaId")
    public Collection<Pasaje> getPasajesBySalidaId() {
        return pasajesBySalidaId;
    }

    public void setPasajesBySalidaId(Collection<Pasaje> pasajesBySalidaId) {
        this.pasajesBySalidaId = pasajesBySalidaId;
    }

    @ManyToOne
    @JoinColumn(name = "VehiculoId", referencedColumnName = "VehiculoId", nullable = false,insertable=false, updatable=false)
    public Vehiculo getVehiculoByVehiculoId() {
        return vehiculoByVehiculoId;
    }

    public void setVehiculoByVehiculoId(Vehiculo vehiculoByVehiculoId) {
        this.vehiculoByVehiculoId = vehiculoByVehiculoId;
    }
}
