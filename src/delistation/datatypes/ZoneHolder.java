package delistation.datatypes;

/**
 * Holder class for : Zone
 * 
 * @author OpenORB Compiler
 */
final public class ZoneHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal Zone value
     */
    public delistation.datatypes.Zone value;

    /**
     * Default constructor
     */
    public ZoneHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ZoneHolder(delistation.datatypes.Zone initial)
    {
        value = initial;
    }

    /**
     * Read Zone from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ZoneHelper.read(istream);
    }

    /**
     * Write Zone into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ZoneHelper.write(ostream,value);
    }

    /**
     * Return the Zone TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ZoneHelper.type();
    }

}
