package delistation.g_transporteur;

/**
 * Interface definition : G_Transporteur
 * 
 * @author OpenORB Compiler
 */
public interface G_TransporteurOperations
{
    /**
     * Operation getCoursesEnAttente
     */
    public delistation.datatypes.Course[] getCoursesEnAttente();

    /**
     * Operation authentifier
     */
    public boolean authentifier(short noTransp, String MdP);

    /**
     * Operation getTransporteur
     */
    public delistation.datatypes.Transporteur getTransporteur(short noTransp);

    /**
     * Operation getRIB
     */
    public String getRIB(short noTransp)
        throws delistation.exceptions.ExceptionTransporteurInconnu;

    /**
     * Operation enregistrerNouveauTransport
     */
    public void enregistrerNouveauTransport(short noColis, String IORG_Colis, short montant);

    /**
     * Operation reenregistrerTransport
     */
    public void reenregistrerTransport(delistation.datatypes.Course p_course);

    /**
     * Operation demandeSuppression
     */
    public void demandeSuppression(short noCourse);

}
