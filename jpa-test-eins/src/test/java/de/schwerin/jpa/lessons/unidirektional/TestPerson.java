package de.schwerin.jpa.lessons.unidirektional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import de.schwerin.jpa.lessons.unidirektional.Adresse;
import de.schwerin.jpa.lessons.unidirektional.Person;

@Test(enabled = false)
public class TestPerson {
	
	final static Logger logger = Logger.getLogger(TestPerson.class);

	private EntityManager em;

	public TestPerson() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("EmployeePU");
		em = emf.createEntityManager();
	}

	@Test
	public void testCreatePerson() throws InterruptedException {

		em.getTransaction().begin();
		Person k = new Person("Regina", "Spaller", createDateFromString("27.09.1963"));
		Person k1 = new Person("Anja", "Kurth", createDateFromString("03.04.1972"));
		
		Adresse adr1 = new Adresse("Weidenweg", "11", "10405", "Berlin");		
		Adresse adr2 = new Adresse("Str der DSF", "25", "14513", "Teltow");
		
		k.setAdresse(adr1);
		k1.setAdresse(adr2);

		em.persist(k);
		em.persist(k1);
		
//		em.persist(adr1);		
//		em.persist(adr2);

		em.getTransaction().commit();
		
		Person p = em.find(Person.class, k.getId());
		System.out.println(p + " " + p.getAdresse());
		Assert.assertNotNull(p.getCreateDate());
		
//		Thread.sleep(5000);
//		
//		p.setAdresse("adresse13");
//		
//		
//		em.getTransaction().begin();
//		em.getTransaction().commit();
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
