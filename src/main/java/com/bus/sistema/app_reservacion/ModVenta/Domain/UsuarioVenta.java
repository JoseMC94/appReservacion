package com.bus.sistema.app_reservacion.ModVenta.Domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
public class UsuarioVenta {
    private int usuarioVentaId;
    private String nombreUsuario;
    private BigDecimal valorCobro;
    private Date fechaCobro;
    private String nombrePersonaCobrada;

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "UsuarioVentaId")
    public int getUsuarioVentaId() {
        return usuarioVentaId;
    }

    public void setUsuarioVentaId(int usuarioVentaId) {
        this.usuarioVentaId = usuarioVentaId;
    }

    @Basic
    @Column(name = "NombreUsuario")
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    @Basic
    @Column(name = "ValorCobro")
    public BigDecimal getValorCobro() {
        return valorCobro;
    }

    public void setValorCobro(BigDecimal valorCobro) {
        this.valorCobro = valorCobro;
    }

    @Basic
    @Column(name = "FechaCobro")
    public Date getFechaCobro() {
        return fechaCobro;
    }

    public void setFechaCobro(Date fechaCobro) {
        this.fechaCobro = fechaCobro;
    }

    @Basic
    @Column(name = "NombrePersonaCobrada")
    public String getNombrePersonaCobrada() {
        return nombrePersonaCobrada;
    }

    public void setNombrePersonaCobrada(String nombrePersonaCobrada) {
        this.nombrePersonaCobrada = nombrePersonaCobrada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioVenta that = (UsuarioVenta) o;
        return usuarioVentaId == that.usuarioVentaId &&
                Objects.equals(nombreUsuario, that.nombreUsuario) &&
                Objects.equals(valorCobro, that.valorCobro) &&
                Objects.equals(fechaCobro, that.fechaCobro) &&
                Objects.equals(nombrePersonaCobrada, that.nombrePersonaCobrada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuarioVentaId, nombreUsuario, valorCobro, fechaCobro, nombrePersonaCobrada);
    }
}
