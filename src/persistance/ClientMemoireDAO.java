package persistance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Client;

/**
 * Classe ClientMemoireDAO qui implémente l'interface ClientDAO. Cette classe
 * permet de sauvegarder, modifier, lire, supprimer les informations des clients
 * dans la base de données clients. Notre base de données clients est assimilée
 * à une HashMap.
 * 
 * @author Jean-Charles & Jérémi
 *
 */
public class ClientMemoireDAO implements ClientDAO {

	private static final Map<Integer, Client> DBClient = new HashMap<>();
	private static Integer idClient = 1;

	// Partie client

	/**
	 * Méthode permettant de sauvegarder un client c dans la base de données
	 * clients. Un id client est généré et incrémenté à chaque ajout et représente
	 * la clé de ce client dans la HashMap.
	 * 
	 * @param Client c
	 */
	@Override
	public void sauvegarderClient(Client c) {
		c.setId(idClient);
		DBClient.put(idClient, c);
		idClient++;
	}

	/**
	 * Méthode retournant un client de la base de données clients à partir de son
	 * id.
	 * 
	 * @param int id
	 */
	@Override
	public Client afficherClientParId(int id) {
		return DBClient.get(id);
	}

	/**
	 * Méthode retournant la liste de tous les clients dans la base de données
	 * clients.
	 * 
	 */
	@Override
	public List<Client> afficherTout() {
		return new ArrayList<>(DBClient.values());
	}

	/**
	 * Méthode permettant de modifier l'adresse d'un client dans la base de données
	 * clients à partir de son id.
	 * 
	 * @param int id, String adresse
	 */
	@Override
	public void modifierAdresseClientParId(int id, String adresse) {
		DBClient.get(id).setAdresse(adresse);
	}

	/**
	 * Méthode permettant de modifier le code postal d'un client dans la base de
	 * données clients à partir de son id.
	 * 
	 * @param int id, int codePostal
	 */
	@Override
	public void modifierCodePostalClientParId(int id, int codePostal) {
		DBClient.get(id).setCodePostal(codePostal);
	}

	/**
	 * Méthode permettant de modifier la ville d'un client dans la base de données
	 * clients à partir de son id.
	 * 
	 * @param int id, String ville
	 */
	@Override
	public void modifierVilleClientParId(int id, String ville) {
		DBClient.get(id).setVille(ville);
	}

	/**
	 * Méthode permettant de modifier le téléphone d'un client dans la base de
	 * données clients à partir de son id.
	 * 
	 * @param int id, String telephone
	 */
	@Override
	public void modifierTelephoneClientParId(int id, String telephone) {
		DBClient.get(id).setTelephone(telephone);
	}

	/**
	 * Méthode permettant de supprimer un client dans la base de données clients à
	 * partir de son id.
	 * 
	 * @param int id
	 */
	@Override
	public void supprimerClientParId(int id) {
		DBClient.remove(id);
	}
}
