package delistation.g_transporteur;

/**
 * Interface definition : G_Transporteur
 * 
 * @author OpenORB Compiler
 */
public class G_TransporteurPOATie extends G_TransporteurPOA
{

    //
    // Private reference to implementation object
    //
    private G_TransporteurOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public G_TransporteurPOATie(G_TransporteurOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public G_TransporteurPOATie(G_TransporteurOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public G_TransporteurOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(G_TransporteurOperations delegate_)
    {
        _tie = delegate_;
    }

    /**
     * _default_POA method
     */
    public org.omg.PortableServer.POA _default_POA()
    {
        if (_poa != null)
            return _poa;
        else
            return super._default_POA();
    }

    /**
     * Operation getCoursesEnAttente
     */
    public delistation.datatypes.Course[] getCoursesEnAttente()
    {
        return _tie.getCoursesEnAttente();
    }

    /**
     * Operation authentifier
     */
    public boolean authentifier(short noTransp, String MdP)
    {
        return _tie.authentifier( noTransp,  MdP);
    }

    /**
     * Operation getTransporteur
     */
    public delistation.datatypes.Transporteur getTransporteur(short noTransp)
    {
        return _tie.getTransporteur( noTransp);
    }

    /**
     * Operation getRIB
     */
    public String getRIB(short noTransp)
        throws delistation.exceptions.ExceptionTransporteurInconnu
    {
        return _tie.getRIB( noTransp);
    }

    /**
     * Operation enregistrerNouveauTransport
     */
    public void enregistrerNouveauTransport(short noColis, String IORG_Colis, short montant)
    {
        _tie.enregistrerNouveauTransport( noColis,  IORG_Colis,  montant);
    }

    /**
     * Operation reenregistrerTransport
     */
    public void reenregistrerTransport(delistation.datatypes.Course p_course)
    {
        _tie.reenregistrerTransport( p_course);
    }

    /**
     * Operation demandeSuppression
     */
    public void demandeSuppression(short noCourse)
    {
        _tie.demandeSuppression( noCourse);
    }

}
