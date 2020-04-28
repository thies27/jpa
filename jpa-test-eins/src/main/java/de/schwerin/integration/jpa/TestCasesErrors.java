package de.schwerin.jpa.integration;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "dld_testcases_errors", schema = "integration")
public class TestCasesErrors {
	
	public TestCasesErrors(int testCaseId) {
		super();
		this.testCaseId = testCaseId;
	}

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "TESTCASE_ID")	
	private int testCaseId;
	
	@Column(name = "EXEC_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date executeDate;
	
	
}
