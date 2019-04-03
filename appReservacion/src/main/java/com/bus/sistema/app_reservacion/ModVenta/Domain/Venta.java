package com.bus.sistema.app_reservacion.ModVenta.Domain;

import com.bus.sistema.app_reservacion.ModSeguridad.Domain.Persona;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Venta {
    private int ventaId;
    private Date fecha;
    private BigDecimal montoDescuento;
    private BigDecimal montoSaldo;
    private String descripcion;
    private int personaId;
    Persona personaByPersonaId;

    @Id
    @Column(name = "VentaId")
    public int getVentaId() {
        return ventaId;
    }

    public void setVentaId(int ventaId) {
        this.ventaId = ventaId;
    }

    @Basic
    @Column(name = "Fecha")
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Basic
    @Column(name = "MontoDescuento")
    public BigDecimal getMontoDescuento() {
        return montoDescuento;
    }

    public void setMontoDescuento(BigDecimal montoDescuento) {
        this.montoDescuento = montoDescuento;
    }

    @Basic
    @Column(name = "MontoSaldo")
    public BigDecimal getMontoSaldo() {
        return montoSaldo;
    }

    public void setMontoSaldo(BigDecimal montoSaldo) {
        this.montoSaldo = montoSaldo;
    }

    @Basic
    @Column(name = "Descripcion")
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
        Venta venta = (Venta) o;
        return ventaId == venta.ventaId &&
                Objects.equals(fecha, venta.fecha) &&
                Objects.equals(montoDescuento, venta.montoDescuento) &&
                Objects.equals(montoSaldo, venta.montoSaldo) &&
                Objects.equals(descripcion, venta.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ventaId, fecha, montoDescuento, montoSaldo, descripcion);
    }

    @Basic
    @Column(name = "PersonaId")
    public int getPersonaId() {
        return personaId;
    }

    public void setPersonaId(int personaId) {
        this.personaId = personaId;
    }
    @ManyToOne
    @JoinColumn(name = "PersonaId", referencedColumnName = "PersonaId", nullable = false,insertable = false,updatable = false)
    public Persona getPersonaByPersonaId() {
        return personaByPersonaId;
    }

    public void setPersonaByPersonaId(Persona personaByPersonaId) {
        this.personaByPersonaId = personaByPersonaId;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "ventaId=" + ventaId +
                ", fecha=" + fecha +
                ", montoDescuento=" + montoDescuento +
                ", montoSaldo=" + montoSaldo +
                ", descripcion='" + descripcion + '\'' +
                ", personaId=" + personaId +
                ", personaByPersonaId=" + personaByPersonaId +
                '}';
    }
}
