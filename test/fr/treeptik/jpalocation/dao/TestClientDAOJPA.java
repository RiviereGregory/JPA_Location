package fr.treeptik.jpalocation.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import fr.treeptik.jpalocation.dao.impl.ClientDAOJPA;
import fr.treeptik.jpalocation.model.Client;

@RunWith(JUnit4.class)
public class TestClientDAOJPA {

	@Test
	public void testSaveClient() {
		ClientDAO clientDAO = new ClientDAOJPA();

		Client client = new Client(null, "NomDAO", "AdresseDAO", "VilleDAO");

		clientDAO.save(client);

	}

}
