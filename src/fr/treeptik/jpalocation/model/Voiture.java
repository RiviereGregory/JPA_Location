package fr.treeptik.jpalocation.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Voiture")
public class Voiture implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "noimmatriculation")
	private Integer noImmatriculation;

	@Column(name = "marque")
	private String marque;

	@Column(name = "modele")
	private String modele;

	@Column(name = "couleur")
	private String couleur;

	@Column(name = "cumul_reparation")
	private Integer cumulReparation;

	@Column(name = "disponible")
	private Boolean disponible;

	@ManyToOne
	@JoinColumn(name = "code_type")
	private TypeVoiture typeVoiture;

	// Permet de créer une table a partir des collections sans avoir besoin de créer une class avec
	// id
	@ElementCollection
	@CollectionTable(name = "Option_voiture")
	@Column(name = "opt")
	private List<String> option;

	public Voiture() {
	}

	public Voiture(Integer noImmatriculation, String marque, String modele, String couleur,
			Integer cumulReparation, Boolean disponible, TypeVoiture typeVoiture,
			List<String> option) {
		super();
		this.noImmatriculation = noImmatriculation;
		this.marque = marque;
		this.modele = modele;
		this.couleur = couleur;
		this.cumulReparation = cumulReparation;
		this.disponible = disponible;
		this.typeVoiture = typeVoiture;
		this.option = option;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((noImmatriculation == null) ? 0 : noImmatriculation.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voiture other = (Voiture) obj;
		if (noImmatriculation == null) {
			if (other.noImmatriculation != null)
				return false;
		} else if (!noImmatriculation.equals(other.noImmatriculation))
			return false;
		return true;
	}

	public List<String> getOption() {
		return option;
	}

	public void setOption(List<String> option) {
		this.option = option;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public Integer getCumulReparation() {
		return cumulReparation;
	}

	public void setCumulReparation(Integer cumulReparation) {
		this.cumulReparation = cumulReparation;
	}

	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}

	public Integer getNoImmatriculation() {
		return noImmatriculation;
	}

	public void setNoImmatriculation(Integer noImmatriculation) {
		this.noImmatriculation = noImmatriculation;
	}

	public TypeVoiture getTypeVoiture() {
		return typeVoiture;
	}

	public void setTypeVoiture(TypeVoiture typeVoiture) {
		this.typeVoiture = typeVoiture;
	}

}
