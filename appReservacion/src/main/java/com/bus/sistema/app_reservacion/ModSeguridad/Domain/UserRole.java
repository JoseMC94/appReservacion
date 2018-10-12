package com.bus.sistema.app_reservacion.ModSeguridad.Domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_role", schema = "reservacion", catalog = "")
public class UserRole {
    private int userRole;
    private String role;
    private String username;

    @Id
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
        return userRole == userRole1.userRole &&
                Objects.equals(role, userRole1.role) &&
                Objects.equals(username, userRole1.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userRole, role, username);
    }
}
