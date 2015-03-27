package delistation.g_colis;

/**
 * Interface definition : G_Colis
 * 
 * @author OpenORB Compiler
 */
public class G_ColisPOATie extends G_ColisPOA
{

    //
    // Private reference to implementation object
    //
    private G_ColisOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public G_ColisPOATie(G_ColisOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public G_ColisPOATie(G_ColisOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public G_ColisOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(G_ColisOperations delegate_)
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
     * Read accessor for getAdresseG_Colis attribute
     */
    public delistation.datatypes.Adresse getAdresseG_Colis()
    {
        return _tie.getAdresseG_Colis();
    }

    /**
     * Operation getColis
     */
    public delistation.datatypes.Colis getColis(short noColis)
        throws delistation.exceptions.ExceptionColisInconnu
    {
        return _tie.getColis( noColis);
    }

    /**
     * Operation isDestinataire
     */
    public boolean isDestinataire(short noColis, short noAdh)
    {
        return _tie.isDestinataire( noColis,  noAdh);
    }

    /**
     * Operation deposer
     */
    public short deposer(delistation.datatypes.Adresse adrDest, delistation.datatypes.ColisHolder colis)
        throws delistation.exceptions.ExceptionDestinationMemeZone, delistation.exceptions.ExceptionDestinataireInconnue, delistation.exceptions.ExceptionErreurPaiement
    {
        return _tie.deposer( adrDest,  colis);
    }

    /**
     * Operation majEtatColis
     */
    public void majEtatColis(short noColis, delistation.datatypes.etatColis etat)
    {
        _tie.majEtatColis( noColis,  etat);
    }

    /**
     * Operation demandeEtat
     */
    public delistation.datatypes.etatColis demandeEtat(short noColis)
        throws delistation.exceptions.ExceptionColisInconnu
    {
        return _tie.demandeEtat( noColis);
    }

    /**
     * Operation supprimerColis
     */
    public void supprimerColis(short noColis)
    {
        _tie.supprimerColis( noColis);
    }

}
