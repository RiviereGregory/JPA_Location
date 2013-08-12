package fr.treeptik.jpalocation.model;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TestReparationVoiture {

	private static EntityManager entityManager = Persistence.createEntityManagerFactory("location")
			.createEntityManager();

	@Test
	public void testFindVoiture() {

		Reparations reparations = entityManager.find(Reparations.class, 2);

		System.out.println("Reparation no : " + reparations.getNumeroRep());
		System.out.println("Reparation date réparation : " + reparations.getDateReparation());
		System.out.println("Reparation Description de la panne : "
				+ reparations.getDescriptionPanne());
		System.out.println("Reparation Montant de la réparation : "
				+ reparations.getMontantReparation());
		System.out.println("Voiture no : " + reparations.getVoiture().getNoImmatriculation());
		System.out.println("Voiture Marque : " + reparations.getVoiture().getMarque());
		System.out.println("Voiture Modele : " + reparations.getVoiture().getModele());
		System.out.println("Voiture Couleur : " + reparations.getVoiture().getCouleur());
		System.out.println("Voiture Cumul Réparation : "
				+ reparations.getVoiture().getCumulReparation());
		System.out.println("Voiture Disponible : " + reparations.getVoiture().getDisponible());

		System.out.println("");
	}

}
