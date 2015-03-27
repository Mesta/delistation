package delistation.g_superviseur;

/**
 * Interface definition : G_Superviseur
 * 
 * @author OpenORB Compiler
 */
public class G_SuperviseurPOATie extends G_SuperviseurPOA
{

    //
    // Private reference to implementation object
    //
    private G_SuperviseurOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public G_SuperviseurPOATie(G_SuperviseurOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public G_SuperviseurPOATie(G_SuperviseurOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public G_SuperviseurOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(G_SuperviseurOperations delegate_)
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
     * Read accessor for CourseEnCours attribute
     */
    public delistation.datatypes.Course[] CourseEnCours()
    {
        return _tie.CourseEnCours();
    }

    /**
     * Operation rechercheCourseEnCours
     */
    public delistation.datatypes.Course[] rechercheCourseEnCours(short noAdh)
    {
        return _tie.rechercheCourseEnCours( noAdh);
    }

    /**
     * Operation cloreTransport
     */
    public void cloreTransport(short noColis)
    {
        _tie.cloreTransport( noColis);
    }

    /**
     * Operation enregistrerPriseEnCharge
     */
    public boolean enregistrerPriseEnCharge(delistation.datatypes.Course course)
        throws delistation.exceptions.ExceptionCourseDejaPrise
    {
        return _tie.enregistrerPriseEnCharge( course);
    }

    /**
     * Operation verifierTransporteur
     */
    public delistation.datatypes.Course verifierTransporteur(short noTransporteur, short noCourse)
        throws delistation.exceptions.ExceptionMauvaisTransporteur, delistation.exceptions.ExceptionCourseInconnue
    {
        return _tie.verifierTransporteur( noTransporteur,  noCourse);
    }

    /**
     * Operation estEnRetard
     */
    public boolean estEnRetard(short noCourse)
    {
        return _tie.estEnRetard( noCourse);
    }

}
