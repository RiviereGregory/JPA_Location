package fr.treeptik.jpalocation.model;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TestContratVoiture {

	private static EntityManager entityManager = Persistence.createEntityManagerFactory("location")
			.createEntityManager();

	@Test
	public void testFindVoiture() {

		Contrat contrat = entityManager.find(Contrat.class, 1);

		System.out.println("Client no : " + contrat.getClient().getCodeClient());
		System.out.println("Client nom : " + contrat.getClient().getNomClient());
		System.out.println("Client ville : " + contrat.getClient().getVille());
		System.out.println("Client Adresse : " + contrat.getClient().getAdresse());
		System.out.println("Contrat no : " + contrat.getNoContrat());
		System.out.println("Contrat date contrat : " + contrat.getDateContrat());
		System.out.println("Contrat date enlevement : " + contrat.getDateEnlevement());
		System.out.println("Contrat date retour : " + contrat.getDateRetour());
		System.out.println("Voiture no : " + contrat.getVoiture().getNoImmatriculation());
		System.out.println("Voiture Marque : " + contrat.getVoiture().getMarque());
		System.out.println("Voiture Modele : " + contrat.getVoiture().getModele());
		System.out.println("Voiture Couleur : " + contrat.getVoiture().getCouleur());
		System.out.println("Voiture Cumul Réparation : "
				+ contrat.getVoiture().getCumulReparation());
		System.out.println("Voiture Disponible : " + contrat.getVoiture().getDisponible());

		System.out.println("");

	}

}
