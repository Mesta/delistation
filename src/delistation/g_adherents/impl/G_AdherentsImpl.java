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
	
	/** Instance de l'objet offrant des m�thodes d'acc�s � la base de donn�es.*/
	private G_AdherentsDBHelper dbHelper;
	/* R�f�rence vers le servant G_Facturation.*/
	private G_Facturation g_facturation;
	
	/**
	 * Constructeur par d�faut de l'objet {@link G_AdherentsImpl}.
	 */
	public G_AdherentsImpl() {
		this.dbHelper = new G_AdherentsDBHelper();
		this.g_facturation = null;
	}
	
	/**
	 * M�thode accessible au travers de l'orb pour enregistrer un nouvel adh�rent dans le syst�me.
	 * 
	 * @param nom Nom de l'adh�rent.
	 * @param prenom Pr�nom de l'adh�rent.
	 * @param adresse Adresse de l'adh�rent.
	 * @param RIB Coordonn�es bancaires de l'adh�rent.
	 * @param numAdh Num�ro de l'adh�rent g�n�r� par le syst�me. Les modifications de cette valeurs sont visibles par l'appelant de la m�thode.
	 * @param MdP Mot de passe de l'adh�rent g�n�r� par le syst�me. Les modifications de cette valeurs sont visibles par l'appelant de la m�thode.
	 * 
	 * @return Montant de l'adh�sion
	 * 
	 * @throws ExceptionErreurPaiement Si une erreur de paiement survient
	 * @throws ExceptionAdresseDejaPrise Si l'adresse de l'adh�rent est d�j� utilis�e par un autre adh�rent
	 * @throws ExceptionErreurInscription Si une erreur quelconque surviant durant l'inscription
	 * 
	 * @see delistation.g_adherents.G_AdherentsOperations#adherer(java.lang.String, java.lang.String, java.lang.String, java.lang.String, org.omg.CORBA.StringHolder, org.omg.CORBA.StringHolder)
	 */
	public short adherer(String nom, String prenom, String adresse, String RIB,
			StringHolder noAdh, StringHolder MdP)
			throws ExceptionErreurPaiement, ExceptionAdresseDejaPrise, ExceptionErreurInscription {
		G_AdherentsServeur.lgr.log(Level.INFO, "Appel de adherer( " + nom + ", " + prenom + ", " + adresse + "," + RIB + "," + noAdh + "," + MdP + ")");
		short retour = 0;
		
		// On g�n�re le mot de passe
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		Random rand = new Random();
		for (int i = 0; i < 6; i++)
			MdP.value += alphabet.charAt(rand.nextInt(alphabet.length()));

		// On insere l'adherent en base de donnees
		short numAdh = (short)this.dbHelper.insertAdherent(nom, prenom, adresse, RIB, MdP.value);
		noAdh.value = "" + numAdh;
		
		//Si le num�ro g�n�r� est valide (que l'insertion a donc eu lieu)
		if (numAdh != -1) { // On lui cr�� un compte bancaire
			G_AdherentsServeur.lgr.log(Level.INFO, "Adh�rent inscrit au syst�me.");
			if(this.g_facturation().creerCompte(numAdh, CompteMode.Adherent))
					retour = this.g_facturation().factureAdhesion(RIB);
		}
		else
			throw new ExceptionErreurInscription();
		return retour;
	}

	
	/**
	 * M�thode d'authentification d'un adh�rent au syst�me.
	 * 
	 * @param noAdh Num�ro de l'adh�rent.
	 * @param MdP Mot de passe de l'adh�rent.
	 * 
	 * @return Bool�en indiquant l'authentification ou non.
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
	 * M�thode de recherche de l'adh�rent dont l'adresse est sp�cifi�e en param�tre. Cette adresse sera mise � jour
	 * avec les informations contenues en base de donn�es (et notamment la zone)
	 * 
	 * @param adrDest {@link AdresseHolder} contenant l'adresse de l'adh�rent � rechercher.
	 * 
	 * @return Objet {@link Adherent} correspondant � l'adresse en param�tre.
	 * 
	 * @throws ExceptionDestinationInconnue Si l'adresse ne fait r�f�rence � aucun adh�rent.
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
	 * M�thode de facturation d'un adh�rent.
	 * 
	 * @param noAdh Num�ro de l'adh�rent � facturer.
	 * @param montant Montant � facturer.
	 * 
	 * @return Bool�en de confirmation de la facturation et du d�bit bancaire.
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
	 * M�thode permettant la notification sur son application personnelle de l'arriv�e d'un colis pour adh�rent destinataire. 
	 * 
	 * @param noAdh Num�ro de l'adh�rent � notifier.
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
	 * M�thode de recherche du servant {@link G_Facturation}.
	 * 
	 * @return R�f�rence au servant {@link G_Facturation}.
	 * 
	 * @see delistation.utils.CorbaObjectFinder
	 */
	private G_Facturation g_facturation() {
		if (this.g_facturation == null)
			this.g_facturation = CorbaObjectFinder.bind_G_Facturation();
		return this.g_facturation;
	}
	
	/**
	 * M�thode permettant d'obtenir les informations d'un adh�rent.
	 * 
	 * @param noAdh Num�ro de l'adh�rent.
	 * 
	 * @return Objet {@link Adherent} contenant les informations stock�es en base de donn�es.
	 * 
	 * @throws ExceptionAdherentInconnu Si le num�ro d'adh�rent pass� en param�tre ne fait r�f�rence � aucun adh�rent connu du syst�me.
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
