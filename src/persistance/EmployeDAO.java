package persistance;

import java.util.List;

import model.Employe;

/**
 * Interface EmployeDAO qui référence les opérations CRUD (Create, Read, Update
 * and Delete) de l'employé dans la base de données des employés.
 * 
 * @author Jean-Charles & Jérémi
 *
 */
public interface EmployeDAO {

	/**
	 * Méthode permettant de sauvegarder un employe e dans la base de données
	 * employés.
	 * 
	 * @param Employe e
	 */
	public void sauvegarderEmploye(Employe e);

	/**
	 * Méthode permettant d'obtenir un employe dans la base de données employés à
	 * partir de son id.
	 * 
	 * @param int id
	 */
	public Employe afficherEmployeParId(int id);

	/**
	 * Méthode permettant d'obtenir tous les employés de la base de données
	 * employés.
	 *
	 */
	public List<Employe> afficherTout();

	/**
	 * Méthode permettant de supprimer un employe de la base de données employés.
	 * 
	 * @param int id
	 */
	public void supprimerEmploye(int id);

}
