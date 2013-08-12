package fr.treeptik.jpalocation.model;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TestVoitureTypeVoiture {

	private static EntityManager entityManager = Persistence.createEntityManagerFactory("location")
			.createEntityManager();

	@Test
	public void testFindTypeVoiture() {

		Voiture voiture = entityManager.find(Voiture.class, 1);

		System.out.println("Voiture no : " + voiture.getNoImmatriculation());
		System.out.println("Voiture Marque : " + voiture.getMarque());
		System.out.println("Voiture Modele : " + voiture.getModele());
		System.out.println("Voiture Couleur : " + voiture.getCouleur());
		System.out.println("Voiture Cumul Réparation : " + voiture.getCumulReparation());
		System.out.println("Voiture Disponible : " + voiture.getDisponible());
		System.out.println("Type Voiture no : " + voiture.getTypeVoiture().getCodeType());
		System.out.println("Type Voiture desc : " + voiture.getTypeVoiture().getDescriptionType());
		System.out.println("Type Voiture places : " + voiture.getTypeVoiture().getPlaces());
		System.out.println("Type Voiture prix jour : " + voiture.getTypeVoiture().getPrixJour());

		System.out.println("");

	}

}
