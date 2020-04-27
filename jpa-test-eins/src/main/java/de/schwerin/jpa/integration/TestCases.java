package de.schwerin.jpa.integration;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cascade;

@Entity(name = "dld_testcases")
@Table(schema = "integration", uniqueConstraints=@UniqueConstraint(columnNames = {"GRUPPE", "KLASSE", "METHODE"}))
public class TestCases {
	
	public TestCases(String gruppe, String klasse, String methode) {
		super();
		this.gruppe = gruppe;
		this.klasse = klasse;
		this.methode = methode;
	}

	@Id
	@Column(name = "ID")	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "GRUPPE")	
	private String gruppe;

	@Column(name = "KLASSE")
	private String klasse;
	
	@Column(name="METHODE")
	private String methode;
	
	@OneToMany(cascade = CascadeType.ALL)	
	@JoinColumn(name = "testCaseId")
	private Set<TestCasesErrors> errors;
	
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

	public int getId() {
		return id;
	}

	

}
