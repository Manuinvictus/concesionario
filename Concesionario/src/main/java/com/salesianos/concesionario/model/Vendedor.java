package com.salesianos.concesionario.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "vendedores")
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idvendedor;
    private String nombre;
    private String apellidos;
    private Date fechanacimiento;
    private String dni;
    private String cargo;

    // Getters
    public long getIdvendedor() {
        return idvendedor;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public Date getFechanacimiento() {
        return fechanacimiento;
    }
    public String getDni() {
        return dni;
    }
    public String getCargo() {
        return cargo;
    }

    // Setters
    public void setIdvendedor(long idvendedor) {
        this.idvendedor = idvendedor;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
