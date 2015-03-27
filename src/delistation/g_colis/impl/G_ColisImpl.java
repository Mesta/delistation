package delistation.g_colis.impl;

import java.util.Hashtable;
import java.util.logging.Level;

import delistation.datatypes.Adherent;
import delistation.datatypes.Adresse;
import delistation.datatypes.Colis;
import delistation.datatypes.ColisHolder;
import delistation.datatypes.etatColis;
import delistation.exceptions.ExceptionColisInconnu;
import delistation.exceptions.ExceptionDestinataireInconnue;
import delistation.exceptions.ExceptionDestinationMemeZone;
import delistation.exceptions.ExceptionErreurPaiement;
import delistation.g_colis.G_ColisPOA;
import delistation.station.StationLauncher;
import delistation.utils.CorbaObjectFinder;

public class G_ColisImpl extends G_ColisPOA {
	private Adresse adresse;
	private Hashtable<Short, ColisManager> listeColis;
	
	private short keyColis = 0;
	
	public G_ColisImpl(Adresse adr) {
		this.adresse = adr;
		this.listeColis = new Hashtable<Short, ColisManager>();
		this.keyColis = 0;
		new StationLauncher(adr.zone).run();
	}

	/**
	 * Permet de savoir si une adresse est desservie par ce G_Colis.
	 * @param adresseDest Adresse recherchée.
	 * @return Booléen de confirmation.
	 */
	private boolean isDesservies(Adresse adresseDest) {
		return this.adresse.zone.toString() == adresseDest.zone.toString();
	}
	
	/**
	 * Enregistre le dépôt d'un colis, et retourne le montant de la facture.
	 * 
	 * @param adrDest Adresse du destinataire.
	 * @param colis Colis à transporter.
	 * @return Retourne le montant du transport.
	 * @throws ExceptionDestinationMemeZone Si la destination se trouver dans la zone desservie par le G_Colis.
	 * @throws ExceptionDestinationInconnue Si la destination est inconnue.
	 * @throws ExceptionErreurPaiement Si une erreur survient lors du paiement.
	 */
	public short deposer(Adresse adrDest, ColisHolder colis)
			throws ExceptionDestinationMemeZone, ExceptionDestinataireInconnue,
			ExceptionErreurPaiement {
		G_ColisServeur.lgr.log(Level.INFO, "deposer(Adresse " + adrDest + ", ColisHolder " + colis + " ) "
				+ "throws ExceptionDestinationMemeZone, ExceptionDestinataireInconnue, ExceptionErreurPaiement");
		
		/*
		 *  On recherche l'id du destinataire, l'objet adrDest est lui mis à
		 *  jour avec la zone du destinataire.
		 *  Peut raise ExceptionDestinationInconnue
		 */
		Adherent adh = CorbaObjectFinder.bind_G_Adherent().rechercheDestinataire(adrDest);
		if (this.isDesservies(adh.adresse))
			throw new ExceptionDestinationMemeZone();
		else {
			
			// On met a jour le colis avec cette information
			colis.value.noColis = this.generateNumColis(colis.value.destinataire , adh.no);
			colis.value.destinataire = adh.no;
			
			short montant = CorbaObjectFinder.bind_G_Facturation().devisTransport(this.adresse.zone,
					adh.adresse.zone);
			
			// On facture l'expediteur (si KO : raise ExceptionErreurPaiement)
			if(CorbaObjectFinder.bind_G_Adherent().facturer(colis.value.expediteur, montant)){

				// Si le paiment est OK
				//On l'ajoute à la liste de colis
				ColisManager cm = new ColisManager(colis.value);
				this.listeColis.put(colis.value.noColis, cm);
				//On met à jour son état
				this.majEtatColis(colis.value.noColis, etatColis.enAttenteDeTransport);
				
				//On enregistre un nouveau transport
				CorbaObjectFinder.bind_G_Transporteur().enregistrerNouveauTransport(colis.value.noColis,
						G_ColisServeur.singleton.IORServant, montant);
			}
			return montant;
		}
	}

	private short generateNumColis(short nDest, short nExp) {
		this.keyColis++;
		return (short)(nDest + nExp + this.keyColis);
	 }

	public void majEtatColis(short noColis, etatColis p_etat) {
		// On met à jour l'état du colis
		this.listeColis.get(noColis).setEtatColis(p_etat);
		G_ColisServeur.lgr.log(Level.INFO, "majEtatColis(short " + noColis + ", etatColis " + p_etat + ")");
		
		//Traitement selon le cas d'état
		switch (p_etat.value()) {
		case etatColis._enAttenteDeTransport:
			// Rien de specifique a faire
			break;

		case etatColis._auDepart:
			// Rien de specifique a faire
			break;

		case etatColis._enTransport:
			// Rien de specifique a faire
			break;

		case etatColis._aDestination:
			
			// On recupere le numero d'adherent du destinataire
			short noAdhDest = this.listeColis.get(noColis).getColis().destinataire;
			// On demande a G_Adherent de le notifier
			CorbaObjectFinder.bind_G_Adherent().demandeNotificationDepot(noAdhDest);
			break;

		default:
			G_ColisServeur.lgr.log(Level.SEVERE,
					"Cas d'état de colis non géré.");
			break;
		}
	}

	public etatColis demandeEtat(short noColis) throws ExceptionColisInconnu {
		return this.listeColis.get(noColis).getEtatColis();
	}

	public boolean isDestinataire(short noColis, short noAdh) {
		ColisManager tmp = this.listeColis.get(noColis);
		return tmp.isDestinaraire(noAdh);
	}

	public Adresse getAdresseG_Colis() {
		return this.adresse;
	}

	public Colis getColis(short noColis) throws ExceptionColisInconnu {
		
		try{
			return this.listeColis.get(noColis).getColis();
		}
		catch(Exception e){
			throw new ExceptionColisInconnu();
		}
	}
	
	public void supprimerColis(short noColis){
		this.listeColis.remove(noColis);
	}

}
