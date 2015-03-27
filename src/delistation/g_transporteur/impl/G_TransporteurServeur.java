package delistation.g_transporteur.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.omg.CosNaming.NamingContext;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import delistation.utils.CorbaObject;

/**************************************
 * Serveur CORBA de l'objet G_Adherent *
 **************************************/
public class G_TransporteurServeur {
	static Logger lgr = Logger.getLogger("G_Transporteur");

	public void run(String[] args) {
		try {
			// Intialisation de l'ORB
			// ************************
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);

			// Gestion du POA
			// ****************
			// Recuperation du POA
			POA rootPOA = POAHelper.narrow(orb
					.resolve_initial_references("RootPOA"));

			// Creation du servant
			// *********************
			G_TransporteurImpl g_transporteur = new G_TransporteurImpl();

			// Activer le servant au sein du POA et recuperer son ID
			// byte[] G_AdherentId = rootPOA.activate_object(g_adherent);

			// Activer le POA manager
			rootPOA.the_POAManager().activate();

			// Enregistrement dans le service de nommage
			// *******************************************
			// Recuperation du naming service
			NamingContext nameRoot = org.omg.CosNaming.NamingContextHelper
					.narrow(orb.resolve_initial_references("NameService"));

			// Construction du nom a enregistrer
			org.omg.CosNaming.NameComponent[] nameToRegister = new org.omg.CosNaming.NameComponent[1];
			String nomObj = CorbaObject.G_TRANSPORTEUR;
			nameToRegister[0] = new org.omg.CosNaming.NameComponent(nomObj, "");

			// Enregistrement de l'objet CORBA dans le service de noms
			nameRoot.rebind(nameToRegister,
					rootPOA.servant_to_reference(g_transporteur));
			System.out.println("Le nom '" + nomObj
					+ "' est enregistre dans le service de noms.");

			String IORServant = orb.object_to_string(rootPOA
					.servant_to_reference(g_transporteur));
			System.out.println("L'objet possede la reference suivante :");
			System.out.println(IORServant);

			// Lancement de l'ORB et mise en attente de requete
			// **************************************************
			System.out.println("Service " + nomObj + " demarre...");
			orb.run();
		} catch (Exception e) {
			G_TransporteurServeur.lgr.log(Level.SEVERE, e.getMessage(), e);
		}
	}

	public static void main(String[] args) {
		G_TransporteurServeur srv = new G_TransporteurServeur();
		srv.run(args);
	}
}