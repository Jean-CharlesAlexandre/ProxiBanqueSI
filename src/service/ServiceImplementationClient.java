package service;

import java.util.List;

import model.CB;
import model.Client;
import model.CompteCourant;
import model.CompteEpargne;
import persistance.ClientDAO;
import persistance.ClientMemoireDAO;

/**
 * Classe ServiceImplementationClient qui implémente l'interface ClientService.
 * Elle est composée des règles métiers pour le client et joue le rôle
 * d'intermédiaire entre l'utilisateur et la base de données des clients.
 * 
 * @author Jean-Charles & Jérémi
 *
 */
public class ServiceImplementationClient implements ClientService {

	private ClientDAO daoClient = new ClientMemoireDAO();

	/**
	 * Méthode appelant la sauvegarde d'un client dans la base de données clients.
	 * Les numéros de compte (courant, épargne) et le numéro de carte bancaire sont
	 * générés à condition que le client possède ces comptes et une carte bancaire.
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
	 * Méthode appelant la demande d'un client dans la base de données clients.
	 * 
	 * @param int id
	 */
	public Client trouverClientValide(int id) {
		return daoClient.afficherClientParId(id);
	}

	/**
	 * Méthode appelant la demande de tous les client dans la base de données
	 * clients.
	 * 
	 */
	public List<Client> trouverToutClient() {
		return daoClient.afficherTout();
	}

	/**
	 * Méthode appelant la modification de l'adresse d'un client dans la base de
	 * données clients.
	 * 
	 * @param int id, String adresse
	 */
	public void modifierAdresseClient(int id, String adresse) {
		daoClient.modifierAdresseClientParId(id, adresse);
	}

	/**
	 * Méthode appelant la modification du code postal d'un client dans la base de
	 * données clients.
	 * 
	 * @param int id, int codePostal
	 */
	public void modifierCodePostalClient(int id, int codePostal) {
		daoClient.modifierCodePostalClientParId(id, codePostal);
	}

	/**
	 * Méthode appelant la modification de la ville d'un client dans la base de
	 * données clients.
	 * 
	 * @param int id, String ville
	 */
	public void modifierVilleClient(int id, String ville) {
		daoClient.modifierVilleClientParId(id, ville);
	}

	/**
	 * Méthode appelant la modification du numéro de téléphone d'un client dans la
	 * base de données clients.
	 * 
	 * @param int id, String telephone
	 */
	public void modifierTelephoneClient(int id, String telephone) {
		daoClient.modifierTelephoneClientParId(id, telephone);
	}

	/**
	 * Méthode appelant la suppression d'un client dans la base de données clients.
	 * La méthode affiche également les comptes et cartes bancaires associées au
	 * client qui sont supprimées.
	 * 
	 * @param int id
	 */
	public void supprimerClient(int id) {
		Client c = daoClient.afficherClientParId(id);

		System.out.println("Le client " + c.getNom() + " a été supprimé");
		System.out.println("Le compte courant numéro " + c.getCompteEpargne().getNumeroCompte() + "du client "
				+ c.getNom() + " a bien été supprimé");

		if (c.getCompteEpargne() != null) {
			System.out.println("Le compte épargne numéro " + c.getCompteEpargne().getNumeroCompte() + "du client "
					+ c.getNom() + " a bien été supprimé");
		}

		if (c.getCarteBancaire() != null) {
			System.out.println("La carte bancaire numéro " + c.getCarteBancaire().getNumeroCarte() + "du client "
					+ c.getNom() + " a bien été supprimé");
		}
		daoClient.supprimerClientParId(id);
	}

	/**
	 * Méthode permettant d'associer un compte courant à un client.
	 * 
	 * @param CompteCourant compteCourant, Client c
	 */
	public void ajouterCompteCourant(CompteCourant compteCourant, Client c) {
		if (c.getCompteCourant() != null) {
			c.getCompteCourant().setNumeroCompte(genereNumeroCompte());
		}
	}

	/**
	 * Méthode permettant d'associer un compte epargne à un client.
	 * 
	 * @param CompteEpargne compteEpargne, Client c
	 */
	public void ajouterCompteEpargne(CompteEpargne compteEpargne, Client c) {
		if (c.getCompteEpargne() != null) {
			c.getCompteEpargne().setNumeroCompte(genereNumeroCompte());
		}
	}

	/**
	 * Méthode permettant d'associer une carte bancaire à un client.
	 * 
	 * @param CB cb, Client c
	 */
	public void ajouterCarteBancaire(CB cb, Client c) {
		if (c.getCarteBancaire() != null) {
			c.getCarteBancaire().setNumeroCarte(genereNumeroCarte());
		}
	}

	/**
	 * Méthode générant un numéro de compte à 11 chiffres.
	 * 
	 */
	private long genereNumeroCompte() {
		return (long) ((1 + Math.random()) * 10000000000L);
	}

	/**
	 * Méthode générant un numéro de carte à 16 chiffres.
	 * 
	 */
	private long genereNumeroCarte() {
		return (long) ((1 + Math.random()) * 1000000000000000L);
	}

}
