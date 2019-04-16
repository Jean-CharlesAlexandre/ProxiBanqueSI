package model;

/**
 * Classe Particulier caractérisée par un prénom et qui hérite de la classe
 * Client.
 * 
 * @author Jean-Charles & Jérémi
 *
 */
public class Particulier extends Client {

//	Attribut
	private String prenom;

//	Constructeur
	public Particulier(String nom, String prenom, String adresse, int codePostal, String ville, String telephone) {
		super(nom, adresse, codePostal, ville, telephone);
		this.prenom = prenom;
	}

//	Getter et setter
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return "Particulier : " + getNom() + ", " + getPrenom() + "\n" + "Adresse :" + getAdresse() + ", "
				+ getCodePostal() + ", " + getVille() + "\n" + "Téléphone : " + getTelephone() + "\n"
				+ "Informations compte courant : " + getCompteCourant() + "\n" + "Carte bancaire : "
				+ getCarteBancaire() + "\n" + "Informations compte épargne : " + getCompteEpargne() + "\n";
	}

}
