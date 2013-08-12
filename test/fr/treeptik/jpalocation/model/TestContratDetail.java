package fr.treeptik.jpalocation.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TestContratDetail {
	private static EntityManager entityManager = Persistence.createEntityManagerFactory("location")
			.createEntityManager();

	@Test
	public void testContratDetail() {

		// TypedQuery<ContratDetail> query = entityManager
		// .createQuery(
		// "SELECT new fr.treeptik.jpalocation.model.ContratDetail(c.client.nomClient,c.dateContrat,c.voiture.marque, "
		// + " c.voiture.typeVoiture.descriptionType) FROM Contrat c",
		// ContratDetail.class);

		// Autre possibilité passer par des jointure
		TypedQuery<ContratDetail> query = entityManager
				.createQuery(
						"SELECT new fr.treeptik.jpalocation.model.ContratDetail(cli.nomClient,c.dateContrat,voi.marque, "
								+ " tv.descriptionType) FROM Contrat c JOIN c.client cli JOIN c.voiture voi JOIN c.voiture.typeVoiture tv",
						ContratDetail.class);

		List<ContratDetail> list = query.getResultList();
		for (ContratDetail contratDetail : list) {
			System.out.println("Contrat nom Client : " + contratDetail.getNomClient());
			System.out.println("Contrat marque voiture : " + contratDetail.getMarqueVoiture());
			System.out.println("Contrat description : " + contratDetail.getDescriptionType());
			System.out.println("Contrat date : " + contratDetail.getDateContrat());
			System.out.println("");

		}

	}

}
