package com.salesianos.concesionario.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "coches")
public class Coche {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idcoche;
    private String modelo;
    private int idmarca;
    private int anyofabricacion;
    private int precio;
    private String moneda;
    private int idvendedor;

    // Getters
    public long getIdcoche() {
        return idcoche;
    }
    public String getModelo() {
        return modelo;
    }
    public int getIdmarca() {
        return idmarca;
    }
    public int getAnyofabricacion() {
        return anyofabricacion;
    }
    public int getPrecio() {
        return precio;
    }
    public String getMoneda() {
        return moneda;
    }
    public int getIdvendedor() {
        return idvendedor;
    }

    // Setters
    public void setIdcoche(long idcoche) {
        this.idcoche = idcoche;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public void setIdmarca(int idmarca) {
        this.idmarca = idmarca;
    }
    public void setAnyofabricacion(int anyofabricacion) {
        this.anyofabricacion = anyofabricacion;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }
    public void setIdvendedor(int idvendedor) {
        this.idvendedor = idvendedor;
    }
}