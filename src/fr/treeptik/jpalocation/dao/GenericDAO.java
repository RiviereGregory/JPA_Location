package fr.treeptik.jpalocation.dao;

import java.util.List;

// <T> permet de definir le nom du template(type Generique)
// T type generique
// E enumeration
// PK pour des clef
public interface GenericDAO<T, PK> {

	T save(T entite);

	void remove(T entite);

	T findById(PK id);

	List<T> findAll();

}
