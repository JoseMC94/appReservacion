package com.bus.sistema.app_reservacion.ModVenta.Domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Producto {
    private int productoId;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private int cantidad;
    private String marca;
    private String talla;
    private String color;

    @Id
    @Column(name = "ProductoId")
    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    @Basic
    @Column(name = "Nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "Descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "Precio")
    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    @Basic
    @Column(name = "cantidad")
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return productoId == producto.productoId &&
                cantidad == producto.cantidad &&
                Objects.equals(nombre, producto.nombre) &&
                Objects.equals(descripcion, producto.descripcion) &&
                Objects.equals(precio, producto.precio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productoId, nombre, descripcion, precio, cantidad);
    }

    @Basic
    @Column(name = "Marca")
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Basic
    @Column(name = "Talla")
    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    @Basic
    @Column(name = "Color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
