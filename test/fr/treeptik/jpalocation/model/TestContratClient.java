package fr.treeptik.jpalocation.model;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TestContratClient {

	private static EntityManager entityManager = Persistence.createEntityManagerFactory("location")
			.createEntityManager();

	// @Test
	// public void testSaveClient() {
	// Client client = new Client(null, "test", "Adresse Test", "TestVille");
	// entityManager.getTransaction().begin();
	//
	// entityManager.persist(client);
	//
	// TypedQuery<Client> query = entityManager.createQuery(
	// "SELECT cli FROM Client cli ORDER BY cli.nomClient", Client.class);
	//
	// List<Client> list = query.getResultList();
	// for (Client cli : list) {
	//
	// System.out.println("Client no : " + cli.getCodeClient());
	// System.out.println("Client nom : " + cli.getNomClient());
	// System.out.println("Client ville : " + cli.getVille());
	// System.out.println("Client Adresse : " + cli.getAdresse());
	// System.out.println("");
	// }
	//
	// }

	@Test
	public void testFindClient() {
		Client client = entityManager.find(Client.class, 1);
		System.out.println("Client no : " + client.getCodeClient());
		System.out.println("Client nom : " + client.getNomClient());
		System.out.println("Client ville : " + client.getVille());
		System.out.println("Client Adresse : " + client.getAdresse());
		// System.out.println("Contrat no : " + contrat.getNoContrat());
		// System.out.println("Contrat date contrat : " + contrat.getDateContrat());
		// System.out.println("Contrat date enlevement : " + contrat.getDateEnlevement());
		// System.out.println("Contrat date retour : " + contrat.getDateRetour());
		System.out.println("");

	}

	@Test
	public void testFindContrat() {
		Contrat contrat = entityManager.find(Contrat.class, 2);
		System.out.println("Client no : " + contrat.getClient().getCodeClient());
		System.out.println("Client nom : " + contrat.getClient().getNomClient());
		System.out.println("Client ville : " + contrat.getClient().getVille());
		System.out.println("Client Adresse : " + contrat.getClient().getAdresse());
		System.out.println("Contrat no : " + contrat.getNoContrat());
		System.out.println("Contrat date contrat : " + contrat.getDateContrat());
		System.out.println("Contrat date enlevement : " + contrat.getDateEnlevement());
		System.out.println("Contrat date retour : " + contrat.getDateRetour());
		System.out.println("");

	}

}
