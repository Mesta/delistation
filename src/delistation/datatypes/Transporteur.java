package delistation.datatypes;

/**
 * Struct definition : Transporteur
 * 
 * @author OpenORB Compiler
*/
public final class Transporteur implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member noTransporteur
     */
    public short noTransporteur;

    /**
     * Struct member raisonSociale
     */
    public String raisonSociale;

    /**
     * Struct member MdP
     */
    public String MdP;

    /**
     * Default constructor
     */
    public Transporteur()
    { }

    /**
     * Constructor with fields initialization
     * @param noTransporteur noTransporteur struct member
     * @param raisonSociale raisonSociale struct member
     * @param MdP MdP struct member
     */
    public Transporteur(short noTransporteur, String raisonSociale, String MdP)
    {
        this.noTransporteur = noTransporteur;
        this.raisonSociale = raisonSociale;
        this.MdP = MdP;
    }

}
