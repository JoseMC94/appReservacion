package com.bus.sistema.app_reservacion.ModReservacion.Domain;

import com.bus.sistema.app_reservacion.ModSeguridad.Domain.Persona;
import com.bus.sistema.app_reservacion.ModSeguridad.Domain.User;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Pasaje {
    private int pasajeId;
    private Date fechaPasaje;
    private BigDecimal abono;
    private BigDecimal saldo;
    private int numeroAsiento;
    private Salida salidaBySalidaId;
    private Persona personaByPersonaId;
    private User userByUsuarioId;
    private int personaId;
    private int usuarioId;
    private int salidaId;

    @Id
    @Column(name = "PasajeId", nullable = false)
    public int getPasajeId() {
        return pasajeId;
    }

    public void setPasajeId(int pasajeId) {
        this.pasajeId = pasajeId;
    }

    @Basic
    @Column(name = "FechaPasaje", nullable = false)
    public Date getFechaPasaje() {
        return fechaPasaje;
    }

    public void setFechaPasaje(Date fechaPasaje) {
        this.fechaPasaje = fechaPasaje;
    }

    @Basic
    @Column(name = "Abono", nullable = false, precision = 2)
    public BigDecimal getAbono() {
        return abono;
    }

    public void setAbono(BigDecimal abono) {
        this.abono = abono;
    }

    @Basic
    @Column(name = "Saldo", nullable = false, precision = 2)
    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    @Basic
    @Column(name = "NumeroAsiento", nullable = false)
    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pasaje pasaje = (Pasaje) o;
        return pasajeId == pasaje.pasajeId &&
                numeroAsiento == pasaje.numeroAsiento &&
                Objects.equals(fechaPasaje, pasaje.fechaPasaje) &&
                Objects.equals(abono, pasaje.abono) &&
                Objects.equals(saldo, pasaje.saldo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pasajeId, fechaPasaje, abono, saldo, numeroAsiento);
    }

    @ManyToOne
    @JoinColumn(name = "SalidaId", referencedColumnName = "SalidaId", nullable = false,insertable=false, updatable=false)
    public Salida getSalidaBySalidaId() {
        return salidaBySalidaId;
    }

    public void setSalidaBySalidaId(Salida salidaBySalidaId) {
        this.salidaBySalidaId = salidaBySalidaId;
    }

    @ManyToOne
    @JoinColumn(name = "PersonaId", referencedColumnName = "PersonaId", nullable = false,insertable=false, updatable=false)
    public Persona getPersonaByPersonaId() {
        return personaByPersonaId;
    }

    public void setPersonaByPersonaId(Persona personaByPersonaId) {
        this.personaByPersonaId = personaByPersonaId;
    }

    @ManyToOne
    @JoinColumn(name = "UsuarioId", referencedColumnName = "UsuarioId", nullable = false,insertable=false, updatable=false)
    public User getUserByUsuarioId() {
        return userByUsuarioId;
    }

    public void setUserByUsuarioId(User userByUsuarioId) {
        this.userByUsuarioId = userByUsuarioId;
    }

    @Basic
    @Column(name = "PersonaId", nullable = false)
    public int getPersonaId() {
        return personaId;
    }

    public void setPersonaId(int personaId) {
        this.personaId = personaId;
    }

    @Basic
    @Column(name = "UsuarioId", nullable = false)
    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Basic
    @Column(name = "SalidaId", nullable = false)
    public int getSalidaId() {
        return salidaId;
    }

    public void setSalidaId(int salidaId) {
        this.salidaId = salidaId;
    }
}
