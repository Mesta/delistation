package delistation.g_adherents.impl;

import java.util.Random;
import java.util.logging.Level;

import org.omg.CORBA.StringHolder;

import delistation.appli_adherent.Appli_Adherent;
import delistation.datatypes.Adherent;
import delistation.datatypes.Adresse;
import delistation.datatypes.AdresseHolder;
import delistation.datatypes.CompteMode;
import delistation.exceptions.ExceptionAdherentInconnu;
import delistation.exceptions.ExceptionAdresseDejaPrise;
import delistation.exceptions.ExceptionDestinataireInconnue;
import delistation.exceptions.ExceptionErreurInscription;
import delistation.exceptions.ExceptionErreurPaiement;
import delistation.g_adherents.G_AdherentsPOA;
import delistation.g_facturation.G_Facturation;
import delistation.g_facturation.impl.G_FacturationServeur;
import delistation.utils.CorbaObjectFinder;

public class G_AdherentsImpl extends G_AdherentsPOA {
	
	/** Instance de l'objet offrant des méthodes d'accès à la base de données.*/
	private G_AdherentsDBHelper dbHelper;
	/* Référence vers le servant G_Facturation.*/
	private G_Facturation g_facturation;
	
	/**
	 * Constructeur par défaut de l'objet {@link G_AdherentsImpl}.
	 */
	public G_AdherentsImpl() {
		this.dbHelper = new G_AdherentsDBHelper();
		this.g_facturation = null;
	}
	
	/**
	 * Méthode accessible au travers de l'orb pour enregistrer un nouvel adhérent dans le système.
	 * 
	 * @param nom Nom de l'adhérent.
	 * @param prenom Prénom de l'adhérent.
	 * @param adresse Adresse de l'adhérent.
	 * @param RIB Coordonnées bancaires de l'adhérent.
	 * @param numAdh Numéro de l'adhérent généré par le système. Les modifications de cette valeurs sont visibles par l'appelant de la méthode.
	 * @param MdP Mot de passe de l'adhérent généré par le système. Les modifications de cette valeurs sont visibles par l'appelant de la méthode.
	 * 
	 * @return Montant de l'adhésion
	 * 
	 * @throws ExceptionErreurPaiement Si une erreur de paiement survient
	 * @throws ExceptionAdresseDejaPrise Si l'adresse de l'adhérent est déjà utilisée par un autre adhérent
	 * @throws ExceptionErreurInscription Si une erreur quelconque surviant durant l'inscription
	 * 
	 * @see delistation.g_adherents.G_AdherentsOperations#adherer(java.lang.String, java.lang.String, java.lang.String, java.lang.String, org.omg.CORBA.StringHolder, org.omg.CORBA.StringHolder)
	 */
	public short adherer(String nom, String prenom, String adresse, String RIB,
			StringHolder noAdh, StringHolder MdP)
			throws ExceptionErreurPaiement, ExceptionAdresseDejaPrise, ExceptionErreurInscription {
		G_AdherentsServeur.lgr.log(Level.INFO, "Appel de adherer( " + nom + ", " + prenom + ", " + adresse + "," + RIB + "," + noAdh + "," + MdP + ")");
		short retour = 0;
		
		// On génère le mot de passe
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		Random rand = new Random();
		for (int i = 0; i < 6; i++)
			MdP.value += alphabet.charAt(rand.nextInt(alphabet.length()));

		// On insere l'adherent en base de donnees
		short numAdh = (short)this.dbHelper.insertAdherent(nom, prenom, adresse, RIB, MdP.value);
		noAdh.value = "" + numAdh;
		
		//Si le numéro généré est valide (que l'insertion a donc eu lieu)
		if (numAdh != -1) { // On lui créé un compte bancaire
			G_AdherentsServeur.lgr.log(Level.INFO, "Adhérent inscrit au système.");
			if(this.g_facturation().creerCompte(numAdh, CompteMode.Adherent))
					retour = this.g_facturation().factureAdhesion(RIB);
		}
		else
			throw new ExceptionErreurInscription();
		return retour;
	}

	
	/**
	 * Méthode d'authentification d'un adhérent au système.
	 * 
	 * @param noAdh Numéro de l'adhérent.
	 * @param MdP Mot de passe de l'adhérent.
	 * 
	 * @return Booléen indiquant l'authentification ou non.
	 * 
	 * @see delistation.g_adherents.G_AdherentsOperations#authentifier(short, java.lang.String)
	 */
	public boolean authentifier(short noAdh, String MdP){
		G_AdherentsServeur.lgr.log(Level.INFO, "Appel de authentifier( " + noAdh + ", " + MdP + ")");
		
		boolean retour;
		if(this.dbHelper.authentifierAdherent(noAdh, MdP))
			retour = true;
		else
			retour = false;
		return retour;
	}
	
