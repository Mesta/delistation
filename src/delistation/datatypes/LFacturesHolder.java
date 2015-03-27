package delistation.datatypes;

/**
 * Holder class for : LFactures
 * 
 * @author OpenORB Compiler
 */
final public class LFacturesHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal LFactures value
     */
    public delistation.datatypes.Facture[] value;

    /**
     * Default constructor
     */
    public LFacturesHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public LFacturesHolder(delistation.datatypes.Facture[] initial)
    {
        value = initial;
    }

    /**
     * Read LFactures from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = LFacturesHelper.read(istream);
    }

    /**
     * Write LFactures into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        LFacturesHelper.write(ostream,value);
    }

    /**
     * Return the LFactures TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return LFacturesHelper.type();
    }

}
