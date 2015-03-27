package delistation.g_colis;

/**
 * Interface definition : G_Colis
 * 
 * @author OpenORB Compiler
 */
public interface G_ColisOperations
{
    /**
     * Read accessor for getAdresseG_Colis attribute
     * @return the attribute value
     */
    public delistation.datatypes.Adresse getAdresseG_Colis();

    /**
     * Operation getColis
     */
    public delistation.datatypes.Colis getColis(short noColis)
        throws delistation.exceptions.ExceptionColisInconnu;

    /**
     * Operation isDestinataire
     */
    public boolean isDestinataire(short noColis, short noAdh);

    /**
     * Operation deposer
     */
    public short deposer(delistation.datatypes.Adresse adrDest, delistation.datatypes.ColisHolder colis)
        throws delistation.exceptions.ExceptionDestinationMemeZone, delistation.exceptions.ExceptionDestinataireInconnue, delistation.exceptions.ExceptionErreurPaiement;

    /**
     * Operation majEtatColis
     */
    public void majEtatColis(short noColis, delistation.datatypes.etatColis etat);

    /**
     * Operation demandeEtat
     */
    public delistation.datatypes.etatColis demandeEtat(short noColis)
        throws delistation.exceptions.ExceptionColisInconnu;

    /**
     * Operation supprimerColis
     */
    public void supprimerColis(short noColis);

}
