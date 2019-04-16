package service;

import java.util.List;

import model.Agence;
import model.Client;
import model.Conseiller;
import model.Employe;
import model.Entreprise;
import model.Particulier;
import persistance.EmployeDAO;
import persistance.EmployeMemoireDAO;

/**
 * Classe ServiceImplementationEmploye qui implémente l'interface
 * EmployeService. Elle est composée des règles métiers pour l'employe et joue
 * le rôle d'intermédiaire entre l'utilisateur et la base de données des
 * clients/employés. Cette classe est également composé des règles métiers pour
 * réaliser des virements de compte à compte ainsi que pour réaliser un audit
 * sur une agence.
 * 
 * @author Jean-Charles & Jérémi
 *
 */
public class ServiceImplementationEmploye implements EmployeService {

	private EmployeDAO daoEmploye = new EmployeMemoireDAO();

	/**
	 * Méthode appelant la sauvegarde d'un employé dans la base de données employés.
	 * 
	 * @param Employe e
	 */
	@Override
	public void ajouterEmploye(Employe e) {
		if (e != null) {
			daoEmploye.sauvegarderEmploye(e);
		}
	}

	/**
	 * Méthode appelant la demande d'un employé dans la base de données employés.
	 * 
	 * @param int id
	 */
	@Override
	public Employe trouverEmploye(int id) {
		return daoEmploye.afficherEmployeParId(id);
	}

	/**
	 * Méthode appelant la demande de tous les employés dans la base de données
	 * employés.
	 * 
	 */
	@Override
	public List<Employe> trouverToutEmploye() {
		return daoEmploye.afficherTout();
	}

	/**
	 * Méthode appelant la suppression d'un employé dans la base de données
	 * employés.
	 * 
	 * @param int id
	 */
	@Override
	public void supprimerEmploye(int id) {
		daoEmploye.supprimerEmploye(id);
	}

	/**
	 * Méthode permettant d'associer un client à un conseiller. Le client n'est pas
	 * associé au conseiller si le conseiller possède déjà 10 clients.
	 * 
	 * @param Client client, Conseiller conseiller
	 */
	public void associerClientAConseiller(Client client, Conseiller conseiller) {
		if (conseiller.getListeClient().size() < 10) {
			conseiller.getListeClient().add(client);
		}
		if (conseiller.getListeClient().size() == 10) {
			System.out.println("Ce conseiller a déjà 10 clients !");
		}
	}

	/**
	 * Méthode permettant de réaliser le virement d'un client c d'un montant de
	 * montantVirement depuis le compte courant jusqu'au compte épargne. Le virement
	 * n'est realisé uniquement si le montant du virement est supérieur ou égal à 0,
	 * ainsi que si le montant du virement est inférieur ou égal au solde du compte
	 * potentiellement débité.
	 * 
	 * @param Client c, double montantVirement
	 */
	public void virementCourantAEpargne(Client c, double montantVirement) {
		if (c.getCompteEpargne() != null) {
			if (montantVirement <= 0) {
				System.out.println("Montant négatif, virement impossible");
			} else {
				if (montantVirement > c.getCompteCourant().getSolde()) {
					System.out.println("Montant du virement supérieur au solde du compte courant, virement impossible");
				} else {
					double soldeCompteCourant = c.getCompteCourant().getSolde();
					soldeCompteCourant -= montantVirement;
					c.getCompteCourant().setSolde(soldeCompteCourant);

					double soldeCompteEpargne = c.getCompteEpargne().getSolde();
					soldeCompteEpargne += montantVirement;
					c.getCompteEpargne().setSolde(soldeCompteEpargne);
					System.out.println("Virement du client " + c.getNom()
							+ " du compte courant à son compte épargne d'un montant de " + montantVirement + " €");
					System.out.println("Nouveau solde compte courant : " + soldeCompteCourant + " €" + "\n"
							+ "Nouveau solde compte épargne : " + soldeCompteEpargne + " €");
				}
			}

		} else {
			System.out.println("Vous n'avez pas de compte épargne, impossible de faire un virement compte à compte !");
		}
	}

