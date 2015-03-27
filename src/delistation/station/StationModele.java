package delistation.station;

// Utils
import java.util.Hashtable;
import org.omg.CORBA.ORB;

import delistation.datatypes.Colis;
import delistation.datatypes.Zone;
import delistation.datatypes.Adherent;
import delistation.datatypes.Transporteur;
import delistation.g_adherents.G_Adherents;
import delistation.g_colis.G_Colis;
import delistation.g_superviseur.G_Superviseur;
import delistation.g_transporteur.G_Transporteur;
import delistation.station.ihm.StationJFrame;
import delistation.utils.CorbaObjectFinder;

public class StationModele {
	public static StationModele singleton;
	
	/* Nombre max de casiers */
	public final static int MAXCASIER = 100;

	private static final Colis CASIERVIDE = null;
	
	/* Attributs */
	private StationJFrame IHM;
	public Colis[] casiers;
	public String iorG_Colis;
	private Zone zoneStation;
	
	// Current user on station interface (XOR)
	private Adherent currentAdh;
	private Transporteur currentTrans;

	private G_Transporteur g_transporteur;

	private G_Superviseur g_superviseur;

	private G_Adherents g_adherents;

	public StationModele(Short commune, Short quartier) {
		this.resetCurrentSession();
		this.zoneStation 	= new Zone(commune, quartier);
		this.g_superviseur 	= null;
		this.casiers		= new Colis [MAXCASIER];
		for(int cpt = 0; cpt < MAXCASIER; cpt++){
			this.casiers[cpt] = CASIERVIDE;
		}
		StationModele.singleton = this;
	}
	
	public String getIORG_Colis(){
		String[] args = {};
		ORB orb = org.omg.CORBA.ORB.init(args, null);
		G_Colis	g_colis = CorbaObjectFinder.bind_G_Colis(this.zoneStation);
		this.iorG_Colis = orb.object_to_string(g_colis);
		return this.iorG_Colis;
	}

	public void setIHM(StationJFrame p_ihm) {
		this.IHM = p_ihm;
	}

	public Zone getZone() {
		return this.zoneStation;
	}

	public Adherent getCurrentAdh() {
		return currentAdh;
	}

	public void setCurrentAdh(Adherent currentAdh) {
		this.resetCurrentSession();
		this.currentAdh = currentAdh;
	}

	public Transporteur getCurrentTrans() {
		return currentTrans;
	}

	public void setCurrentTrans(Transporteur currentTrans) {
		this.resetCurrentSession();
		this.currentTrans = currentTrans;
	}

	private void resetCurrentSession() {
		this.currentAdh 	= null;
		this.currentTrans 	= null;
	}

	// Libere un casier
	public void removeColis(int numCasier) {
		this.casiers[numCasier] = CASIERVIDE;
	}
	
	// Ajoute un colis dans un casier
	public void addColis(Colis colis, int noCasier) {
		casiers[noCasier] = colis;
	}
	
	// Retourne les colis, d'un adhérent, en attente de retrait
	public Hashtable<Integer, Colis> getColisList (Short noAdh) {
		Hashtable<Integer, Colis> ret = new Hashtable<Integer, Colis>();

		for (int i=0; i<casiers.length; i++) {
			System.out.println("i: " +i);
			if (casiers[i] != null) {
				if (casiers[i].destinataire == noAdh) {
					ret.put(i, casiers[i]);
				}
			}
		}
		return ret;
	}
	
	// Retourne un casier vide
	public int getCasierLibre() {
		int i;
		for (i=0; i<casiers.length; i++) {
			if (casiers[i] == null) {
				return i;
			}
		}
		return i;
	}
	
	public StationJFrame getIHM() {
		return IHM;
	}

	public G_Transporteur g_transporteur() {
		this.g_transporteur = CorbaObjectFinder.bind_G_Transporteur();		
		return this.g_transporteur;
	}

	public G_Superviseur g_superviseur() {
		this.g_superviseur = CorbaObjectFinder.bind_G_Superviseur();		
		return this.g_superviseur;
	}
	
	@SuppressWarnings("unused")
	private void addColisCasier(int noCasier, Colis p_colis){
		this.casiers[noCasier] = p_colis;
	}

	public int getCasier(short noColis) {
		int retour = -1;
		for (int i = 0; i<casiers.length; i++) {
			if (casiers[i] != null){
				if(casiers[i].noColis == noColis)
					retour = i;
			}
		}
		
		return retour;
	}

	public String getIOR() {
		return this.iorG_Colis;
	}

	public G_Adherents g_adherents() {
		this.g_adherents = CorbaObjectFinder.bind_G_Adherent(); 
		return this.g_adherents;
	}
}
