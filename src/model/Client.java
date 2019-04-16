package model;

/**
 * Classe Client caractérisée par un id, un nom, une adresse, un code postal,
 * une ville, un téléphone. Il possède obligatiorement un compte courant et peut
 * possèder un compte épargne et une carte bancaire.
 * 
 * @author Jean-Charles & Jérémi
 *
 */
public class Client {

//	Attributs
	private int id;
	private String nom;
	private String adresse;
	private int codePostal;
	private String ville;
	private String telephone;
	private CompteCourant compteCourant;
	private CompteEpargne compteEpargne;
	private CB carteBancaire;

//	Constructeur
	public Client(String nom, String adresse, int codePostal, String ville, String telephone) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
	}

//	Getters et setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public CompteCourant getCompteCourant() {
		return compteCourant;
	}

	public void setCompteCourant(CompteCourant compteCourant) {
		this.compteCourant = compteCourant;
	}

	public CompteEpargne getCompteEpargne() {
		return compteEpargne;
	}

	public void setCompteEpargne(CompteEpargne compteEpargne) {
		this.compteEpargne = compteEpargne;
	}

	public CB getCarteBancaire() {
		return carteBancaire;
	}

	public void setCarteBancaire(CB carteBancaire) {
		this.carteBancaire = carteBancaire;
	}

}
