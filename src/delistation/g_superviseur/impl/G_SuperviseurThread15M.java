package delistation.g_superviseur.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Enumeration;
import java.util.logging.Level;

import delistation.datatypes.Course;
import delistation.datatypes.etatColis;
import delistation.exceptions.ExceptionColisInconnu;
import delistation.g_colis.G_Colis;
import delistation.utils.CorbaObjectFinder;

public class G_SuperviseurThread15M extends Thread{
	private G_SuperviseurImpl modele;
	private long maxDelayToPickUp;
	
	public G_SuperviseurThread15M(G_SuperviseurImpl p_modele){
		this.modele = p_modele;
		maxDelayToPickUp = 15 * 60 * 1000; //15 minutes
	}
	
	public void run(){
		try {
	        while (true) {
	        	//Mise en attente durant une minute
	            Thread.sleep(60 * 1000);
	            
	            //On récupère toutes les courses
	            
	            Enumeration<Course> enum_course = this.modele.LCourse.elements();
	            
	            while(enum_course.hasMoreElements()){
	            	Course tmp = enum_course.nextElement();
	            	try {
						/** Si l'état du colis est "auDepart", le transporteur a {@link maxDelayToPickUp} pour le récupérer */
						G_Colis tmp_g_colis = CorbaObjectFinder.bind_G_Colis(tmp.IORG_Colis); 
		            	etatColis tmp_etat = tmp_g_colis.demandeEtat(tmp.noColis);
						
						if(tmp_etat == etatColis.auDepart){
			            	if(this.verifierDelaiTransporteur(tmp))
			            		this.modele.enRetard.add(new Short(tmp.noCourse));
		            	}
					} catch (ExceptionColisInconnu e) {
						G_SuperviseurServeur.lgr.log(Level.SEVERE, e.getMessage(), e);
					}
	            }	            
	        }
	    } catch (InterruptedException e) {
			G_SuperviseurServeur.lgr.log(Level.SEVERE, e.getMessage(), e);

	    }catch(ClassCastException e){
        	G_SuperviseurServeur.lgr.log(Level.SEVERE, e.getMessage(), e);
        }
	}
	
	private boolean verifierDelaiTransporteur(Course course){
		boolean retour = false;
		
		//On compare le timestamp courant avec celui enregistré à la prise en charge
    	Date dateCourante = new java.util.Date();
    	long tsCourant = new Timestamp(dateCourante.getTime()).getTime();

    	if( (tsCourant - course.datePriseEnCharge) < this.maxDelayToPickUp)
    		retour = true;
    	else
    		retour = false;
		
		return retour;
	}
}
