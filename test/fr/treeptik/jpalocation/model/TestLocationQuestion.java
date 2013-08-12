package fr.treeptik.jpalocation.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TestLocationQuestion {
	private static EntityManager entityManager = Persistence.createEntityManagerFactory("location")
			.createEntityManager();

	@Test
	public void testFindClientByName() {
		System.out.println("********* Find Client by name ********");
		TypedQuery<Client> query = entityManager.createQuery(
				"SELECT cli FROM Client cli ORDER BY cli.nomClient", Client.class);

		List<Client> list = query.getResultList();
		for (Client client : list) {

			System.out.println("Client no : " + client.getCodeClient());
			System.out.println("Client nom : " + client.getNomClient());
			System.out.println("Client ville : " + client.getVille());
			System.out.println("Client Adresse : " + client.getAdresse());
			System.out.println("");
		}
	}

	@Test
	public void testFindContratByDate() {
		System.out.println("********* Find Contrat by date********");
		TypedQuery<Contrat> query = entityManager.createQuery(
				"SELECT con FROM Contrat con ORDER BY con.dateContrat DESC", Contrat.class);

		List<Contrat> list = query.getResultList();
		for (Contrat contrat : list) {

			System.out.println("Contrat no : " + contrat.getNoContrat());
			System.out.println("Contrat date contrat : " + contrat.getDateContrat());
			System.out.println("Contrat date enlevement : " + contrat.getDateEnlevement());
			System.out.println("Contrat date retour : " + contrat.getDateRetour());
			System.out.println("");
		}
	}

	@Test
	public void testFindContratClient() {
		System.out.println("********* Find Contrat d'un client ********");
		TypedQuery<Contrat> query = entityManager.createQuery(
				"SELECT con FROM Contrat con WHERE con.client.codeClient= :codecl", Contrat.class);
		// Autre possibilité
		// TypedQuery<Contrat> query = entityManager.createQuery(
		// "SELECT con FROM Contrat con JOIN con.client cli WHERE cli.codeClient= :codecl",
		// Contrat.class);
		query.setParameter("codecl", 1);

		List<Contrat> list = query.getResultList();
		for (Contrat contrat : list) {

			System.out.println("Contrat no : " + contrat.getNoContrat());
			System.out.println("Contrat date contrat : " + contrat.getDateContrat());
			System.out.println("Contrat date enlevement : " + contrat.getDateEnlevement());
			System.out.println("Contrat date retour : " + contrat.getDateRetour());
			System.out.println("");
		}
	}

	@Test
	public void testFindVoitureDisponible() {
		System.out.println("********* Find Voiture Disponible ********");
		TypedQuery<Voiture> query = entityManager.createQuery(
				"SELECT voi FROM Voiture voi WHERE voi.disponible = :dispo", Voiture.class);
		query.setParameter("dispo", true);

		List<Voiture> list = query.getResultList();
		for (Voiture voiture : list) {

			System.out.println("Voiture no : " + voiture.getNoImmatriculation());
			System.out.println("");
		}
	}

	@Test
	public void testFindReparationVoiture() {
		System.out.println("********* Find Réparation d'une voiture donnée ********");
		TypedQuery<Reparations> query = entityManager.createQuery(
				"SELECT rep FROM Reparations rep WHERE rep.voiture.noImmatriculation = :noImmat",
				Reparations.class);
		query.setParameter("noImmat", 3);

		List<Reparations> list = query.getResultList();
		for (Reparations reparations : list) {

			System.out.println("Voiture no : " + reparations.getVoiture().getNoImmatriculation());
			System.out.println("Réparation no : " + reparations.getNumeroRep());
			System.out.println("Réparation date : " + reparations.getDateReparation());
			System.out.println("Réparation description : " + reparations.getDescriptionPanne());
			System.out.println("Réparation montant : " + reparations.getMontantReparation());

			System.out.println("");
		}
	}

	@Test
	public void testFindMaxReparation() {
		System.out.println("********* Find la Réparation la plus chère ********");
		TypedQuery<Reparations> query = entityManager
				.createQuery(
						"SELECT rep FROM Reparations rep WHERE rep.montantReparation = (SELECT MAX(r.montantReparation) FROM Reparations r)",
						Reparations.class);

		List<Reparations> list = query.getResultList();
		for (Reparations reparations : list) {

			System.out.println("Voiture no : " + reparations.getVoiture().getNoImmatriculation());
			System.out.println("Réparation no : " + reparations.getNumeroRep());
			System.out.println("Réparation date : " + reparations.getDateReparation());
			System.out.println("Réparation description : " + reparations.getDescriptionPanne());
			System.out.println("Réparation montant : " + reparations.getMontantReparation());

			System.out.println("");
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testFindNumberOfVoitureByType() {
		System.out.println("********* Find le nombre de voiutre par type ********");
		Query query = entityManager
				.createQuery("SELECT voi.typeVoiture.codeType, voi.typeVoiture.descriptionType, COUNT(voi.noImmatriculation) "
						+ " FROM Voiture voi GROUP BY voi.typeVoiture.codeType");

		List<Object[]> resultList = query.getResultList();
		for (Object[] objects : resultList) {

			System.out.println("code Type : " + objects[0]);
			System.out.println("description : " + objects[1]);
			System.out.println("nombre : " + objects[2]);
			System.out.println("");
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testFindNumberOfReparationsByVoiture() {
		System.out.println("********* Find le nombre de réparations par voiture ********");
		Query query = entityManager
				.createQuery("SELECT rep.voiture.noImmatriculation, rep.voiture.marque, COUNT(rep.voiture.noImmatriculation) "
						+ " FROM Reparations rep GROUP BY rep.voiture.noImmatriculation");

		List<Object[]> resultList = query.getResultList();
		for (Object[] objects : resultList) {

			System.out.println("Voiture immat : " + objects[0]);
			System.out.println("marque : " + objects[1]);
			System.out.println("nombre : " + objects[2]);
			System.out.println("");
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testFindNumberOfReparationsByType() {
		System.out.println("********* Find le nombre de réparations par Type ********");
		Query query = entityManager
				.createQuery("SELECT tv.codeType, tv.descriptionType, COUNT(rep.voiture.noImmatriculation) "
						+ " FROM Reparations rep JOIN rep.voiture.typeVoiture tv GROUP BY tv.codeType, tv.descriptionType");

		List<Object[]> resultList = query.getResultList();
		for (Object[] objects : resultList) {

			System.out.println("code type : " + objects[0]);
			System.out.println("description : " + objects[1]);
			System.out.println("nombre : " + objects[2]);
			System.out.println("");
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testFindMontantContratByClient() {
		System.out.println("********* Find le montant contrat par client ********");
		Query query = entityManager
				.createQuery("SELECT tv.codeType, tv.descriptionType, COUNT(rep.voiture.noImmatriculation) "
						+ " FROM Reparations rep JOIN rep.voiture.typeVoiture tv GROUP BY tv.codeType, tv.descriptionType");

		List<Object[]> resultList = query.getResultList();
		for (Object[] objects : resultList) {

			System.out.println("code type : " + objects[0]);
			System.out.println("description : " + objects[1]);
			System.out.println("nombre : " + objects[2]);
			System.out.println("");
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testFindVoitureDateContratIdentique() {
		System.out.println("********* Find Voiture avec même date contrat ********");
		Query query = entityManager
				.createQuery("SELECT con.voiture.noImmatriculation,con.voiture.marque, con.dateContrat , con.noContrat"
						+ " FROM Contrat con WHERE con.dateContrat IN (SELECT c.dateContrat FROM Contrat c "
						+ " WHERE c.voiture.noImmatriculation= :noImma) AND con.voiture.noImmatriculation<> :noImma");
		query.setParameter("noImma", 1);

		List<Object[]> resultList = query.getResultList();
		for (Object[] objects : resultList) {

			System.out.println("noImmat : " + objects[0]);
			System.out.println("marque : " + objects[1]);
			System.out.println("date Contrat : " + objects[2]);
			System.out.println("noContrat : " + objects[3]);
			System.out.println("");
		}
	}

}
