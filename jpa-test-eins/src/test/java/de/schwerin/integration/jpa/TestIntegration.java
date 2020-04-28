package de.schwerin.integration.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import de.schwerin.integration.data.DataReader;
import de.schwerin.integration.jpa.TestCases;
import de.schwerin.integration.jpa.TestCasesErrors;

public class TestIntegration {

	final static Logger logger = Logger.getLogger(TestIntegration.class);

	private EntityManager em;

	public TestIntegration() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("IntegrationPU");
		em = emf.createEntityManager();
	}
	
	@Test
	public void testDataReader() {
		
		DataReader dr = new DataReader();
		
		dr.readFromFile();
	}

	@Test
	public void createDataBaseEntrys() {

		em.getTransaction().begin();
		TestCases tc = new TestCases("gruppe", "klasse", "methode");
		em.persist(tc);

		TestCasesErrors errors = new TestCasesErrors(tc.getId());
		em.persist(errors);

		em.getTransaction().commit();

		TestCasesErrors e2 = em.find(TestCasesErrors.class, errors.getId());

		Assert.assertTrue(tc.getId() == e2.getTestCaseId(), "Die ID aus TestCases mit testCaseId übereinstimmen.  ");

		Assert.assertNotNull(e2.getExecuteDate(), "Das Datum darf nicht leer sein.  ");

	}
}
