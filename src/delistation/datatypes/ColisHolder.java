package delistation.datatypes;

/**
 * Holder class for : Colis
 * 
 * @author OpenORB Compiler
 */
final public class ColisHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal Colis value
     */
    public delistation.datatypes.Colis value;

    /**
     * Default constructor
     */
    public ColisHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ColisHolder(delistation.datatypes.Colis initial)
    {
        value = initial;
    }

    /**
     * Read Colis from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ColisHelper.read(istream);
    }

    /**
     * Write Colis into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ColisHelper.write(ostream,value);
    }

    /**
     * Return the Colis TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ColisHelper.type();
    }

}
