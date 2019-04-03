package com.bus.sistema.app_reservacion.ModReservacion.Domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Vehiculo {
    private int vehiculoId;
    private String denominacion;
    private int capacidad;
    private String placa;
    private String marca;
    private Collection<Salida> salidasByVehiculoId;
    private Collection<Detallevehiculo> detallevehiculosByVehiculoId;

    @Id
    @Column(name = "VehiculoId", nullable = false)
    public int getVehiculoId() {
        return vehiculoId;
    }

    public void setVehiculoId(int vehiculoId) {
        this.vehiculoId = vehiculoId;
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
    @Column(name = "Capacidad", nullable = false)
    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Basic
    @Column(name = "placa", nullable = false, length = 255)
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Basic
    @Column(name = "Marca", nullable = false, length = 255)
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return vehiculoId == vehiculo.vehiculoId &&
                capacidad == vehiculo.capacidad &&
                Objects.equals(denominacion, vehiculo.denominacion) &&
                Objects.equals(placa, vehiculo.placa) &&
                Objects.equals(marca, vehiculo.marca);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehiculoId, denominacion, capacidad, placa, marca);
    }

    @OneToMany(mappedBy = "vehiculoByVehiculoId")
    public Collection<Salida> getSalidasByVehiculoId() {
        return salidasByVehiculoId;
    }

    public void setSalidasByVehiculoId(Collection<Salida> salidasByVehiculoId) {
        this.salidasByVehiculoId = salidasByVehiculoId;
    }

    @OneToMany(mappedBy = "vehiculoByVehiculoId")
    public Collection<Detallevehiculo> getDetallevehiculosByVehiculoId() {
        return detallevehiculosByVehiculoId;
    }

    public void setDetallevehiculosByVehiculoId(Collection<Detallevehiculo> detallevehiculosByVehiculoId) {
        this.detallevehiculosByVehiculoId = detallevehiculosByVehiculoId;
    }
}
