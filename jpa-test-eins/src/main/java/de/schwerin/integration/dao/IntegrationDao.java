package de.schwerin.integration.dao;

import java.io.Serializable;

public class IntegrationDao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5986001574169344973L;
	
	
	private String gruppe;

	
	private String klasse;
	
	
	private String methode;


	public String getGruppe() {
		return gruppe;
	}


	public void setGruppe(String gruppe) {
		this.gruppe = gruppe;
	}


	public String getKlasse() {
		return klasse;
	}


	public void setKlasse(String klasse) {
		this.klasse = klasse;
	}


	public String getMethode() {
		return methode;
	}


	public void setMethode(String methode) {
		this.methode = methode;
	}

}
