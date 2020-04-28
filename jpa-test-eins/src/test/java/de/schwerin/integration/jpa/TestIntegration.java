package de.schwerin.jpa.integration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class TestIntegration {
	
	final static Logger logger = Logger.getLogger(TestIntegration.class);

	private EntityManager em;

	public TestIntegration() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("IntegrationPU");
		em = emf.createEntityManager();
	}
	
	@Test
	public void createEntrys() {
		
		em.getTransaction().begin();
		TestCases tc = new TestCases("gruppe", "klasse", "methode");
		em.persist(tc);

		TestCasesErrors errors = new TestCasesErrors(tc.getId());
		em.persist(errors);
		
		em.getTransaction().commit();
	}
}
