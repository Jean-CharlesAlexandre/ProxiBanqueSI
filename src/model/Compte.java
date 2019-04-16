package model;

/**
 * Classe Compte caractérisée par un numéro de compte, un solde et une date
 * d'ouverture.
 * 
 * @author Jean-Charles & Jérémi
 *
 */
public class Compte {

	// Attributs
	private long numeroCompte;
	private double solde;
	private String dateOuverture;

	// Constructeur
	public Compte(double solde, String dateOuverture) {
		setSolde(solde);
		this.dateOuverture = dateOuverture;
	}

	// Getters et setters
	public long getNumeroCompte() {
		return numeroCompte;
	}

	public void setNumeroCompte(long numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	public double getSolde() {
		return solde;
	}

	/**
	 * Impossible d'attribuer un solde de compte dans le négatif
	 */
	public void setSolde(double solde) {
		this.solde = solde;
	}

	public String getDateOuverture() {
		return dateOuverture;
	}

	public void setDateOuverture(String dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

}
