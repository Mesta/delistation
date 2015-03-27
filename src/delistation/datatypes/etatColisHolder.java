package delistation.datatypes;

/**
 * Holder class for : etatColis
 * 
 * @author OpenORB Compiler
 */
final public class etatColisHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal etatColis value
     */
    public delistation.datatypes.etatColis value;

    /**
     * Default constructor
     */
    public etatColisHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public etatColisHolder(delistation.datatypes.etatColis initial)
    {
        value = initial;
    }

    /**
     * Read etatColis from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = etatColisHelper.read(istream);
    }

    /**
     * Write etatColis into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        etatColisHelper.write(ostream,value);
    }

    /**
     * Return the etatColis TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return etatColisHelper.type();
    }

}
