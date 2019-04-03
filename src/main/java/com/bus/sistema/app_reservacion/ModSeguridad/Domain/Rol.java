package com.bus.sistema.app_reservacion.ModSeguridad.Domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Rol {
    private int rolId;
    private String denominacion;
    private Collection<RolMenu> rolMenusByRolId;
    private Collection<UserRole> userRolesByRolId;

    @Id
    @Column(name = "RolId", nullable = false)
    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    @Basic
    @Column(name = "Denominacion", nullable = false, length = 100)
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
        Rol rol = (Rol) o;
        return rolId == rol.rolId &&
                Objects.equals(denominacion, rol.denominacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rolId, denominacion);
    }

    @OneToMany(mappedBy = "rolByRolId")
    public Collection<RolMenu> getRolMenusByRolId() {
        return rolMenusByRolId;
    }

    public void setRolMenusByRolId(Collection<RolMenu> rolMenusByRolId) {
        this.rolMenusByRolId = rolMenusByRolId;
    }

    @OneToMany(mappedBy = "rolByRolId")
    public Collection<UserRole> getUserRolesByRolId() {
        return userRolesByRolId;
    }

    public void setUserRolesByRolId(Collection<UserRole> userRolesByRolId) {
        this.userRolesByRolId = userRolesByRolId;
    }
}
