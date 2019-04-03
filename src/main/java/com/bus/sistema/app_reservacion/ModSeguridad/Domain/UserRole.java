package com.bus.sistema.app_reservacion.ModSeguridad.Domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_role", schema = "reservacion", catalog = "")
public class UserRole {
    private int id;
    private int usuarioId;
    private int rolId;
    private int userRole;
    private String role;
    private String username;
    private User userByUsuarioId;
    private Rol rolByRolId;

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

    @Basic
    @Column(name = "user_role", nullable = false)
    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }

    @Basic
    @Column(name = "role", nullable = false, length = 45)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 45)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole userRole1 = (UserRole) o;
        return id == userRole1.id &&
                usuarioId == userRole1.usuarioId &&
                rolId == userRole1.rolId &&
                userRole == userRole1.userRole &&
                Objects.equals(role, userRole1.role) &&
                Objects.equals(username, userRole1.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usuarioId, rolId, userRole, role, username);
    }

    @ManyToOne
    @JoinColumn(name = "UsuarioId", referencedColumnName = "UsuarioId", nullable = false, insertable = false, updatable = false)
    public User getUserByUsuarioId() {
        return userByUsuarioId;
    }

    public void setUserByUsuarioId(User userByUsuarioId) {
        this.userByUsuarioId = userByUsuarioId;
    }


    @ManyToOne
    @JoinColumn(name = "RolId", referencedColumnName = "RolId", nullable = false, insertable = false, updatable = false)
    public Rol getRolByRolId() {
        return rolByRolId;
    }

    public void setRolByRolId(Rol rolByRolId) {
        this.rolByRolId = rolByRolId;
    }


    @Override
    public String toString() {
        String a = "\nid: " +id+
                "\nusuarioId: " +usuarioId+
                "\nrolId: " +rolId+
                "\nuserRole: " +userRole+
                "\nrole: " +role+
                "\nusername: "+username;
        return a;
    }
}
