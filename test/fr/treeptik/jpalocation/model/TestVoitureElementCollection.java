package fr.treeptik.jpalocation.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TestVoitureElementCollection {

	private static EntityManager entityManager = Persistence.createEntityManagerFactory("location")
			.createEntityManager();
	
	@Test
	public void testListOption() {
		List<String> options = new ArrayList<>();
		options.add("Climatisation");
		options.add("6 Vitesse");
		options.add("Vitres électrique");
		Voiture voiture = new Voiture(null, "Renault", "Scenic", "Bleu acier", 0, true, entityManager.find(TypeVoiture.class, 5), options);
		
		entityManager.getTransaction().begin();
		entityManager.persist(voiture);
		entityManager.getTransaction().commit();
		
		
	}

}
