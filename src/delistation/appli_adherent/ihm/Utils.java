package delistation.appli_adherent.ihm;

import delistation.datatypes.Course;
import delistation.datatypes.etatColis;
import delistation.exceptions.ExceptionColisInconnu;
import delistation.g_colis.G_Colis;

public class Utils {

	public static Object[][] extractSCTableData(Course[] lCourse)
			throws ExceptionColisInconnu {
		System.out.println("//== extractSCTableData");
		int nbCourse = lCourse.length;
		Object[][] tableData = new Object[lCourse.length][2];
		for (int i = 0; i < nbCourse; i++) {
			short noColis = lCourse[i].noColis;
			String etat;
			org.omg.CORBA.ORB orb;
			String[] str = {};
			orb = org.omg.CORBA.ORB.init(str, null);
			G_Colis g_colis = (G_Colis) orb
					.string_to_object(lCourse[i].IORG_Colis);

			switch (g_colis.demandeEtat(noColis).value()) {
			case etatColis._enTransport:
				etat = "En cours";
				break;
			case etatColis._aDestination:
				etat = "Livré";
				break;
			case etatColis._auDepart:
			case etatColis._enAttenteDeTransport:
				etat = "Enregistrée";
				break;
			default:
				etat = "Non Défini";
				break;
			}
			tableData[i][0] = Short.toString(noColis);
			tableData[i][1] = etat;
		}
		return tableData;
	}
}
