package fr.treeptik.jpalocation.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import fr.treeptik.jpalocation.dao.GenericDAO;

public class GenericDAOJPA<T, PK> implements GenericDAO<T, PK> {
	// Il manque toute les exception, les injections....

	// On le fait comme cela en attendent de faire avec l'injection spring
	private static EntityManager entityManager = Persistence.createEntityManagerFactory("location")
			.createEntityManager();

	private Class<T> type;

	// Pour obliger a initialiser la variable type car on a pas de constructeur par defaut
	public GenericDAOJPA(Class<T> type) {
		this.type = type;
	}

	@Override
	public T save(T entite) {
		entityManager.persist(entite);
		return entite;
	}

	@Override
	public void remove(T entite) {
		entityManager.remove(entite);
	}

	@Override
	public T findById(PK id) {
		return entityManager.find(type, id);
	}

	@Override
	public List<T> findAll() {
		return entityManager.createQuery("SELECT o FROM " + type.getSimpleName() + " o", type)
				.getResultList();
	}
}
