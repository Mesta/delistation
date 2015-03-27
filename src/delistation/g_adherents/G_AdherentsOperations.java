package delistation.g_adherents;

/**
 * Interface definition : G_Adherents
 * 
 * @author OpenORB Compiler
 */
public interface G_AdherentsOperations
{
    /**
     * Operation adherer
     */
    public short adherer(String nom, String prenom, String adresse, String RIB, org.omg.CORBA.StringHolder noAdh, org.omg.CORBA.StringHolder MdP)
        throws delistation.exceptions.ExceptionErreurPaiement, delistation.exceptions.ExceptionAdresseDejaPrise, delistation.exceptions.ExceptionErreurInscription;

    /**
     * Operation authentifier
     */
    public boolean authentifier(short noAdh, String MdP);

    /**
     * Operation getAdherent
     */
    public delistation.datatypes.Adherent getAdherent(short noAdh)
        throws delistation.exceptions.ExceptionAdherentInconnu;

    /**
     * Operation majIOR
     */
    public void majIOR(short noAdh, short IOR);

    /**
     * Operation rechercheDestinataire
     */
    public delistation.datatypes.Adherent rechercheDestinataire(delistation.datatypes.Adresse adrDest)
        throws delistation.exceptions.ExceptionDestinataireInconnue;

    /**
     * Operation facturer
     */
    public boolean facturer(short noAdh, short montant)
        throws delistation.exceptions.ExceptionErreurPaiement;

    /**
     * Operation demandeNotificationDepot
     */
    public void demandeNotificationDepot(short noAdh);

}
