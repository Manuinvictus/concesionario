package com.salesianos.concesionario.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "marcas")
public class Marcas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idmarca;
    private String nombremarca;
    private Date fundacion;
    private int patrimonio;
    private String moneda;

    // Getters
    public int getIdmarca() {
        return idmarca;
    }
    public String getNombremarca() {
        return nombremarca;
    }
    public Date getFundacion() {
        return fundacion;
    }
    public int getPatrimonio() {
        return patrimonio;
    }
    public String getMoneda() {
        return moneda;
    }

    // Setters
    public void setIdmarca(int idmarca) {
        this.idmarca = idmarca;
    }
    public void setNombremarca(String nombremarca) {
        this.nombremarca = nombremarca;
    }
    public void setFundacion(Date fundacion) {
        this.fundacion = fundacion;
    }
    public void setPatrimonio(int patrimonio) {
        this.patrimonio = patrimonio;
    }
    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }
}