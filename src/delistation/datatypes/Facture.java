package delistation.datatypes;

/**
 * Struct definition : Facture
 * 
 * @author OpenORB Compiler
*/
public final class Facture implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member somme
     */
    public short somme;

    /**
     * Struct member datePaiement
     */
    public short datePaiement;

    /**
     * Default constructor
     */
    public Facture()
    { }

    /**
     * Constructor with fields initialization
     * @param somme somme struct member
     * @param datePaiement datePaiement struct member
     */
    public Facture(short somme, short datePaiement)
    {
        this.somme = somme;
        this.datePaiement = datePaiement;
    }

}
