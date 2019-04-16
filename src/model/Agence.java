package model;

import java.util.List;

/**
 * Classe Agence caractérisée par un id et une date de création et composée d'un
 * seul gérant et de plusieurs conseillers.
 * 
 * @author Jean-Charles & Jérémi
 *
 */
public class Agence {

	// Attributs
	private String id;
	private String dateCreation;
	private Gerant gerant;
	private List<Conseiller> listeConseiller;

	// Constructeur
	public Agence(String id, String dateCreation) {
		this.id = id;
		this.dateCreation = dateCreation;
	}

	// Getters et setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Gerant getGerant() {
		return gerant;
	}

	public void setGerant(Gerant gerant) {
		this.gerant = gerant;
	}

	public List<Conseiller> getListeConseiller() {
		return listeConseiller;
	}

	public void setListeConseiller(List<Conseiller> listeConseiller) {
		this.listeConseiller = listeConseiller;
	}

}
