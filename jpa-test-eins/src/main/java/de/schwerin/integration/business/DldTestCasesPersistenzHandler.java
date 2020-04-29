package de.schwerin.integration.business;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import de.schwerin.integration.dao.IntegrationDao;
import de.schwerin.integration.data.DataReader;
import de.schwerin.integration.data.FileDataReader;

public class DldTestCasesPersistenzHandler {	
	
	private EntityManager em;
	
	
	public DldTestCasesPersistenzHandler() {
		super();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("IntegrationPU");
		this.em = emf.createEntityManager();
	}

	public void persist(String path) {		
		
		DataReader reader = new FileDataReader(path);		
		IntegrationDao dao = reader.readData(new IntegrationDao());
		
		for (Map<String, String> map : dao.getTestFälle()) {
			Integer id = (Integer) em.createNamedQuery("FindIdByGroup").getSingleResult();
		}
		
	}

}
