package persistance;

import java.util.List;

import model.Client;

/**
 * Interface ClientDAO qui référence les opérations CRUD (Create, Read, Update
 * and Delete) du client dans la base de données clients.
 * 
 * @author Jean-Charles & Jérémi
 *
 */
public interface ClientDAO {

	/**
	 * Méthode permettant de sauvegarder un client c dans la base de données
	 * clients.
	 * 
	 * @param Client c
	 */
	public void sauvegarderClient(Client c);

	/**
	 * Méthode permettant d'obtenir un client dans la base de données clients à
	 * partir de son id.
	 * 
	 * @param int id
	 */
	public Client afficherClientParId(int id);

	/**
	 * Méthode permettant d'obtenir la liste de tous les clients de la base de
	 * données clients.
	 * 
	 */
	public List<Client> afficherTout();

	/**
	 * Méthode permettant de modifier l'adresse d'un client dans la base de données
	 * clients à partir de son id.
	 * 
	 * @param int id, String adresse
	 */
	public void modifierAdresseClientParId(int id, String adresse);

	/**
	 * Méthode permettant de modifier le code postal d'un client dans la base de
	 * données clients à partir de son id.
	 * 
	 * @param int id, int codePostal
	 */
	public void modifierCodePostalClientParId(int id, int codePostal);

	/**
	 * Méthode permettant de modifier la ville d'un client dans la base de données
	 * clients à partir de son id.
	 * 
	 * @param int id, String ville
	 */
	public void modifierVilleClientParId(int id, String ville);

	/**
	 * Méthode permettant de modifier le téléphone d'un client dans la base de
	 * données clients à partir de son id.
	 * 
	 * @param int id, String telephone
	 */
	public void modifierTelephoneClientParId(int id, String telephone);

	/**
	 * Méthode permettant de supprimer un client de la base de données clients à
	 * partir de son id.
	 * 
	 * @param int id
	 */
	public void supprimerClientParId(int id);

}
