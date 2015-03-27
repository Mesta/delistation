package delistation.g_adherents;

/**
 * Interface definition : G_Adherents
 * 
 * @author OpenORB Compiler
 */
public class G_AdherentsPOATie extends G_AdherentsPOA
{

    //
    // Private reference to implementation object
    //
    private G_AdherentsOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public G_AdherentsPOATie(G_AdherentsOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public G_AdherentsPOATie(G_AdherentsOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public G_AdherentsOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(G_AdherentsOperations delegate_)
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
     * Operation adherer
     */
    public short adherer(String nom, String prenom, String adresse, String RIB, org.omg.CORBA.StringHolder noAdh, org.omg.CORBA.StringHolder MdP)
        throws delistation.exceptions.ExceptionErreurPaiement, delistation.exceptions.ExceptionAdresseDejaPrise, delistation.exceptions.ExceptionErreurInscription
    {
        return _tie.adherer( nom,  prenom,  adresse,  RIB,  noAdh,  MdP);
    }

    /**
     * Operation authentifier
     */
    public boolean authentifier(short noAdh, String MdP)
    {
        return _tie.authentifier( noAdh,  MdP);
    }

    /**
     * Operation getAdherent
     */
    public delistation.datatypes.Adherent getAdherent(short noAdh)
        throws delistation.exceptions.ExceptionAdherentInconnu
    {
        return _tie.getAdherent( noAdh);
    }

    /**
     * Operation majIOR
     */
    public void majIOR(short noAdh, short IOR)
    {
        _tie.majIOR( noAdh,  IOR);
    }

    /**
     * Operation rechercheDestinataire
     */
    public delistation.datatypes.Adherent rechercheDestinataire(delistation.datatypes.Adresse adrDest)
        throws delistation.exceptions.ExceptionDestinataireInconnue
    {
        return _tie.rechercheDestinataire( adrDest);
    }

    /**
     * Operation facturer
     */
    public boolean facturer(short noAdh, short montant)
        throws delistation.exceptions.ExceptionErreurPaiement
    {
        return _tie.facturer( noAdh,  montant);
    }

    /**
     * Operation demandeNotificationDepot
     */
    public void demandeNotificationDepot(short noAdh)
    {
        _tie.demandeNotificationDepot( noAdh);
    }

}
