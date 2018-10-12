package com.bus.sistema.app_reservacion.ModSeguridad.Domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "usuario_rol", schema = "reservacion", catalog = "")
public class UsuarioRol {
    private int id;
    private int usuarioId;
    private int rolId;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "RolId", nullable = false)
    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioRol that = (UsuarioRol) o;
        return id == that.id &&
                usuarioId == that.usuarioId &&
                rolId == that.rolId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usuarioId, rolId);
    }
}
