package delistation.datatypes;

/**
 * Struct definition : Colis
 * 
 * @author OpenORB Compiler
*/
public final class Colis implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member noColis
     */
    public short noColis;

    /**
     * Struct member expediteur
     */
    public short expediteur;

    /**
     * Struct member destinataire
     */
    public short destinataire;

    /**
     * Default constructor
     */
    public Colis()
    { }

    /**
     * Constructor with fields initialization
     * @param noColis noColis struct member
     * @param expediteur expediteur struct member
     * @param destinataire destinataire struct member
     */
    public Colis(short noColis, short expediteur, short destinataire)
    {
        this.noColis = noColis;
        this.expediteur = expediteur;
        this.destinataire = destinataire;
    }

}
