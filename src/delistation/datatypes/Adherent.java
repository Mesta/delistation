package delistation.datatypes;

/**
 * Struct definition : Adherent
 * 
 * @author OpenORB Compiler
*/
public final class Adherent implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member no
     */
    public short no;

    /**
     * Struct member nom
     */
    public String nom;

    /**
     * Struct member prenom
     */
    public String prenom;

    /**
     * Struct member adresse
     */
    public delistation.datatypes.Adresse adresse;

    /**
     * Struct member RIB
     */
    public String RIB;

    /**
     * Struct member MdP
     */
    public String MdP;

    /**
     * Struct member IORAppliCliente
     */
    public String IORAppliCliente;

    /**
     * Default constructor
     */
    public Adherent()
    { }

    /**
     * Constructor with fields initialization
     * @param no no struct member
     * @param nom nom struct member
     * @param prenom prenom struct member
     * @param adresse adresse struct member
     * @param RIB RIB struct member
     * @param MdP MdP struct member
     * @param IORAppliCliente IORAppliCliente struct member
     */
    public Adherent(short no, String nom, String prenom, delistation.datatypes.Adresse adresse, String RIB, String MdP, String IORAppliCliente)
    {
        this.no = no;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.RIB = RIB;
        this.MdP = MdP;
        this.IORAppliCliente = IORAppliCliente;
    }

}
