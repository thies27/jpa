package de.schwerin.integration.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import de.schwerin.integration.business.DldTestCasesPersistenzHandler;
import de.schwerin.integration.dao.IntegrationDao;
import de.schwerin.integration.data.DataReader;
import de.schwerin.integration.data.FileDataReader;
import de.schwerin.integration.jpa.TableTestCases;
import de.schwerin.integration.jpa.TableTestCasesErrors;

public class TestIntegration {

	final static Logger logger = Logger.getLogger(TestIntegration.class);

	private EntityManager em;
	
	String path = "/home/mathias/temp/testcases.txt";
	
	@Test
	public void testPersistenzHandler() {
		
		DldTestCasesPersistenzHandler h = new DldTestCasesPersistenzHandler();
		h.persist(path);
	}
	
	@Test
	public void testDataReader() {		
		
		DataReader dr = new FileDataReader(path);
		
		IntegrationDao dao = dr.readData(new IntegrationDao());
		
		Assert.assertTrue(dao != null);
		
		Assert.assertTrue(dao.getTestFälle().size() == 4);
	}

	@Test
	public void createDataBaseEntrys() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("IntegrationPU");
		em = emf.createEntityManager();

		em.getTransaction().begin();
		TableTestCases tc = new TableTestCases("gruppe", "klasse", "methode");
		em.persist(tc);

		TableTestCasesErrors errors = new TableTestCasesErrors(tc.getId());
		em.persist(errors);

		em.getTransaction().commit();

		TableTestCasesErrors e2 = em.find(TableTestCasesErrors.class, errors.getId());

		Assert.assertTrue(tc.getId() == e2.getTestCaseId(), "Die ID aus TestCases mit testCaseId übereinstimmen.  ");

		Assert.assertNotNull(e2.getExecuteDate(), "Das Datum darf nicht leer sein.  ");

	}
}
