package de.schwerin.jpa.bidirektional.einzueins;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="adresse_bi")
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
	
	/**
	 * Strasse
	 */
	private String strasse;
	
	private String hausNummer;
	
	private String plz;
	
	private String ort;
	
	@Column(name = "erstellt", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
	@PrePersist
	public void create() {
	    createDate = new Date();
	  }
	
	@OneToOne(mappedBy="adresse")
	private Person person;

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

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


}
