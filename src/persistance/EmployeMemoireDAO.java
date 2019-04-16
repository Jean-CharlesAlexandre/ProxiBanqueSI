package persistance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Employe;

/**
 * Classe EmployeMemoireDAO qui implémente l'interface EmployeDAO. Cette classe
 * permet de sauvegarder, modifier, lire, supprimer les informations des
 * employés dans la base de données employés. Notre base de données employés est
 * assimilée à une HashMap.
 * 
 * @author Jean-Charles & Jérémi
 *
 */
public class EmployeMemoireDAO implements EmployeDAO {

	private static final Map<Integer, Employe> DBEmploye = new HashMap<>();
	private static Integer idEmploye = 0;

	/**
	 * Méthode permettant de sauvegarder un employe e dans la base de données
	 * employés. Un id employe est généré et incrémenté à chaque ajout et représente
	 * la clé de cet employé dans la HashMap.
	 * 
	 * @param Employe e
	 */
	@Override
	public void sauvegarderEmploye(Employe e) {
		e.setId(idEmploye);
		DBEmploye.put(idEmploye, e);
		idEmploye++;
	}

	/**
	 * Méthode retournant un employe de la base de données clients à partir de son
	 * id.
	 * 
	 * @param int id
	 */
	@Override
	public Employe afficherEmployeParId(int id) {
		return DBEmploye.get(id);
	}

	/**
	 * Méthode retournant la liste de tous les clients dans la base de données
	 * clients.
	 * 
	 */
	@Override
	public List<Employe> afficherTout() {
		return new ArrayList<>(DBEmploye.values());
	}

	/**
	 * Méthode permettant de supprimer un employe dans la base de données employés à
	 * partir de son id.
	 * 
	 * @param int id
	 */
	@Override
	public void supprimerEmploye(int id) {
		DBEmploye.remove(id);
	}

}
