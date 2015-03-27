package delistation.appli_transporteur.ihm;

import java.awt.Color;
import java.util.logging.Level;

import javax.swing.JLabel;
import delistation.datatypes.Adherent;
import delistation.datatypes.Adresse;
import delistation.datatypes.Colis;
import delistation.datatypes.Course;
import delistation.exceptions.ExceptionAdherentInconnu;
import delistation.exceptions.ExceptionColisInconnu;
import delistation.g_colis.G_Colis;
import delistation.utils.CorbaObjectFinder;

public class AT_Utils {

	//Extrait les données a affiché dans les JTables
	public static Object[][] extractSCTableData(Course[] lCourse) throws ExceptionColisInconnu {
		int nbCourse = lCourse.length;
		Object[][] tableData = new Object[lCourse.length][4];
		
		for (int i = 0; i < nbCourse; i++) {

			//On récupère le g_colis expediteur
			G_Colis g_colis_exp = CorbaObjectFinder.bind_G_Colis(lCourse[i].IORG_Colis);

			tableData[i][0] = Short.toString(lCourse[i].noCourse);
			tableData[i][3] = Short.toString((short) (lCourse[i].montant*0.9)) + "€";

			/** Affichage de l'adresse du g_colis expediteur **/
			Adresse adresse_exp = g_colis_exp.getAdresseG_Colis();
			String exp = adresse_exp.numero + " " + adresse_exp.rue;  
			tableData[i][1] = exp;
			
			/** Affichage de l'adresse du g_colis destinataire **/
			//On récupère le colis
			Colis colis = g_colis_exp.getColis(lCourse[i].noColis);
			//On récupère les informations du destinataire
			Adherent desti;
			try {
				desti = CorbaObjectFinder.bind_G_Adherent().getAdherent(colis.destinataire);
				G_Colis g_colis_dest = CorbaObjectFinder.bind_G_Colis(desti.adresse.zone);
				
				Adresse adresse_dest = g_colis_dest.getAdresseG_Colis();
				String dest = adresse_dest.numero + " " + adresse_dest.rue;  
				
				tableData[i][2] = dest;

			} catch (ExceptionAdherentInconnu e) {
				AT_Modele.lgr.log(Level.SEVERE, e.getMessage(), e);
			}
			
		}
		
		return tableData;
	}
	
	
	public static void changeLabel ( JLabel label, Color color, String message ) {
		label.setText(message);
		label.setForeground(color);
	}
}