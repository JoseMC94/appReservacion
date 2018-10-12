package com.bus.sistema.app_reservacion.ModSeguridad.Domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "rol_menu", schema = "reservacion", catalog = "")
public class RolMenu {
    private int id;
    private int rolId;
    private int menuId;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "MenuId", nullable = false)
    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RolMenu rolMenu = (RolMenu) o;
        return id == rolMenu.id &&
                rolId == rolMenu.rolId &&
                menuId == rolMenu.menuId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rolId, menuId);
    }
}
