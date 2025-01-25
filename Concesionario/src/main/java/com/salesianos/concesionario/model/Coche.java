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
    private long idmarca;
    private int anyofabricacion;
    private int precio;
    private String moneda;
    private long idvendedor;

    // Getters
    public long getIdcoche() {
        return idcoche;
    }
    public String getModelo() {
        return modelo;
    }
    public long getIdmarca() {
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
    public long getIdvendedor() {
        return idvendedor;
    }

    // Setters
    public void setIdcoche(long idcoche) {
        this.idcoche = idcoche;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public void setIdmarca(long idmarca) {
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
    public void setIdvendedor(long idvendedor) {
        this.idvendedor = idvendedor;
    }
}