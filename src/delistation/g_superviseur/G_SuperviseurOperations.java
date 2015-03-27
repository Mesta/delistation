package delistation.g_superviseur;

/**
 * Interface definition : G_Superviseur
 * 
 * @author OpenORB Compiler
 */
public interface G_SuperviseurOperations
{
    /**
     * Read accessor for CourseEnCours attribute
     * @return the attribute value
     */
    public delistation.datatypes.Course[] CourseEnCours();

    /**
     * Operation rechercheCourseEnCours
     */
    public delistation.datatypes.Course[] rechercheCourseEnCours(short noAdh);

    /**
     * Operation cloreTransport
     */
    public void cloreTransport(short noColis);

    /**
     * Operation enregistrerPriseEnCharge
     */
    public boolean enregistrerPriseEnCharge(delistation.datatypes.Course course)
        throws delistation.exceptions.ExceptionCourseDejaPrise;

    /**
     * Operation verifierTransporteur
     */
    public delistation.datatypes.Course verifierTransporteur(short noTransporteur, short noCourse)
        throws delistation.exceptions.ExceptionMauvaisTransporteur, delistation.exceptions.ExceptionCourseInconnue;

    /**
     * Operation estEnRetard
     */
    public boolean estEnRetard(short noCourse);

}
