package com.salesianos.concesionario.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Date;

@Entity
public class Vendedores {

    @Id
    private int idvendedor;
    private String nombre;
    private String apellidos;
    private Date fechanacimiento;
    private String dni;
    private String cargo;

    // Constructor
    public Vendedores(int idvendedor, String nombre, String apellidos, Date fechanacimiento, String dni, String cargo) {
        this.idvendedor = idvendedor;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechanacimiento = fechanacimiento;
        this.dni = dni;
        this.cargo = cargo;
    }

    // Getters
    public int getIdvendedor() {
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
    public void setIdvendedor(int idvendedor) {
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
