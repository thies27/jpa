package de.schwerin.jpa.basic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;



public class TestPersonMySql {
	
	final static Logger logger = Logger.getLogger(TestPersonMySql.class);

	private EntityManager em;

	public TestPersonMySql() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("EmployeePU");
		em = emf.createEntityManager();
	}

	@Test
	public void testCreatePerson() throws InterruptedException {

		em.getTransaction().begin();
		Person k = new Person("Regina", "Spaller", createDateFromString("27.09.1963"), "adresse1");
		Person k1 = new Person("Hartwig", "Schwerin", createDateFromString("03.04.1942"), "adresse2");

		em.persist(k);
		em.persist(k1);

		em.getTransaction().commit();
		
		Person p = em.find(Person.class, k.getId());
		Assert.assertNotNull(p.getCreateDate());
		
		Thread.sleep(5000);
		
		p.setAdresse("adresse13");
		
				
		em.getTransaction().begin();
		em.getTransaction().commit();
//		
//		// ist die gleiche Instanz
//		logger.debug("k in Persitenzkontext enthalten: " + em.contains(k));
//		logger.debug("p in Persitenzkontext enthalten: " + em.contains(p));
		
//		Person f1 = em.find(Person.class, 4);
//		Assert.assertTrue("Kurth".equals(f1.getLastName()));
//		f1.setFirstName("Peter");
//		
//		em.getTransaction().begin();
//		em.getTransaction().commit();
		
		System.out.println("Ende");

	}
	
	
	private Date createDateFromString(String strDate){
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Date date = null;
		try {
			date = sdf.parse(strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return date;
	}

}
