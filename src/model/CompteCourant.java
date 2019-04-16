package model;

/**
 * Classe CompteCourant caractérisée par une autorisation de découvert et qui
 * hérite de la classe Compte.
 * 
 * @author Jean-Charles & Jérémi
 *
 */
public class CompteCourant extends Compte {

//	Attribut
	private int AUTORISATIONDECOUVERT = 1000;

//	Constructeur
	public CompteCourant(double solde, String dateOuverture) {
		super(solde, dateOuverture);
	}

//	Getter et setter
	public int getAUTORISATIONDECOUVERT() {
		return AUTORISATIONDECOUVERT;
	}

	public void setAUTORISATIONDECOUVERT(int aUTORISATIONDECOUVERT) {
		AUTORISATIONDECOUVERT = aUTORISATIONDECOUVERT;
	}

	@Override
	public String toString() {
		return "numéro de compte : " + getNumeroCompte() + ", solde : " + getSolde() + "€" + ", date d'ouverture : "
				+ getDateOuverture();
	}

}
