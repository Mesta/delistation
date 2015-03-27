package delistation.g_transporteur.impl;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.logging.Level;

import delistation.datatypes.Course;
import delistation.datatypes.Transporteur;
import delistation.exceptions.ExceptionTransporteurInconnu;
import delistation.g_transporteur.G_TransporteurPOA;

public class G_TransporteurImpl extends G_TransporteurPOA {
	
	private G_TransporteurDBHelper dbHelper;
	private Hashtable<Short, Course> LCourse;
	private short nbCourse;

	public G_TransporteurImpl() {
		this.dbHelper = new G_TransporteurDBHelper();
		this.LCourse = new Hashtable<Short, Course>();
		this.nbCourse = 0;
	}

	public Course[] getCoursesEnAttente() {
		G_TransporteurServeur.lgr.log(Level.INFO, "Appel de demandeCoursesEnAttente()");
		
		Course[] retour = new Course[this.LCourse.size()];
		
		Iterator<Course> it = this.LCourse.values().iterator();
		
		int cpt = 0;
		try{
			while(it.hasNext() && cpt < retour.length){
				retour[cpt] = it.next();
				cpt++;
			}
		}
		catch(Exception e){
			G_TransporteurServeur.lgr.log(Level.INFO, e.getMessage(), e);
		}
		return retour;
	}
	
	public void demandeSuppression(short noCourse) {
		this.LCourse.remove(noCourse);
		G_TransporteurServeur.lgr.log(Level.INFO, "Appel de demandeSuppression(short " + noCourse + ")");
	}
	
	public void enregistrerNouveauTransport(short noColis, String IORG_Colis, short montant) {
		G_TransporteurServeur.lgr.log(Level.INFO, "enregistrerNouveauTransport(short " + noColis + ", String " + IORG_Colis + ")");
		//On recupère le nombre de course ayant déjà été traité
		short idCourse = this.nbCourse;
		
		//Création d'une nouvelle course
		Course course = new Course(idCourse, noColis, IORG_Colis, (short)0, montant, 0);
		this.ajouterCourse(course);
	}
	
	public void reenregistrerTransport(Course p_course) {
		G_TransporteurServeur.lgr.log(Level.INFO, "reenregistrerTransport(Course " + p_course + ")");
		this.ajouterCourse(p_course);
	}
	
	private void ajouterCourse(Course p_course){
		//On l'ajoute à la liste à prendre en charge
		this.LCourse.put(p_course.noCourse, p_course);
		
		//On incrémente le nombre total de courses créé
		this.nbCourse++;
	}

	public String getRIB(short noTransp) throws ExceptionTransporteurInconnu {
		G_TransporteurServeur.lgr.log(Level.INFO, "Appel de getRIB(short " + noTransp + ")");
		return this.dbHelper.getRIB(noTransp);
	}

	public boolean authentifier(short noTransp, String MdP) {
		return this.dbHelper.authentifierTransporteur(noTransp, MdP);
	}
	
	public Transporteur getTransporteur(short noTransp){
		return this.dbHelper.selectTransporteur(noTransp);
	}
}
