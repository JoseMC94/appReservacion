package com.bus.sistema.app_reservacion.ModSeguridad.Domain;

import com.bus.sistema.app_reservacion.ModReservacion.Domain.Endocedetalle;
import com.bus.sistema.app_reservacion.ModReservacion.Domain.Pasaje;
import com.bus.sistema.app_reservacion.ModVenta.Domain.Venta;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Persona {
    private int personaId;
    private String nombres;
    private String paterno;
    private String materno;
    private String nombreCompleto;
    private String dni;
    private String celular;
    private String correo;
    private String sexo;
    private Date fechaNacimiento;
    private String direccion;
    private String referencia;
    @JsonIgnore
    private Collection<User> usersByPersonaId;
    @JsonIgnore
    private Collection<Endocedetalle> endocedetallesByPersonaId;
    @JsonIgnore
    private Collection<Pasaje> pasajesByPersonaId;
    @JsonIgnore
    private Collection<Venta> ventasByPersonaId;

    @Id
    @Column(name = "PersonaId", nullable = false)
    public int getPersonaId() {
        return personaId;
    }

    public void setPersonaId(int personaId) {
        this.personaId = personaId;
    }

    @Basic
    @Column(name = "Nombres", nullable = false, length = 60)
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    @Basic
    @Column(name = "Paterno", nullable = true, length = 60)
    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    @Basic
    @Column(name = "Materno", nullable = true, length = 60)
    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    @Basic
    @Column(name = "NombreCompleto", nullable = false, length = 255)
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    @Basic
    @Column(name = "DNI", nullable = false, length = 8)
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Basic
    @Column(name = "Celular", nullable = true, length = 10)
    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Basic
    @Column(name = "Correo", nullable = true, length = 100)
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Basic
    @Column(name = "Sexo", nullable = true)
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Basic
    @Column(name = "FechaNacimiento", nullable = true)
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Basic
    @Column(name = "Direccion", nullable = true, length = 512)
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Basic
    @Column(name = "Referencia", nullable = true, length = 512)
    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return personaId == persona.personaId &&
                Objects.equals(nombres, persona.nombres) &&
                Objects.equals(paterno, persona.paterno) &&
                Objects.equals(materno, persona.materno) &&
                Objects.equals(nombreCompleto, persona.nombreCompleto) &&
                Objects.equals(dni, persona.dni) &&
                Objects.equals(celular, persona.celular) &&
                Objects.equals(correo, persona.correo) &&
                Objects.equals(sexo, persona.sexo) &&
                Objects.equals(fechaNacimiento, persona.fechaNacimiento) &&
                Objects.equals(direccion, persona.direccion) &&
                Objects.equals(referencia, persona.referencia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personaId, nombres, paterno, materno, nombreCompleto, dni, celular, correo, sexo, fechaNacimiento, direccion, referencia);
    }

    @OneToMany(mappedBy = "personaByPersonaId")
    public Collection<User> getUsersByPersonaId() {
        return usersByPersonaId;
    }

    public void setUsersByPersonaId(Collection<User> usersByPersonaId) {
        this.usersByPersonaId = usersByPersonaId;
    }

    public String fechaConvert() {
        return this.fechaNacimiento.toString();
    }

    @OneToMany(mappedBy = "personaByPersonaId")
    public Collection<Endocedetalle> getEndocedetallesByPersonaId() {
        return endocedetallesByPersonaId;
    }

    public void setEndocedetallesByPersonaId(Collection<Endocedetalle> endocedetallesByPersonaId) {
        this.endocedetallesByPersonaId = endocedetallesByPersonaId;
    }

    @OneToMany(mappedBy = "personaByPersonaId")
    public Collection<Pasaje> getPasajesByPersonaId() {
        return pasajesByPersonaId;
    }

    public void setPasajesByPersonaId(Collection<Pasaje> pasajesByPersonaId) {
        this.pasajesByPersonaId = pasajesByPersonaId;
    }

    @OneToMany(mappedBy = "personaByPersonaId")
    public Collection<Venta> getVentasByPersonaId() {
        return ventasByPersonaId;
    }

    public void setVentasByPersonaId(Collection<Venta> ventasByPersonaId) {
        this.ventasByPersonaId = ventasByPersonaId;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "personaId=" + personaId +
                ", nombres='" + nombres + '\'' +
                ", paterno='" + paterno + '\'' +
                ", materno='" + materno + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }

    public Persona(int personaId, String nombreCompleto) {
        this.personaId = personaId;
        this.nombreCompleto = nombreCompleto;
    }
    public Persona() {
    }
}
