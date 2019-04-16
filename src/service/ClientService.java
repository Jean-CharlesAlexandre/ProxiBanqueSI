package service;

import java.util.List;

import model.CB;
import model.Client;
import model.CompteCourant;
import model.CompteEpargne;

/**
 * Interface ClientService est composée des règles métiers pour le client et
 * joue le rôle d'intermédiaire entre l'utilisateur et la base de données des
 * clients.
 * 
 * @author Jean-Charles & Jérémi
 *
 */
public interface ClientService {

	/**
	 * Méthode appelant la sauvegarde d'un client dans la base de données clients.
	 * 
	 * @param Client c
	 */
	public void ajouterClient(Client c);

	/**
	 * Méthode appelant la demande d'un client dans la base de données clients.
	 * 
	 * @param int id
	 */
	public Client trouverClientValide(int id);

	/**
	 * Méthode appelant la demande de tous les client dans la base de données
	 * clients.
	 * 
	 */
	public List<Client> trouverToutClient();

	/**
	 * Méthode appelant la modification de l'adresse d'un client dans la base de
	 * données clients.
	 * 
	 * @param int id, String adresse
	 */
	public void modifierAdresseClient(int id, String adresse);

	/**
	 * Méthode appelant la modification du code postal d'un client dans la base de
	 * données clients.
	 * 
	 * @param int id, int codePostal
	 */
	public void modifierCodePostalClient(int id, int codePostal);

	/**
	 * Méthode appelant la modification de la ville d'un client dans la base de
	 * données clients.
	 * 
	 * @param int id, String ville
	 */
	public void modifierVilleClient(int id, String ville);

	/**
	 * Méthode appelant la modification du numéro de téléphone d'un client dans la
	 * base de données clients.
	 * 
	 * @param int id, String telephone
	 */
	public void modifierTelephoneClient(int id, String telephone);

	/**
	 * Méthode appelant la suppression d'un client dans la base de données clients.
	 * 
	 * @param int id
	 */
	public void supprimerClient(int id);

	/**
	 * Méthode permettant d'associer un compte epargne à un client.
	 * 
	 * @param CompteEpargne compteEpargne, Client c
	 */
	public void ajouterCompteEpargne(CompteEpargne compteEpargne, Client c);

	/**
	 * Méthode permettant d'associer un compte courant à un client.
	 * 
	 * @param CompteCourant compteCourant, Client c
	 */
	public void ajouterCompteCourant(CompteCourant compteCourant, Client c);

	/**
	 * Méthode permettant d'associer une carte bancaire à un client.
	 * 
	 * @param CB cb, Client c
	 */
	public void ajouterCarteBancaire(CB cb, Client c);
}
