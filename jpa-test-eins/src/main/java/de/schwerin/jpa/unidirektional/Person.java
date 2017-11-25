/**
 * 
 */
package de.schwerin.jpa.unidirektional;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Mathias
 *
 */
@Entity(name="person_uni")
public class Person {

	public Person() {

	}

	public Person(String firstName, String lastName, Date geburtstag) {

		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setGeburtstag(geburtstag);
			
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "vorname")
	private String firstName;

	@Column(name = "nachname")
	private String lastName;

	@Column(name = "geburtstag")
	@Temporal(TemporalType.DATE)
	private Date geburtstag;

	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_adresse")//Name der Spalte
	private Adresse adresse;

	
	@Column(name = "erstellt", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	
	@Column(name = "aktualisiert")
	@Temporal(TemporalType.TIMESTAMP)
	private Date changeDate;
	
	
	@PrePersist
	public void create() {
	    createDate = new Date();
	  }
	
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

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public String toString(){
		
		SimpleDateFormat sdf = new  SimpleDateFormat("dd.MM.yyyy");
		String strGeburtstag = sdf.format(geburtstag);
		
		return firstName + " " + lastName + " " + strGeburtstag;
	}

}
