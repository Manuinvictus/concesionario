package com.salesianos.concesionario.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CochePorMarca {
    
	@Id
	private long idcoche;
	private String modelo;
	private int idmarca;

	
	//Builder
	public CochePorMarca(long idcoche, String modelo, int idmarca) {
		this.idcoche = idcoche;
		this.modelo = modelo;
		this.idmarca = idmarca;
	}


	//Getter
	public long getIdcoche() {
		return idcoche;
	}


	public String getModelo() {
		return modelo;
	}


	public int getIdmarca() {
		return idmarca;
	}


	public void setIdcoche(long idcoche) {
		this.idcoche = idcoche;
	}


	//Setter
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public void setIdmarca(int idmarca) {
		this.idmarca = idmarca;
	}

	
}