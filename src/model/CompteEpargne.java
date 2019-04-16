package model;

/**
 * Classe CompteEpargne caractérisée par un taux de rémunération qui hérite de
 * la classe Compte.
 * 
 * @author Jean-Charles & Jérémi
 *
 */
public class CompteEpargne extends Compte {

//	Attribut
	private int TAUXREMUNERATION = 3;

//	Constructeur
	public CompteEpargne(double solde, String dateOuverture) {
		super(solde, dateOuverture);
	}

//	Getter et setter
	public int getTAUXREMUNERATION() {
		return TAUXREMUNERATION;
	}

	public void setTAUXREMUNERATION(int tAUXREMUNERATION) {
		TAUXREMUNERATION = tAUXREMUNERATION;
	}

	@Override
	public String toString() {
		return "numéro de compte : " + getNumeroCompte() + ", épargne : " + getSolde() + "€" + ", date d'ouverture : "
				+ getDateOuverture();
	}

}
