package service;

import java.util.List;

import model.CB;
import model.Client;
import model.CompteCourant;
import model.CompteEpargne;
import persistance.ClientDAO;
import persistance.ClientMemoireDAO;

/**
 * Classe ServiceImplementationClient qui impl�mente l'interface ClientService.
 * Elle est compos�e des r�gles m�tiers pour le client et joue le r�le
 * d'interm�diaire entre l'utilisateur et la base de donn�es des clients.
 * 
 * @author Jean-Charles & J�r�mi
 *
 */
public class ServiceImplementationClient implements ClientService {

	private ClientDAO daoClient = new ClientMemoireDAO();

	/**
	 * M�thode appelant la sauvegarde d'un client dans la base de donn�es clients.
	 * Les num�ros de compte (courant, �pargne) et le num�ro de carte bancaire sont
	 * g�n�r�s � condition que le client poss�de ces comptes et une carte bancaire.
	 * 
	 * @param Client c
	 */
	public void ajouterClient(Client c) {
		if (c != null) {
			// Sauvegarde le client dans DAO
			daoClient.sauvegarderClient(c);
			// Genere le numero de compte courant du client
			if (c.getCompteCourant() != null) {
				c.getCompteCourant().setNumeroCompte(genereNumeroCompte());
			}

			// Genere le numero de compte epargne du client
			if (c.getCompteEpargne() != null) {
				c.getCompteEpargne().setNumeroCompte(genereNumeroCompte());
			}

			// Genere numero de carte du client
			if (c.getCarteBancaire() != null) {
				c.getCarteBancaire().setNumeroCarte(genereNumeroCarte());
			}
		}
	}

	/**
	 * M�thode appelant la demande d'un client dans la base de donn�es clients.
	 * 
	 * @param int id
	 */
	public Client trouverClientValide(int id) {
		return daoClient.afficherClientParId(id);
	}

	/**
	 * M�thode appelant la demande de tous les client dans la base de donn�es
	 * clients.
	 * 
	 */
	public List<Client> trouverToutClient() {
		return daoClient.afficherTout();
	}

	/**
	 * M�thode appelant la modification de l'adresse d'un client dans la base de
	 * donn�es clients.
	 * 
	 * @param int id, String adresse
	 */
	public void modifierAdresseClient(int id, String adresse) {
		daoClient.modifierAdresseClientParId(id, adresse);
	}

	/**
	 * M�thode appelant la modification du code postal d'un client dans la base de
	 * donn�es clients.
	 * 
	 * @param int id, int codePostal
	 */
	public void modifierCodePostalClient(int id, int codePostal) {
		daoClient.modifierCodePostalClientParId(id, codePostal);
	}

	/**
	 * M�thode appelant la modification de la ville d'un client dans la base de
	 * donn�es clients.
	 * 
	 * @param int id, String ville
	 */
	public void modifierVilleClient(int id, String ville) {
		daoClient.modifierVilleClientParId(id, ville);
	}

	/**
	 * M�thode appelant la modification du num�ro de t�l�phone d'un client dans la
	 * base de donn�es clients.
	 * 
	 * @param int id, String telephone
	 */
	public void modifierTelephoneClient(int id, String telephone) {
		daoClient.modifierTelephoneClientParId(id, telephone);
	}

	/**
	 * M�thode appelant la suppression d'un client dans la base de donn�es clients.
	 * La m�thode affiche �galement les comptes et cartes bancaires associ�es au
	 * client qui sont supprim�es.
	 * 
	 * @param int id
	 */
	public void supprimerClient(int id) {
		Client c = daoClient.afficherClientParId(id);

		System.out.println("Le client " + c.getNom() + " a �t� supprim�");
		System.out.println("Le compte courant num�ro " + c.getCompteEpargne().getNumeroCompte() + "du client "
				+ c.getNom() + " a bien �t� supprim�");

		if (c.getCompteEpargne() != null) {
			System.out.println("Le compte �pargne num�ro " + c.getCompteEpargne().getNumeroCompte() + "du client "
					+ c.getNom() + " a bien �t� supprim�");
		}

		if (c.getCarteBancaire() != null) {
			System.out.println("La carte bancaire num�ro " + c.getCarteBancaire().getNumeroCarte() + "du client "
					+ c.getNom() + " a bien �t� supprim�");
		}
		daoClient.supprimerClientParId(id);
	}

	/**
	 * M�thode permettant d'associer un compte courant � un client.
	 * 
	 * @param CompteCourant compteCourant, Client c
	 */
	public void ajouterCompteCourant(CompteCourant compteCourant, Client c) {
		if (c.getCompteCourant() != null) {
			c.getCompteCourant().setNumeroCompte(genereNumeroCompte());
		}
	}

	/**
	 * M�thode permettant d'associer un compte epargne � un client.
	 * 
	 * @param CompteEpargne compteEpargne, Client c
	 */
	public void ajouterCompteEpargne(CompteEpargne compteEpargne, Client c) {
		if (c.getCompteEpargne() != null) {
			c.getCompteEpargne().setNumeroCompte(genereNumeroCompte());
		}
	}

	/**
	 * M�thode permettant d'associer une carte bancaire � un client.
	 * 
	 * @param CB cb, Client c
	 */
	public void ajouterCarteBancaire(CB cb, Client c) {
		if (c.getCarteBancaire() != null) {
			c.getCarteBancaire().setNumeroCarte(genereNumeroCarte());
		}
	}

	/**
	 * M�thode g�n�rant un num�ro de compte � 11 chiffres.
	 * 
	 */
	private long genereNumeroCompte() {
		return (long) ((1 + Math.random()) * 10000000000L);
	}

	/**
	 * M�thode g�n�rant un num�ro de carte � 16 chiffres.
	 * 
	 */
	private long genereNumeroCarte() {
		return (long) ((1 + Math.random()) * 1000000000000000L);
	}

}
