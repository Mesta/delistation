package delistation.appli_transporteur.ihm;

import java.util.logging.Logger;

import delistation.datatypes.Course;
import delistation.datatypes.Transporteur;
import delistation.g_superviseur.G_Superviseur;
import delistation.g_transporteur.G_Transporteur;
import delistation.utils.CorbaObjectFinder;

public class AT_Modele {
	/** Logger de l'objet AppliTransp */
	public static Logger lgr = Logger.getLogger("AppliTransp");

	public static AT_Modele singleton;
	
	private G_Transporteur g_transporteur;
	private Course[] lesCourses;

	private G_Superviseur g_superviseur;

	private Transporteur transporteur;
	
	public AT_Modele() {
		AT_Modele.singleton = this;
		this.g_transporteur = null;
	}
	
	public G_Transporteur g_transporteur(){
		if(this.g_transporteur == null)
			this.g_transporteur = CorbaObjectFinder.bind_G_Transporteur();
		return this.g_transporteur;
	}
	
	public void setLesCourses(Course[] p_courses){
		this.lesCourses = p_courses;
	}
	
	public Course[] getLesCourses(){
		return this.lesCourses;
	}

	public Course getUneCourse(short nCourse) {
		Course retour = null;
		for(int i = 0;i < this.lesCourses.length; i++ ){
			if(this.lesCourses[i].noCourse == nCourse){
				retour = this.lesCourses[i];
				i = this.lesCourses.length; //On force la sortie
			}
		}
		return retour;
	}

	public G_Superviseur g_superviseur() {
		if(this.g_superviseur == null)
			this.g_superviseur = CorbaObjectFinder.bind_G_Superviseur();
		return this.g_superviseur;
	}

	public void setTransporteur(Transporteur p_transp) {
		this.transporteur = p_transp;
	}
	
	public Transporteur getTransporteur() {
		return this.transporteur;
	}
}
