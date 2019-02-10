package com.bus.sistema.app_reservacion.ModReservacion.Domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Salidadiaria {
    private int salidaId;
    private String denominacion;
    private BigDecimal valor;
    private Date fechaSalida;

    @Id
    @Column(name = "SalidaId", nullable = false)
    public int getSalidaId() {
        return salidaId;
    }

    public void setSalidaId(int salidaId) {
        this.salidaId = salidaId;
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
    @Column(name = "FechaSalida", nullable = false)
    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salidadiaria that = (Salidadiaria) o;
        return salidaId == that.salidaId &&
                Objects.equals(denominacion, that.denominacion) &&
                Objects.equals(valor, that.valor) &&
                Objects.equals(fechaSalida, that.fechaSalida);
    }

    @Override
    public int hashCode() {
        return Objects.hash(salidaId, denominacion, valor, fechaSalida);
    }
}
