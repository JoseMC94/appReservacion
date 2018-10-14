package com.bus.sistema.app_reservacion.ModSeguridad.Domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Cargo {
    private int cargoId;
    private String denominacion;

    @Id
    @Column(name = "CargoId", nullable = false)
    public int getCargoId() {
        return cargoId;
    }

    public void setCargoId(int cargoId) {
        this.cargoId = cargoId;
    }

    @Basic
    @Column(name = "Denominacion", nullable = false, length = 255)
    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cargo cargo = (Cargo) o;
        return cargoId == cargo.cargoId &&
                Objects.equals(denominacion, cargo.denominacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cargoId, denominacion);
    }
}