	/**
	 * Méthode permettant de réaliser le virement d'un client c d'un montant de
	 * montantVirement depuis le compte épargne jusqu'au compte courant. Le virement
	 * n'est realisé uniquement si le montant du virement est supérieur ou égal à 0,
	 * ainsi que si le montant du virement est inférieur ou égal au solde du compte
	 * potentiellement débité.
	 * 
	 * @param Client c, double montantVirement
	 */
	public void virementEpargneACourant(Client c, double montantVirement) {
		if (c.getCompteEpargne() != null) {
			if (montantVirement <= 0) {
				System.out.println("Montant négatif, virement impossible");
			} else {
				if (montantVirement > c.getCompteEpargne().getSolde()) {
					System.out.println("Montant du virement supérieur au solde du compte épargne, virement impossible");
				} else {
					double soldeCompteEpargne = c.getCompteEpargne().getSolde();
					soldeCompteEpargne -= montantVirement;
					c.getCompteEpargne().setSolde(soldeCompteEpargne);

					double soldeCompteCourant = c.getCompteCourant().getSolde();
					soldeCompteCourant += montantVirement;
					c.getCompteCourant().setSolde(soldeCompteCourant);

					System.out.println("Virement du client " + c.getNom()
							+ " du compte épargne à son compte courant d'un montant de " + montantVirement + " €");
					System.out.println("Nouveau solde compte courant : " + soldeCompteCourant + " €" + "\n"
							+ "Nouveau solde compte épargne : " + soldeCompteEpargne + " €");
				}
			}

		} else {
			System.out.println("Vous n'avez pas de compte épargne, impossible de faire un virement compte à compte !");
		}
	}

	/**
	 * Méthode permettant de réaliser le virement d'un compte courant d'un client c1
	 * à un compte courant d'un client c2. Le virement n'est realisé uniquement si
	 * le montant du virement est supérieur ou égal à 0, ainsi que si le montant du
	 * virement est inférieur ou égal au solde du compte potentiellement débité.
	 * 
	 * @param Client c, double montantVirement
	 */
	public void virementClientAClient(Client c1, Client c2, double montantVirement) {
		if (montantVirement <= 0) {
			System.out.println("Montant négatif, virement impossible");
		} else {
			if (montantVirement > c1.getCompteCourant().getSolde()) {
				System.out.println("Montant du virement supérieur au solde du compte courant, virement impossible");
			} else {
				double soldeCompteCourantC1 = c1.getCompteCourant().getSolde();
				double soldeCompteCourantC2 = c2.getCompteCourant().getSolde();

				soldeCompteCourantC1 -= montantVirement;
				c1.getCompteCourant().setSolde(soldeCompteCourantC1);

				soldeCompteCourantC2 += montantVirement;
				c2.getCompteCourant().setSolde(soldeCompteCourantC2);

				System.out.println("Virement du client " + c1.getNom() + " au client " + c2.getNom()
						+ " d'un montant de " + montantVirement + " €");
				System.out.println("Nouveau solde compte courant du client " + c1.getNom() + " : "
						+ soldeCompteCourantC1 + " €" + "\n" + "Nouveau solde compte courant du client " + c2.getNom()
						+ " : " + soldeCompteCourantC2 + " €");
			}
		}
	}

	/**
	 * Méthode permettant de réaliser l'audit d'une agence. La méthode retourne un
	 * booléen qui vaut true si l'audit s'est bien déroulé, sinon un booléen false.
	 * Si un problème est survenu pendant l'audit, la méthode indique de quel(s)
	 * client(s) provient le problème.
	 * 
	 * @param Agence agence
	 */
	public boolean audit(Agence agence) {
		boolean okAudit = true;
		for (Conseiller conseiller : agence.getListeConseiller()) {
			for (Client client : conseiller.getListeClient()) {
				if (client instanceof Particulier) {
					if (client.getCompteEpargne() != null) {
						if (client.getCompteCourant().getSolde() + client.getCompteEpargne().getSolde() < -5000) {
							okAudit = false;
							System.out.println("Probleme avec le client particulier " + client.getNom()
									+ ", veuillez le contacter au " + client.getTelephone());
						}
					} else {
						if (client.getCompteCourant().getSolde() < -5000) {
							okAudit = false;
							System.out.println("Probleme avec le client particulier " + client.getNom()
									+ ", veuillez le contacter au " + client.getTelephone());
						}
					}
				}
				if (client instanceof Entreprise) {
					if (client.getCompteEpargne() != null) {
						if (client.getCompteCourant().getSolde() + client.getCompteEpargne().getSolde() < -50000) {
							okAudit = false;
							System.out.println("Probleme avec le client entreprise " + client.getNom()
									+ ", veuillez le contacter au " + client.getTelephone());

						}
					} else {
						if (client.getCompteCourant().getSolde() < -50000) {
							okAudit = false;
							System.out.println("Probleme avec le client entreprise " + client.getNom()
									+ ", veuillez le contacter au " + client.getTelephone());
						}
					}

				}
			}
		}

		if (okAudit) {
			System.out.println("L'agence n°" + agence.getId() + " a passé l'audit avec succès !");
		}

		return okAudit;
	}
}
