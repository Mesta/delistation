package delistation.g_colis.impl;

import java.util.logging.Logger;

import org.omg.CosNaming.NamingContext;
import org.omg.PortableServer.LifespanPolicyValue;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import delistation.datatypes.Adresse;
import delistation.datatypes.Zone;
import delistation.utils.CorbaObject;

/***********************************
 * Serveur CORBA de l'objet G_Colis *
 ***********************************/
public class G_ColisServeur {

	public final static Logger lgr = Logger.getLogger("G_Colis");
	public static G_ColisServeur singleton;
	public String IORServant;

	public org.omg.CORBA.ORB orb;

	public G_ColisServeur() {
		G_ColisServeur.singleton = this;
	}

	public void run(String[] args) {

		try {
			// Intialisation de l'ORB
			// ************************
			orb = org.omg.CORBA.ORB.init(args, null);

			// Gestion du POA
			// ****************
			// Recuperation du POA
			// get a reference to the root POA
			POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			// Create policies for our persistent POA
			org.omg.CORBA.Policy[] policies = {rootPOA.create_lifespan_policy(LifespanPolicyValue.PERSISTENT)};
			
			// Creation du servant
			// *********************
			String[] split = args[0].split(";");
			Adresse adr = new Adresse(split[0], new Short(split[1]).shortValue()
					, split[2], new Zone(new Short(split[3]).shortValue(), 
							new Short(split[4]).shortValue()));
			
			G_ColisImpl g_colis = new G_ColisImpl(adr);

			// Création de mon propre POA
			// **************************
			org.omg.PortableServer.POA myPOA = rootPOA.create_POA(CorbaObject.G_COLIS + adr.zone.toString(), rootPOA.the_POAManager(), policies);
			myPOA.activate_object(g_colis);

			// Activer le POA manager
			myPOA.the_POAManager().activate();

			// Enregistrement dans le service de nommage
			// *******************************************
			// Recuperation du naming service
			NamingContext nameRoot = org.omg.CosNaming.NamingContextHelper
					.narrow(orb.resolve_initial_references("NameService"));

			// Construction du nom a enregistrer
			org.omg.CosNaming.NameComponent[] nameToRegister = new org.omg.CosNaming.NameComponent[1];
			String nomObj = CorbaObject.G_COLIS + "_" + adr.zone.commune + "_"
					+ adr.zone.quartier;
			nameToRegister[0] = new org.omg.CosNaming.NameComponent(nomObj, "");
			org.omg.CORBA.Object reference = myPOA.servant_to_reference(g_colis);

			// Enregistrement de l'objet CORBA dans le service de noms
			nameRoot.rebind(nameToRegister, reference);
			System.out.println("Le nom '" + nomObj
					+ "' est enregistre dans le service de noms.");

			this.IORServant = orb.object_to_string(reference);
			
			System.out.println("L'objet possede la reference suivante :");
			System.out.println(this.IORServant);

			// Lancement de l'ORB et mise en attente de requete
			// **************************************************
			System.out.println("L'objet " + nomObj + " demarre...");
			orb.run();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new G_ColisServeur().run(args);
	}
}
