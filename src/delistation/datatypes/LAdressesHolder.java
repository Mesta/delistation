package delistation.datatypes;

/**
 * Holder class for : LAdresses
 * 
 * @author OpenORB Compiler
 */
final public class LAdressesHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal LAdresses value
     */
    public delistation.datatypes.Adresse[] value;

    /**
     * Default constructor
     */
    public LAdressesHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public LAdressesHolder(delistation.datatypes.Adresse[] initial)
    {
        value = initial;
    }

    /**
     * Read LAdresses from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = LAdressesHelper.read(istream);
    }

    /**
     * Write LAdresses into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        LAdressesHelper.write(ostream,value);
    }

    /**
     * Return the LAdresses TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return LAdressesHelper.type();
    }

}
