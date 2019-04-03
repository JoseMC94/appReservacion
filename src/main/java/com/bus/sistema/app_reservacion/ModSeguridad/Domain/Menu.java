package com.bus.sistema.app_reservacion.ModSeguridad.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Menu {
    private int menuId;
    private String denominacion;
    private String modulo;
    private String icono;
    private Boolean indPadre;
    private Integer referencia;
    @JsonIgnore
    private Collection<RolMenu> rolMenusByMenuId;

    @Id
    @Column(name = "MenuId", nullable = false)
    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    @Basic
    @Column(name = "Denominacion", nullable = true, length = 50)
    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    @Basic
    @Column(name = "Modulo", nullable = true, length = 50)
    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    @Basic
    @Column(name = "Icono", nullable = true, length = 200)
    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    @Basic
    @Column(name = "IndPadre", nullable = true)
    public Boolean getIndPadre() {
        return indPadre;
    }

    public void setIndPadre(Boolean indPadre) {
        this.indPadre = indPadre;
    }

    @Basic
    @Column(name = "Referencia", nullable = true)
    public Integer getReferencia() {
        return referencia;
    }

    public void setReferencia(Integer referencia) {
        this.referencia = referencia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return menuId == menu.menuId &&
                Objects.equals(denominacion, menu.denominacion) &&
                Objects.equals(modulo, menu.modulo) &&
                Objects.equals(icono, menu.icono) &&
                Objects.equals(indPadre, menu.indPadre) &&
                Objects.equals(referencia, menu.referencia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuId, denominacion, modulo, icono, indPadre, referencia);
    }


    @OneToMany(fetch =FetchType.EAGER, mappedBy = "menuByMenuId")
    public Collection<RolMenu> getRolMenusByMenuId() {
        return rolMenusByMenuId;
    }

    public void setRolMenusByMenuId(Collection<RolMenu> rolMenusByMenuId) {
        this.rolMenusByMenuId = rolMenusByMenuId;
    }
}
