package com.bus.sistema.app_reservacion.ModReservacion.Domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Endoce {
    private int endoceId;
    private String denominacion;
    private String descripcion;
    private Collection<Endocedetalle> endocedetallesByEndoceId;

    @Id
    @Column(name = "EndoceId", nullable = false)
    public int getEndoceId() {
        return endoceId;
    }

    public void setEndoceId(int endoceId) {
        this.endoceId = endoceId;
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
    @Column(name = "Descripcion", nullable = false, length = 255)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endoce endoce = (Endoce) o;
        return endoceId == endoce.endoceId &&
                Objects.equals(denominacion, endoce.denominacion) &&
                Objects.equals(descripcion, endoce.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(endoceId, denominacion, descripcion);
    }

    @OneToMany(mappedBy = "endoceByEndoceId")
    public Collection<Endocedetalle> getEndocedetallesByEndoceId() {
        return endocedetallesByEndoceId;
    }

    public void setEndocedetallesByEndoceId(Collection<Endocedetalle> endocedetallesByEndoceId) {
        this.endocedetallesByEndoceId = endocedetallesByEndoceId;
    }
}
