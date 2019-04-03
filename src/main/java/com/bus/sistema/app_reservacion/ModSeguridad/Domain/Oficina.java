package com.bus.sistema.app_reservacion.ModSeguridad.Domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Oficina {
    private int oficinaId;
    private String denominacion;

    @Id
    @Column(name = "OficinaId", nullable = false)
    public int getOficinaId() {
        return oficinaId;
    }

    public void setOficinaId(int oficinaId) {
        this.oficinaId = oficinaId;
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
        Oficina oficina = (Oficina) o;
        return oficinaId == oficina.oficinaId &&
                Objects.equals(denominacion, oficina.denominacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oficinaId, denominacion);
    }
}
