package com.bus.sistema.app_reservacion.ModSeguridad.Domain;

import com.bus.sistema.app_reservacion.ModReservacion.Domain.Pasaje;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class User {
    private int usuarioId;
    private Integer personaId;
    private String username;
    private String password;
    private boolean activo;
    private boolean indCambio;
    private Integer cargoId;
    private Integer oficinaId;
    private Persona personaByPersonaId;
    private Set<UserRole> userRolesByUsuarioId = new HashSet<>();
    private Cargo cargoByCargoId;
    private Oficina oficinaByOficinaId;
    private Collection<Pasaje> pasajesByUsuarioId;

    public User(int usuarioId){
         if (usuarioId==0)this.personaByPersonaId=new Persona();
    }

    public User(String username, String pass, boolean enabled) {
        this.username = username;
        this.password = pass;
        this.activo = enabled;
    }
    public User(){

    }

    public User(String username, String pass, boolean enabled, Set<UserRole> userRole) {
        this.username = username;
        this.password = pass;
        this.activo = enabled;
        this.userRolesByUsuarioId = userRole;
    }

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
    @Column(name = "username", nullable = false, length = 60)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 60)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        User user = (User) o;
        return usuarioId == user.usuarioId &&
                activo == user.activo &&
                indCambio == user.indCambio &&
                Objects.equals(personaId, user.personaId) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(cargoId, user.cargoId) &&
                Objects.equals(oficinaId, user.oficinaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuarioId, personaId, username, password, activo, indCambio, cargoId, oficinaId);
    }

    @ManyToOne(fetch =  FetchType.EAGER)
    @JoinColumn(name = "PersonaId", referencedColumnName = "PersonaId",insertable=false, updatable=false)
    public Persona getPersonaByPersonaId() {
        return personaByPersonaId;
    }

    public void setPersonaByPersonaId(Persona personaByPersonaId) {
        this.personaByPersonaId = personaByPersonaId;
    }

    @OneToMany(fetch =  FetchType.EAGER,mappedBy = "userByUsuarioId")
    public Set<UserRole> getUserRolesByUsuarioId() {
        return userRolesByUsuarioId;
    }

    public void setUserRolesByUsuarioId(Set<UserRole> userRolesByUsuarioId) {
        this.userRolesByUsuarioId = userRolesByUsuarioId;
    }

    @ManyToOne
    @JoinColumn(name = "CargoId", referencedColumnName = "CargoId",insertable=false, updatable=false)
    public Cargo getCargoByCargoId() {
        return cargoByCargoId;
    }

    public void setCargoByCargoId(Cargo cargoByCargoId) {
        this.cargoByCargoId = cargoByCargoId;
    }

    @ManyToOne
    @JoinColumn(name = "OficinaId", referencedColumnName = "OficinaId",insertable=false, updatable=false)
    public Oficina getOficinaByOficinaId() {
        return oficinaByOficinaId;
    }

    public void setOficinaByOficinaId(Oficina oficinaByOficinaId) {
        this.oficinaByOficinaId = oficinaByOficinaId;
    }

    @OneToMany(mappedBy = "userByUsuarioId")
    public Collection<Pasaje> getPasajesByUsuarioId() {
        return pasajesByUsuarioId;
    }

    public void setPasajesByUsuarioId(Collection<Pasaje> pasajesByUsuarioId) {
        this.pasajesByUsuarioId = pasajesByUsuarioId;
    }

}
