package delistation.datatypes;

/**
 * Struct definition : Course
 * 
 * @author OpenORB Compiler
*/
public final class Course implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member noCourse
     */
    public short noCourse;

    /**
     * Struct member noColis
     */
    public short noColis;

    /**
     * Struct member IORG_Colis
     */
    public String IORG_Colis;

    /**
     * Struct member noTransp
     */
    public short noTransp;

    /**
     * Struct member montant
     */
    public short montant;

    /**
     * Struct member datePriseEnCharge
     */
    public long datePriseEnCharge;

    /**
     * Default constructor
     */
    public Course()
    { }

    /**
     * Constructor with fields initialization
     * @param noCourse noCourse struct member
     * @param noColis noColis struct member
     * @param IORG_Colis IORG_Colis struct member
     * @param noTransp noTransp struct member
     * @param montant montant struct member
     * @param datePriseEnCharge datePriseEnCharge struct member
     */
    public Course(short noCourse, short noColis, String IORG_Colis, short noTransp, short montant, long datePriseEnCharge)
    {
        this.noCourse = noCourse;
        this.noColis = noColis;
        this.IORG_Colis = IORG_Colis;
        this.noTransp = noTransp;
        this.montant = montant;
        this.datePriseEnCharge = datePriseEnCharge;
    }

}
