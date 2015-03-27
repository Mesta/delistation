package delistation.g_adherents.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.omg.CosNaming.NamingContext;
import org.omg.PortableServer.LifespanPolicyValue;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import delistation.utils.CorbaObject;

/**************************************
 * Serveur CORBA de l'objet G_Adherent *
 **************************************/
public class G_AdherentsServeur {
	/** Logger de l'objet CORBA {@link G_AdherentsServeur} */
	static Logger lgr = Logger.getLogger("G_Adherent");
	
	/**
	 * Méthode de démarrage du servant
	 * 
	 * @param args Paramètre de lancement du servant
	 * 
	 * @see G_AdherentsImpl
	 */
	public void run(String[] args) {
		try {
			// Intialisation de l'ORB
			// ************************
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);

			// Gestion du POA
			// ****************
			// Recuperation du POA
			// get a reference to the root POA
			POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			// Create policies for our persistent POA
			org.omg.CORBA.Policy[] policies = {rootPOA.create_lifespan_policy(LifespanPolicyValue.PERSISTENT)};

			// Creation du servant
			// *********************
			G_AdherentsImpl g_adherent = new G_AdherentsImpl();

			// Création de mon propre POA
			// **************************
			org.omg.PortableServer.POA myPOA = rootPOA.create_POA(CorbaObject.G_ADHERENT, rootPOA.the_POAManager(), policies);
			myPOA.activate_object(g_adherent);
			
			//Activation
			myPOA.the_POAManager().activate();

			// Enregistrement dans le service de nommage
			// *******************************************
			// Recuperation du naming service
			NamingContext nameRoot = org.omg.CosNaming.NamingContextHelper
					.narrow(orb.resolve_initial_references("NameService"));

			// Construction du nom a enregistrer
			org.omg.CosNaming.NameComponent[] nameToRegister = new org.omg.CosNaming.NameComponent[1];
			String nomObj = CorbaObject.G_ADHERENT;
			nameToRegister[0] = new org.omg.CosNaming.NameComponent(nomObj, "");

			// Enregistrement de l'objet CORBA dans le service de noms
			nameRoot.rebind(nameToRegister,
					myPOA.servant_to_reference(g_adherent));
			System.out.println("Le nom '" + nomObj
					+ "' est enregistre dans le service de noms.");

			String IORServant = orb.object_to_string(myPOA
					.servant_to_reference(g_adherent));
			System.out.println("L'objet possede la reference suivante :");
			System.out.println(IORServant);

			// Lancement de l'ORB et mise en attente de requete
			// **************************************************
			System.out.println("L'objet " + nomObj + " demarre...");
			orb.run();
		} catch (Exception e) {
			G_AdherentsServeur.lgr.log(Level.SEVERE, e.getMessage(), e);
		}
	}

	public static void main(String[] args) {
		G_AdherentsServeur srv = new G_AdherentsServeur();
		srv.run(args);
	}
}
