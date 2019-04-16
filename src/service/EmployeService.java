package service;

import java.util.List;

import model.Agence;
import model.Client;
import model.Employe;

/**
 * Interface EmployeService est composée des règles métiers pour l'employé et
 * représente l'intermédiaire entre l'utilisateur et la base de données des
 * clients/employés. Cette interface comprend les méthodes permettant de faire
 * des virements d'un compte courant à épargne et inversement ainsi que les
 * virements d'un client à un autre (compte courant à compte courant). La
 * méthode relative à l'audit d'une agence est également comprise dans cette
 * interface.
 * 
 * @author Jean-Charles & Jérémi
 *
 */
public interface EmployeService {

	/**
	 * Méthode appelant la sauvegarde d'un employé dans la base de données employés.
	 * 
	 * @param Employe e
	 */
	public void ajouterEmploye(Employe e);

	/**
	 * Méthode appelant la demande d'un employé dans la base de données employés.
	 * 
	 * @param int id
	 */
	public Employe trouverEmploye(int id);

	/**
	 * Méthode appelant la demande de tous les employés dans la base de données
	 * employés.
	 * 
	 */
	public List<Employe> trouverToutEmploye();

	/**
	 * Méthode appelant la suppression d'un employé dans la base de données
	 * employés.
	 * 
	 * @param int id
	 */
	public void supprimerEmploye(int id);

	/**
	 * Méthode permettant de réaliser le virement d'un client c d'un montant de
	 * montantVirement depuis le compte courant jusqu'au compte épargne.
	 * 
	 * @param Client c, double montantVirement
	 */
	public void virementCourantAEpargne(Client c, double montantVirement);

	/**
	 * Méthode permettant de réaliser le virement d'un client c d'un montant de
	 * montantVirement depuis le compte épargne jusqu'au compte courant.
	 * 
	 * @param Client c, double montantVirement
	 */
	public void virementEpargneACourant(Client c, double montantVirement);

	/**
	 * Méthode permettant de réaliser le virement d'un compte courant d'un client c1
	 * vers le compte courant d'un client c2 d'un montant de montantVirement.
	 * 
	 * @param Client c1, Client c2, double montantVirement
	 */
	public void virementClientAClient(Client c1, Client c2, double montantVirement);

	/**
	 * Méthode permettant de réaliser l'audit d'une agence
	 * 
	 * @param Agence agence
	 */
	public boolean audit(Agence agence);
}
