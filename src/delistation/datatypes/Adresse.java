package delistation.datatypes;

/**
 * Struct definition : Adresse
 * 
 * @author OpenORB Compiler
*/
public final class Adresse implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member nom
     */
    public String nom;

    /**
     * Struct member numero
     */
    public short numero;

    /**
     * Struct member rue
     */
    public String rue;

    /**
     * Struct member zone
     */
    public delistation.datatypes.Zone zone;

    /**
     * Default constructor
     */
    public Adresse()
    { }

    /**
     * Constructor with fields initialization
     * @param nom nom struct member
     * @param numero numero struct member
     * @param rue rue struct member
     * @param zone zone struct member
     */
    public Adresse(String nom, short numero, String rue, delistation.datatypes.Zone zone)
    {
        this.nom = nom;
        this.numero = numero;
        this.rue = rue;
        this.zone = zone;
    }

}
