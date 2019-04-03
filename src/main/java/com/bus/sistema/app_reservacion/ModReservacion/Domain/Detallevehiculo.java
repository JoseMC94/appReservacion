package com.bus.sistema.app_reservacion.ModReservacion.Domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Detallevehiculo {
    private int detalleVehiculoId;
    private int numeroAsiento;
    private String denominacion;
    private Integer vehiculoId;
    private Vehiculo vehiculoByVehiculoId;

    @Id
    @Column(name = "DetalleVehiculoId", nullable = false)
    public int getDetalleVehiculoId() {
        return detalleVehiculoId;
    }

    public void setDetalleVehiculoId(int detalleVehiculoId) {
        this.detalleVehiculoId = detalleVehiculoId;
    }

    @Basic
    @Column(name = "NumeroAsiento", nullable = false)
    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
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
    @Column(name = "VehiculoId", nullable = true)
    public Integer getVehiculoId() {
        return vehiculoId;
    }

    public void setVehiculoId(Integer vehiculoId) {
        this.vehiculoId = vehiculoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Detallevehiculo that = (Detallevehiculo) o;
        return detalleVehiculoId == that.detalleVehiculoId &&
                numeroAsiento == that.numeroAsiento &&
                Objects.equals(denominacion, that.denominacion) &&
                Objects.equals(vehiculoId, that.vehiculoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(detalleVehiculoId, numeroAsiento, denominacion, vehiculoId);
    }

    @ManyToOne
    @JoinColumn(name = "VehiculoId", referencedColumnName = "VehiculoId", nullable = false, insertable = false, updatable = false)
    public Vehiculo getVehiculoByVehiculoId() {
        return vehiculoByVehiculoId;
    }

    public void setVehiculoByVehiculoId(Vehiculo vehiculoByVehiculoId) {
        this.vehiculoByVehiculoId = vehiculoByVehiculoId;
    }
}
