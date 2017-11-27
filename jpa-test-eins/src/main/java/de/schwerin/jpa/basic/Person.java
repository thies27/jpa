/**
 * 
 */
package de.schwerin.jpa.basic;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Mathias
 * 
 * Ausgangspunkt fuer alle Personen, Kunden etc...
 *
 */
@Entity(name="person_basic")
public class Person {

	public Person() {

	}

	public Person(String firstName, String lastName, Date geburtstag,
			String adresse) {

		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setGeburtstag(geburtstag);
		this.setAdresse(adresse);		
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "Vorname")
	private String firstName;

	@Column(name = "Nachname")
	private String lastName;

	@Column(name = "Geburtstag")
	@Temporal(TemporalType.DATE)
	private Date geburtstag;

	
	@Column(name="adresse")
	private String adresse;

	
	@Column(name = "Eingefügt", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	
	@Column(name = "Geändert")
	@Temporal(TemporalType.TIMESTAMP)
	private Date changeDate;
	
	/**
	 * erzeugt einen Zeitstempel beim ersten Erstellen des Datensatzes
	 */
	@PrePersist
	public void create() {
	    createDate = new Date();
	  }
	
	/**
	 * erzeugt einen Zeitstempel beim Ändern des Datensatzes
	 */
	@PreUpdate
	public void update(){
		changeDate = new Date();
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getGeburtstag() {
		return geburtstag;
	}

	public void setGeburtstag(Date geburtstag) {
		this.geburtstag = geburtstag;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	
}