	/**
	 * Méthode de recherche de l'adhérent dont l'adresse est spécifiée en paramètre. Cette adresse sera mise à jour
	 * avec les informations contenues en base de données (et notamment la zone)
	 * 
	 * @param adrDest {@link AdresseHolder} contenant l'adresse de l'adhérent à rechercher.
	 * 
	 * @return Objet {@link Adherent} correspondant à l'adresse en paramètre.
	 * 
	 * @throws ExceptionDestinationInconnue Si l'adresse ne fait référence à aucun adhérent.
	 * 
	 * @see delistation.g_adherents.G_AdherentsOperations#rechercheDestination(delistation.datatypes.AdresseHolder)
	 */
	public Adherent rechercheDestinataire(Adresse adrDest)
			throws ExceptionDestinataireInconnue {
		G_AdherentsServeur.lgr.log(Level.INFO, "Appel de rechercheDestination( " + adrDest.toString() + ")");
		String adr_serialized = adrDest.nom + ";" + adrDest.numero
				+ ";" + adrDest.rue + ";";
		return this.dbHelper.rechercheDestinataire(adr_serialized);
	}
	
	/**
	 * Méthode de facturation d'un adhérent.
	 * 
	 * @param noAdh Numéro de l'adhérent à facturer.
	 * @param montant Montant à facturer.
	 * 
	 * @return Booléen de confirmation de la facturation et du débit bancaire.
	 * 
	 * @see delistation.g_adherents.G_AdherentsOperations#facturer(short, short)
	 */
	public boolean facturer(short noAdh, short montant)
			throws ExceptionErreurPaiement {
		G_AdherentsServeur.lgr.log(Level.INFO, "Appel de facturer( " + noAdh + ", " + montant +" )");
		boolean retour = false;
		String RIB;
		try {
			RIB = this.dbHelper.getRIB(noAdh);
			if(this.g_facturation().debiterAdherent(RIB, montant))
				retour = true;
			else
				throw new ExceptionErreurPaiement();
		} catch (ExceptionAdherentInconnu e) {
			throw new ExceptionErreurPaiement();
		}
		return retour;
	}
	
	/**
	 * Méthode permettant la notification sur son application personnelle de l'arrivée d'un colis pour adhérent destinataire. 
	 * 
	 * @param noAdh Numéro de l'adhérent à notifier.
	 * 
	 * @see delistation.g_adherents.G_AdherentsOperations#demandeNotificationDepot(short)
	 */
	public void demandeNotificationDepot(short noAdh) {
		G_AdherentsServeur.lgr.log(Level.INFO, "Appel de demandeNotificationDepot( " + noAdh + " )");
		Appli_Adherent appli_adherent = CorbaObjectFinder
				.bind_Appli_Adherent(noAdh);
		appli_adherent.notifierColis();
	}
	
	/**
	 * Méthode de recherche du servant {@link G_Facturation}.
	 * 
	 * @return Référence au servant {@link G_Facturation}.
	 * 
	 * @see delistation.utils.CorbaObjectFinder
	 */
	private G_Facturation g_facturation() {
		if (this.g_facturation == null)
			this.g_facturation = CorbaObjectFinder.bind_G_Facturation();
		return this.g_facturation;
	}
	
	/**
	 * Méthode permettant d'obtenir les informations d'un adhérent.
	 * 
	 * @param noAdh Numéro de l'adhérent.
	 * 
	 * @return Objet {@link Adherent} contenant les informations stockées en base de données.
	 * 
	 * @throws ExceptionAdherentInconnu Si le numéro d'adhérent passé en paramètre ne fait référence à aucun adhérent connu du système.
	 * 
	 * @see delistation.g_adherents.G_AdherentsOperations#getAdherent(short)
	 */
	public Adherent getAdherent(short noAdh) throws ExceptionAdherentInconnu {
		G_AdherentsServeur.lgr.log(Level.INFO, "Appel de getAdherent( " + noAdh + " )");
		Adherent retour = new Adherent();
		retour = this.dbHelper.selectAdherent(noAdh);
		return retour;
	}

	public void majIOR(short noAdh, short IOR) {
		this.dbHelper.updateIOR(noAdh, IOR);
	}
}
