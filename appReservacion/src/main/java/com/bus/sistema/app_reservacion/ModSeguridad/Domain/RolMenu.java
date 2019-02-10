package com.bus.sistema.app_reservacion.ModSeguridad.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "rol_menu", schema = "reservacion", catalog = "")
public class RolMenu {
    private int id;
    private int rolId;
    private int menuId;
    @JsonIgnore
    private Rol rolByRolId;
    @JsonIgnore
    private Menu menuByMenuId;

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

    @ManyToOne(optional=false)
    @JoinColumn(name = "RolId", referencedColumnName = "RolId", nullable = false,insertable=false, updatable=false)
    public Rol getRolByRolId() {
        return rolByRolId;
    }

    public void setRolByRolId(Rol rolByRolId) {
        this.rolByRolId = rolByRolId;
    }


    @ManyToOne(optional=false)
    @JoinColumn(name = "MenuId", referencedColumnName = "MenuId", nullable = false,insertable=false, updatable=false)
    public Menu getMenuByMenuId() {
        return menuByMenuId;
    }

    public void setMenuByMenuId(Menu menuByMenuId) {
        this.menuByMenuId = menuByMenuId;
    }
}
