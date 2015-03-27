package delistation.datatypes;

/**
 * Struct definition : Zone
 * 
 * @author OpenORB Compiler
*/
public final class Zone implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member commune
     */
    public short commune;

    /**
     * Struct member quartier
     */
    public short quartier;

    /**
     * Default constructor
     */
    public Zone()
    { }

    /**
     * Constructor with fields initialization
     * @param commune commune struct member
     * @param quartier quartier struct member
     */
    public Zone(short commune, short quartier)
    {
        this.commune = commune;
        this.quartier = quartier;
    }
    
    public String toString(){
    	return this.commune + "_" + this.quartier;
    }
}
