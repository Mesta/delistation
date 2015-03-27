package delistation.g_facturation;

/**
 * Interface definition : G_Facturation
 * 
 * @author OpenORB Compiler
 */
public interface G_FacturationOperations
{
    /**
     * Operation creerCompte
     */
    public boolean creerCompte(short noAdh, delistation.datatypes.CompteMode createMode);

    /**
     * Operation factureAdhesion
     */
    public short factureAdhesion(String RIB)
        throws delistation.exceptions.ExceptionErreurPaiement;

    /**
     * Operation devisTransport
     */
    public short devisTransport(delistation.datatypes.Zone zoneDep, delistation.datatypes.Zone zoneDest);

    /**
     * Operation debiterAdherent
     */
    public boolean debiterAdherent(String RIB, short montant)
        throws delistation.exceptions.ExceptionErreurPaiement;

    /**
     * Operation crediterTransport
     */
    public void crediterTransport(String RIB, short montant);

}
