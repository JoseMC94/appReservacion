package com.bus.sistema.app_reservacion.ModReservacion.Domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Entradadiaria {
    private int entradaId;
    private String denominacion;
    private BigDecimal valor;
    private Date fechaEntrada;

    @Id
    @Column(name = "EntradaId", nullable = false)
    public int getEntradaId() {
        return entradaId;
    }

    public void setEntradaId(int entradaId) {
        this.entradaId = entradaId;
    }

    @Basic
    @Column(name = "Denominacion", nullable = true, length = 255)
    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    @Basic
    @Column(name = "Valor", nullable = true, precision = 2)
    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Basic
    @Column(name = "FechaEntrada", nullable = false)
    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entradadiaria that = (Entradadiaria) o;
        return entradaId == that.entradaId &&
                Objects.equals(denominacion, that.denominacion) &&
                Objects.equals(valor, that.valor) &&
                Objects.equals(fechaEntrada, that.fechaEntrada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(entradaId, denominacion, valor, fechaEntrada);
    }
}
