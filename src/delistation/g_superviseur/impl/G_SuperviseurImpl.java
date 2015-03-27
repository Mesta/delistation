package delistation.g_superviseur.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.logging.Level;

import delistation.datatypes.Course;
import delistation.datatypes.etatColis;
import delistation.exceptions.ExceptionCourseDejaPrise;
import delistation.exceptions.ExceptionCourseInconnue;
import delistation.exceptions.ExceptionMauvaisTransporteur;
import delistation.exceptions.ExceptionTransporteurInconnu;
import delistation.g_colis.G_Colis;
import delistation.g_facturation.G_Facturation;
import delistation.g_superviseur.G_SuperviseurPOA;
import delistation.g_transporteur.G_Transporteur;
import delistation.utils.CorbaObjectFinder;

public class G_SuperviseurImpl extends G_SuperviseurPOA {

	public Hashtable<Short, Course> LCourse;
	private G_Transporteur g_transporteur;
	private G_Facturation g_facturation;
	public ArrayList<Short> enRetard;
	
	public G_SuperviseurImpl() {
		this.LCourse = new Hashtable<Short, Course>();
		this.g_transporteur = null;
		this.enRetard = new ArrayList<Short>();
		//G_SuperviseurThread15M t = new G_SuperviseurThread15M(this);
		//t.start();
	}
	
	private G_Transporteur g_transporteur() {
		if (this.g_transporteur == null)
			this.g_transporteur = CorbaObjectFinder.bind_G_Transporteur();
		return this.g_transporteur;
	}

	public Course[] CourseEnCours() {
		return (Course[]) this.LCourse.values().toArray();
	}

	public void cloreTransport(short noColis) {
		//On récupère le colis
		Course tmp = this.LCourse.get(noColis);
		
		//On recherche le bon G_Colis et on met à jour l'état du colis
		CorbaObjectFinder.bind_G_Colis(tmp.IORG_Colis).majEtatColis(noColis, etatColis.aDestination);
		
		//On supprime le colis de la liste des colis en cours de traitement
		this.LCourse.remove(noColis);
		
		//On recupere le RIB du transporteur
		String RIB;
		try {
			RIB = this.g_transporteur().getRIB(tmp.noTransp);
			//On le credite du montant de la course
			this.g_facturation().crediterTransport(RIB, (short)(tmp.montant*0.9));
		} catch (ExceptionTransporteurInconnu e) {
			G_SuperviseurServeur.lgr.log(Level.INFO, "Le transporteur ne sera pas payé car il n'existe pas de trace de lui en base de données...");
		}

	}

	private G_Facturation g_facturation() {
		if(this.g_facturation == null){
			this.g_facturation = CorbaObjectFinder.bind_G_Facturation();
		}
		return g_facturation;
	}

	public boolean enregistrerPriseEnCharge(Course course)
			throws ExceptionCourseDejaPrise {
		
		if (this.LCourse.containsKey(course.noCourse))
			throw new ExceptionCourseDejaPrise();
		else{
        	java.util.Date date= new java.util.Date();
        	course.datePriseEnCharge = new Timestamp(date.getTime()).getTime();
			
        	//On le supprime de la liste des retards
        	if(this.enRetard.contains(course.noCourse))
        		this.enRetard.remove(course.noCourse);
        	
			this.LCourse.put(course.noCourse, course);
		
			G_Colis g_colis = CorbaObjectFinder.bind_G_Colis(course.IORG_Colis);
			g_colis.majEtatColis(course.noColis, etatColis.auDepart);
	
			this.g_transporteur().demandeSuppression(course.noCourse);
		}
		return true;
	}
	
	public Course verifierTransporteur(short noTransporteur, short noCourse)
			throws ExceptionMauvaisTransporteur, ExceptionCourseInconnue {
		// Course inconnue
		if (!this.LCourse.containsKey(noCourse))
			throw new ExceptionCourseInconnue();

		// Course connue
		else {
			// On la recupere dans la Hashtable
			Course tmp = this.LCourse.get(noCourse);

			// Si les transporteurs sont differents
			// (paramètre VS enregistré apres demande de prise en charge)
			if (tmp.noTransp != noTransporteur)
				throw new ExceptionMauvaisTransporteur();
			else{
				return tmp;
			}
		}
	}

	public Course[] rechercheCourseEnCours(short noAdh) {
		Course[] retour = {};

		Iterator<Course> it_course = this.LCourse.values().iterator();
		while (it_course.hasNext()) {
			Course tmp = it_course.next();

			G_Colis g_colis = (G_Colis) G_SuperviseurServeur.singleton.orb
					.string_to_object(tmp.IORG_Colis);
			if (g_colis.isDestinataire(tmp.noColis, noAdh))
				retour[retour.length] = tmp;
		}
		return retour;
	}

	public boolean estEnRetard(short noCourse) {
		return this.enRetard.contains(new Short(noCourse));
	}
}
