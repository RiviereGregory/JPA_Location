package fr.treeptik.jpalocation.dao.impl;

import fr.treeptik.jpalocation.dao.ClientDAO;
import fr.treeptik.jpalocation.model.Client;

public class ClientDAOJPA extends GenericDAOJPA<Client, Integer> implements ClientDAO {

	// Definition du constructeur Obligatoire
	public ClientDAOJPA() {
		super(Client.class);
	}

}
