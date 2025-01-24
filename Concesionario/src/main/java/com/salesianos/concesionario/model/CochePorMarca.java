package com.salesianos.concesionario.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CochePorMarca {
    
	@Id
	private long idcoche;
	private String modelo;
	private String nombremarca;
    private int anyofabricacion;
    private int precio;
    private String moneda;
    private String nombre;
    private String apellidos;
    private String cargo;
	
	//Builder
	public CochePorMarca(long idcoche, String modelo, String nombremarca, int anyofabricacion, int precio, String moneda, String nombre, String apellidos, String cargo) {
		this.idcoche = idcoche;
		this.modelo = modelo;
		this.nombremarca = nombremarca;
		this.anyofabricacion = anyofabricacion;
		this.precio = precio;
		this.moneda = moneda;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.cargo = cargo;
	}


	//Getter
	public long getIdcoche() {
		return idcoche;
	}

	public String getModelo() {
		return modelo;
	}

	public String getNombremarca() {
		return nombremarca;
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

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getCargo() {
		return cargo;
	}

	//Setter
	public void setIdcoche(long idcoche) {
		this.idcoche = idcoche;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setNombremarca(String nombremarca) {
		this.nombremarca = nombremarca;
<<<<<<< HEAD
=======
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

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
>>>>>>> origin/Alex
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

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
}