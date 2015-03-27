package delistation.appli_adherent;

/**
 * Interface definition : Appli_Adherent
 * 
 * @author OpenORB Compiler
 */
public class Appli_AdherentPOATie extends Appli_AdherentPOA
{

    //
    // Private reference to implementation object
    //
    private Appli_AdherentOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public Appli_AdherentPOATie(Appli_AdherentOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public Appli_AdherentPOATie(Appli_AdherentOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public Appli_AdherentOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(Appli_AdherentOperations delegate_)
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
     * Operation notifierColis
     */
    public void notifierColis()
    {
        _tie.notifierColis();
    }

}
