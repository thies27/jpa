package de.schwerin.jpa.lessons.unidirektional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="adresse_uni")
@Table(catalog = "jpa_test")
public class Adresse {	
	
	public Adresse() {
		
	}
	
	public Adresse(String strasse, String hausNummer,
			String plz, String ort) {
		super();		
		this.strasse = strasse;
		this.hausNummer = hausNummer;
		this.plz = plz;
		this.ort = ort;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String strasse;
	
	private String hausNummer;
	
	private String plz;
	
	private String ort;

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getHausNummer() {
		return hausNummer;
	}

	public void setHausNummer(String hausNummer) {
		this.hausNummer = hausNummer;
	}

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String toString(){
		
		StringBuffer sb = new StringBuffer();
		sb.append(plz);
		sb.append(" ");
		sb.append(ort);
		sb.append(" ");
		sb.append(strasse);
		sb.append(" ");
		sb.append(hausNummer);
		
		return sb.toString();
	}

}
