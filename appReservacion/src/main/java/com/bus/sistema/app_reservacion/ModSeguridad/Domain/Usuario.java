package com.bus.sistema.app_reservacion.ModSeguridad.Domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Usuario {
    private int usuarioId;
    private Integer personaId;
    private String nombre;
    private String clave;
    private boolean activo;
    private boolean indCambio;
    private Integer cargoId;
    private Integer oficinaId;

    @Id
    @Column(name = "UsuarioId", nullable = false)
    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Basic
    @Column(name = "PersonaId", nullable = true)
    public Integer getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Integer personaId) {
        this.personaId = personaId;
    }

    @Basic
    @Column(name = "Nombre", nullable = false, length = 60)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "Clave", nullable = false, length = 60)
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Basic
    @Column(name = "Activo", nullable = false)
    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Basic
    @Column(name = "IndCambio", nullable = false)
    public boolean isIndCambio() {
        return indCambio;
    }

    public void setIndCambio(boolean indCambio) {
        this.indCambio = indCambio;
    }

    @Basic
    @Column(name = "CargoId", nullable = true)
    public Integer getCargoId() {
        return cargoId;
    }

    public void setCargoId(Integer cargoId) {
        this.cargoId = cargoId;
    }

    @Basic
    @Column(name = "OficinaId", nullable = true)
    public Integer getOficinaId() {
        return oficinaId;
    }

    public void setOficinaId(Integer oficinaId) {
        this.oficinaId = oficinaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return usuarioId == usuario.usuarioId &&
                activo == usuario.activo &&
                indCambio == usuario.indCambio &&
                Objects.equals(personaId, usuario.personaId) &&
                Objects.equals(nombre, usuario.nombre) &&
                Objects.equals(clave, usuario.clave) &&
                Objects.equals(cargoId, usuario.cargoId) &&
                Objects.equals(oficinaId, usuario.oficinaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuarioId, personaId, nombre, clave, activo, indCambio, cargoId, oficinaId);
    }
}
