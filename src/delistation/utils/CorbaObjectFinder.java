package delistation.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

import delistation.appli_adherent.Appli_Adherent;
import delistation.datatypes.Zone;
import delistation.g_adherents.G_Adherents;
import delistation.g_colis.G_Colis;
import delistation.g_facturation.G_Facturation;
import delistation.g_superviseur.G_Superviseur;
import delistation.g_transporteur.G_Transporteur;

public class CorbaObjectFinder {
	private static Logger lgr = Logger.getLogger(CorbaObjectFinder.class
			.getName());
	
	private static G_Adherents g_adherent;
	private static G_Superviseur g_superviseur;
	private static G_Transporteur g_transporteur;
	private static G_Facturation g_facturation;

	public static G_Adherents bind_G_Adherent() {
		String service_name = CorbaObject.G_ADHERENT;

		if (CorbaObjectFinder.g_adherent == null) {
			org.omg.CORBA.Object obj = CorbaObjectFinder
					.ObjectFinderFromName(service_name);

			if (obj != null) {
				// Casting des objets CORBA
				CorbaObjectFinder.g_adherent = delistation.g_adherents.G_AdherentsHelper
						.narrow(obj);
			} else {
				CorbaObjectFinder.lgr.log(Level.SEVERE, "Objet CORBA "
						+ service_name
						+ " non trouve au pres du service de nom.");
			}
		}
		return CorbaObjectFinder.g_adherent;
	}

	public static G_Superviseur bind_G_Superviseur() {
		String service_name = CorbaObject.G_SUPERVISEUR;

		if (CorbaObjectFinder.g_superviseur == null) {
			org.omg.CORBA.Object obj = CorbaObjectFinder
					.ObjectFinderFromName(service_name);

			if (obj != null) {
				// Casting des objets CORBA
				CorbaObjectFinder.g_superviseur = delistation.g_superviseur.G_SuperviseurHelper
						.narrow(obj);
			} else {
				CorbaObjectFinder.lgr.log(Level.SEVERE, "Objet CORBA "
						+ service_name
						+ " non trouve au pres du service de nom.");
			}
		}
		return CorbaObjectFinder.g_superviseur;
	}

	public static G_Transporteur bind_G_Transporteur() {
		String service_name = CorbaObject.G_TRANSPORTEUR;

		if (CorbaObjectFinder.g_transporteur == null) {
			org.omg.CORBA.Object obj = CorbaObjectFinder
					.ObjectFinderFromName(service_name);

			if (obj != null) {
				// Casting des objets CORBA
				CorbaObjectFinder.g_transporteur = delistation.g_transporteur.G_TransporteurHelper
						.narrow(obj);
			} else {
				CorbaObjectFinder.lgr.log(Level.SEVERE, "Objet CORBA "
						+ service_name
						+ " non trouve au pres du service de nom.");
			}
		}
		return CorbaObjectFinder.g_transporteur;
	}

	public static G_Facturation bind_G_Facturation() {
		String service_name = CorbaObject.G_FACTURATION;

		if (CorbaObjectFinder.g_facturation == null) {
			org.omg.CORBA.Object obj = CorbaObjectFinder
					.ObjectFinderFromName(service_name);

			if (obj != null) {
				// Casting des objets CORBA
				CorbaObjectFinder.g_facturation = delistation.g_facturation.G_FacturationHelper
						.narrow(obj);
			} else {
				CorbaObjectFinder.lgr.log(Level.SEVERE, "Objet CORBA "
						+ service_name
						+ " non trouve au pres du service de nom.");
			}
		}
		return CorbaObjectFinder.g_facturation;
	}

	public static G_Colis bind_G_Colis(Zone zone) {
		String service_name = CorbaObject.G_COLIS + "_" + zone.commune + "_"
				+ zone.quartier;
		G_Colis g_colis = null;

		org.omg.CORBA.Object obj = CorbaObjectFinder
				.ObjectFinderFromName(service_name);

		if (obj != null) {
			// Casting des objets CORBA
			g_colis = delistation.g_colis.G_ColisHelper.narrow(obj);
		} else {
			CorbaObjectFinder.lgr.log(Level.SEVERE, "Objet CORBA "
					+ service_name + " non trouve au pres du service de nom.");
		}

		return g_colis;
	}

	public static Appli_Adherent bind_Appli_Adherent(short noAdh) {
		String service_name = CorbaObject.APPLI_ADHERENT + "_" + noAdh;
		Appli_Adherent appli_adherent = null;

		if (CorbaObjectFinder.g_facturation == null) {
			org.omg.CORBA.Object obj = CorbaObjectFinder
					.ObjectFinderFromName(service_name);

			if (obj != null) {
				// Casting des objets CORBA
				appli_adherent = delistation.appli_adherent.Appli_AdherentHelper
						.narrow(obj);
			} else {
				CorbaObjectFinder.lgr.log(Level.SEVERE, "Objet CORBA "
						+ service_name
						+ " non trouve au pres du service de nom.");
			}
		}
		return appli_adherent;
	}

	public static G_Colis bind_G_Colis(String IOR) {
		G_Colis g_colis = null;

		org.omg.CORBA.Object obj = ObjectFinderFromIOR(IOR);

		if (obj != null) {
			// Casting des objets CORBA
			g_colis = delistation.g_colis.G_ColisHelper.narrow(obj);
		} else {
			CorbaObjectFinder.lgr.log(Level.SEVERE, "Objet CORBA non trouve au pres du service de nom. " + IOR);
		}

		return g_colis;
	}

	private static org.omg.CORBA.Object ObjectFinderFromName(String name) {
		String[] args = {};
		org.omg.CORBA.Object corbaObject = null;

		try {
			// Intialisation de l'orb
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);

			// Nom de l'objet CORBA
			String idObj = name;

			// Recuperation du naming service
			org.omg.CosNaming.NamingContext nameRoot = org.omg.CosNaming.NamingContextHelper
					.narrow(orb.string_to_object("corbaloc:iiop:1.2@"
							+ CorbaObject.ADR_IP + ":2001/NameService"));

			// Construction du nom a rechercher
			org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
			nameToFind[0] = new org.omg.CosNaming.NameComponent(idObj, "");

			// Recherche aupres du naming service
			corbaObject = nameRoot.resolve(nameToFind);
		} catch (Exception e) {
			CorbaObjectFinder.lgr.log(Level.SEVERE, e.getMessage(), e);
		}
		CorbaObjectFinder.lgr.log(Level.INFO, "Objet " + name + " "
				+ corbaObject);
		return corbaObject;
	}

	private static org.omg.CORBA.Object ObjectFinderFromIOR(String IOR) {
		String[] args = {};
		org.omg.CORBA.Object corbaObject = null;

		try {
			// Intialisation de l'orb
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);
			corbaObject = orb.string_to_object(IOR);
		} catch (Exception e) {
			CorbaObjectFinder.lgr.log(Level.SEVERE, e.getMessage(), e);
		}
		CorbaObjectFinder.lgr.log(Level.INFO, "Objet " + IOR + " "
				+ corbaObject);
		return corbaObject;
	}
}
