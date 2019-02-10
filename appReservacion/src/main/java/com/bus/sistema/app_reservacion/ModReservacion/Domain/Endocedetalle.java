package com.bus.sistema.app_reservacion.ModReservacion.Domain;

import com.bus.sistema.app_reservacion.ModSeguridad.Domain.Persona;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Endocedetalle {
    private int endoceDetalleId;
    private int endoceId;
    private int personaId;
    private String estado;
    private Date fechaPasaje;
    private Endoce endoceByEndoceId;

    @Id
    @Column(name = "EndoceDetalleId", nullable = false)
    public int getEndoceDetalleId() {
        return endoceDetalleId;
    }

    public void setEndoceDetalleId(int endoceDetalleId) {
        this.endoceDetalleId = endoceDetalleId;
    }

    @Basic
    @Column(name = "EndoceId", nullable = false)
    public int getEndoceId() {
        return endoceId;
    }

    public void setEndoceId(int endoceId) {
        this.endoceId = endoceId;
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
    @Column(name = "Estado", nullable = false, length = 255)
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Basic
    @Column(name = "FechaPasaje", nullable = false)
    public Date getFechaPasaje() {
        return fechaPasaje;
    }

    public void setFechaPasaje(Date fechaPasaje) {
        this.fechaPasaje = fechaPasaje;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endocedetalle that = (Endocedetalle) o;
        return endoceDetalleId == that.endoceDetalleId &&
                endoceId == that.endoceId &&
                personaId == that.personaId &&
                Objects.equals(estado, that.estado) &&
                Objects.equals(fechaPasaje, that.fechaPasaje);
    }

    @Override
    public int hashCode() {
        return Objects.hash(endoceDetalleId, endoceId, personaId, estado, fechaPasaje);
    }

    @ManyToOne
    @JoinColumn(name = "EndoceId", referencedColumnName = "EndoceId", nullable = false,insertable=false, updatable=false)
    public Endoce getEndoceByEndoceId() {
        return endoceByEndoceId;
    }

    public void setEndoceByEndoceId(Endoce endoceByEndoceId) {
        this.endoceByEndoceId = endoceByEndoceId;
    }

    private Persona personaByPersonaId;

    @ManyToOne
    @JoinColumn(name = "PersonaId", referencedColumnName = "PersonaId", nullable = false,insertable=false, updatable=false)
    public Persona getPersonaByPersonaId() {
        return personaByPersonaId;
    }

    public void setPersonaByPersonaId(Persona personaByPersonaId) {
        this.personaByPersonaId = personaByPersonaId;
    }
}
