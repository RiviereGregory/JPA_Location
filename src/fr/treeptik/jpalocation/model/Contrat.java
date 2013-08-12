package fr.treeptik.jpalocation.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Contrat")
public class Contrat implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "nocontrat")
	private Integer noContrat;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_contrat")
	private Date dateContrat;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_enlevement")
	private Date dateEnlevement;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_retour")
	private Date dateRetour;

	@ManyToOne
	@JoinColumn(name = "codecl")
	private Client client;

	@ManyToOne
	@JoinColumn(name = "noimmatriculation")
	private Voiture voiture;

	@ManyToMany
	@JoinTable(name = "Prevoir", joinColumns = @JoinColumn(name = "nocontrat"), inverseJoinColumns = @JoinColumn(name = "codesuplement"))
	private List<Suplements> suplements;

	public Contrat() {
	}

	public Contrat(Integer noContrat, Date dateContrat, Date dateEnlevement, Date dateRetour,
			Client client, Voiture voiture, List<Suplements> suplements) {
		super();
		this.noContrat = noContrat;
		this.dateContrat = dateContrat;
		this.dateEnlevement = dateEnlevement;
		this.dateRetour = dateRetour;
		this.client = client;
		this.voiture = voiture;
		this.suplements = suplements;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((noContrat == null) ? 0 : noContrat.hashCode());
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
		Contrat other = (Contrat) obj;
		if (noContrat == null) {
			if (other.noContrat != null)
				return false;
		} else if (!noContrat.equals(other.noContrat))
			return false;
		return true;
	}

	public Date getDateContrat() {
		return dateContrat;
	}

	public void setDateContrat(Date dateContrat) {
		this.dateContrat = dateContrat;
	}

	public Date getDateEnlevement() {
		return dateEnlevement;
	}

	public void setDateEnlevement(Date dateEnlevement) {
		this.dateEnlevement = dateEnlevement;
	}

	public Date getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Voiture getVoiture() {
		return voiture;
	}

	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}

	public Integer getNoContrat() {
		return noContrat;
	}

	public void setNoContrat(Integer noContrat) {
		this.noContrat = noContrat;
	}

	public List<Suplements> getSuplements() {
		return suplements;
	}

	public void setSuplements(List<Suplements> suplements) {
		this.suplements = suplements;
	}

}
