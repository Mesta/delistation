package delistation.datatypes;

/**
 * Holder class for : Facture
 * 
 * @author OpenORB Compiler
 */
final public class FactureHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal Facture value
     */
    public delistation.datatypes.Facture value;

    /**
     * Default constructor
     */
    public FactureHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public FactureHolder(delistation.datatypes.Facture initial)
    {
        value = initial;
    }

    /**
     * Read Facture from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = FactureHelper.read(istream);
    }

    /**
     * Write Facture into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        FactureHelper.write(ostream,value);
    }

    /**
     * Return the Facture TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return FactureHelper.type();
    }

}
