package delistation.datatypes;

/**
 * Holder class for : LColis
 * 
 * @author OpenORB Compiler
 */
final public class LColisHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal LColis value
     */
    public delistation.datatypes.Colis[] value;

    /**
     * Default constructor
     */
    public LColisHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public LColisHolder(delistation.datatypes.Colis[] initial)
    {
        value = initial;
    }

    /**
     * Read LColis from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = LColisHelper.read(istream);
    }

    /**
     * Write LColis into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        LColisHelper.write(ostream,value);
    }

    /**
     * Return the LColis TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return LColisHelper.type();
    }

}
