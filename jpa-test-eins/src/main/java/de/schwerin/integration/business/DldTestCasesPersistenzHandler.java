package de.schwerin.integration.business;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

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

	public boolean existInDatabase(String path) {	
		
		boolean isExist = true;
		
		DataReader reader = new FileDataReader(path);		
		IntegrationDao dao = reader.readData(new IntegrationDao());
		
		for (Map<String, String> map : dao.getTestFälle()) {
			Query q = em.createNamedQuery("TableTestCases.FindIdByGroup");
			q.setParameter("gruppe", map.get("gruppe"));
			q.setParameter("klasse", map.get("klasse"));
			q.setParameter("methode", map.get("methode"));
			
			try {
				q.getSingleResult();
			} catch (NoResultException e) {
				isExist = false;
			}
		}
		
		return isExist;
	}

}
