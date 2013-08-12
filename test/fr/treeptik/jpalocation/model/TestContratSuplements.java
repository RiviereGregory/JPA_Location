package fr.treeptik.jpalocation.model;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TestContratSuplements {
	private static EntityManager entityManager = Persistence.createEntityManagerFactory("location")
			.createEntityManager();

	@Test
	public void testFindSuplements() {

		TypedQuery<Contrat> query = entityManager
				.createQuery(
						"SELECT con FROM Contrat con LEFT JOIN FETCH con.suplements sup WHERE con.noContrat= :noContrat",
						Contrat.class);
		query.setParameter("noContrat", 1);

		Contrat contrat = query.getSingleResult();

		System.out.println("Client no : " + contrat.getClient().getCodeClient());
		System.out.println("Client nom : " + contrat.getClient().getNomClient());
		System.out.println("Client ville : " + contrat.getClient().getVille());
		System.out.println("Client Adresse : " + contrat.getClient().getAdresse());
		System.out.println("Contrat no : " + contrat.getNoContrat());
		System.out.println("Contrat date contrat : " + contrat.getDateContrat());
		System.out.println("Contrat date enlevement : " + contrat.getDateEnlevement());
		System.out.println("Contrat date retour : " + contrat.getDateRetour());
		for (Suplements suplements : contrat.getSuplements()) {
			System.out.println("Suplements id : " + suplements.getCodeSuplement());
			System.out.println("Suplements libelle : " + suplements.getLibelleSupplement());
			System.out.println("Suplements tarif : " + suplements.getTarifJour());

		}
		System.out.println("");

	}

}
