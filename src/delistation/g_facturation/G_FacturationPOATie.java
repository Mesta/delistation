package delistation.g_facturation;

/**
 * Interface definition : G_Facturation
 * 
 * @author OpenORB Compiler
 */
public class G_FacturationPOATie extends G_FacturationPOA
{

    //
    // Private reference to implementation object
    //
    private G_FacturationOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public G_FacturationPOATie(G_FacturationOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public G_FacturationPOATie(G_FacturationOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public G_FacturationOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(G_FacturationOperations delegate_)
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
     * Operation creerCompte
     */
    public boolean creerCompte(short noAdh, delistation.datatypes.CompteMode createMode)
    {
        return _tie.creerCompte( noAdh,  createMode);
    }

    /**
     * Operation factureAdhesion
     */
    public short factureAdhesion(String RIB)
        throws delistation.exceptions.ExceptionErreurPaiement
    {
        return _tie.factureAdhesion( RIB);
    }

    /**
     * Operation devisTransport
     */
    public short devisTransport(delistation.datatypes.Zone zoneDep, delistation.datatypes.Zone zoneDest)
    {
        return _tie.devisTransport( zoneDep,  zoneDest);
    }

    /**
     * Operation debiterAdherent
     */
    public boolean debiterAdherent(String RIB, short montant)
        throws delistation.exceptions.ExceptionErreurPaiement
    {
        return _tie.debiterAdherent( RIB,  montant);
    }

    /**
     * Operation crediterTransport
     */
    public void crediterTransport(String RIB, short montant)
    {
        _tie.crediterTransport( RIB,  montant);
    }

}
