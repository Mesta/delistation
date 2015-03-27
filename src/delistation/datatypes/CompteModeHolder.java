package delistation.datatypes;

/**
 * Holder class for : CompteMode
 * 
 * @author OpenORB Compiler
 */
final public class CompteModeHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal CompteMode value
     */
    public delistation.datatypes.CompteMode value;

    /**
     * Default constructor
     */
    public CompteModeHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public CompteModeHolder(delistation.datatypes.CompteMode initial)
    {
        value = initial;
    }

    /**
     * Read CompteMode from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = CompteModeHelper.read(istream);
    }

    /**
     * Write CompteMode into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        CompteModeHelper.write(ostream,value);
    }

    /**
     * Return the CompteMode TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return CompteModeHelper.type();
    }

}
