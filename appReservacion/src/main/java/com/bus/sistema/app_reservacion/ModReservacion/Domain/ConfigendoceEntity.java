package com.bus.sistema.app_reservacion.ModReservacion.Domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "configendoce", schema = "reservacion", catalog = "")
public class ConfigendoceEntity {
    private int configEndoceId;
    private String nombre;
    private BigDecimal movilidad;
    private BigDecimal guia;
    private BigDecimal cantidadPasajero;
    private BigDecimal costoEndoce;

    @Id
    @Column(name = "ConfigEndoceId")
    public int getConfigEndoceId() {
        return configEndoceId;
    }

    public void setConfigEndoceId(int configEndoceId) {
        this.configEndoceId = configEndoceId;
    }

    @Basic
    @Column(name = "Nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "Movilidad")
    public BigDecimal getMovilidad() {
        return movilidad;
    }

    public void setMovilidad(BigDecimal movilidad) {
        this.movilidad = movilidad;
    }

    @Basic
    @Column(name = "Guia")
    public BigDecimal getGuia() {
        return guia;
    }

    public void setGuia(BigDecimal guia) {
        this.guia = guia;
    }

    @Basic
    @Column(name = "CantidadPasajero")
    public BigDecimal getCantidadPasajero() {
        return cantidadPasajero;
    }

    public void setCantidadPasajero(BigDecimal cantidadPasajero) {
        this.cantidadPasajero = cantidadPasajero;
    }

    @Basic
    @Column(name = "CostoEndoce")
    public BigDecimal getCostoEndoce() {
        return costoEndoce;
    }

    public void setCostoEndoce(BigDecimal costoEndoce) {
        this.costoEndoce = costoEndoce;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConfigendoceEntity that = (ConfigendoceEntity) o;
        return configEndoceId == that.configEndoceId &&
                Objects.equals(nombre, that.nombre) &&
                Objects.equals(movilidad, that.movilidad) &&
                Objects.equals(guia, that.guia) &&
                Objects.equals(cantidadPasajero, that.cantidadPasajero) &&
                Objects.equals(costoEndoce, that.costoEndoce);
    }

    @Override
    public int hashCode() {
        return Objects.hash(configEndoceId, nombre, movilidad, guia, cantidadPasajero, costoEndoce);
    }
}
