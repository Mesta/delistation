package delistation.g_colis;

/**
 * Holder class for : G_Colis
 * 
 * @author OpenORB Compiler
 */
final public class G_ColisHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal G_Colis value
     */
    public delistation.g_colis.G_Colis value;

    /**
     * Default constructor
     */
    public G_ColisHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public G_ColisHolder(delistation.g_colis.G_Colis initial)
    {
        value = initial;
    }

    /**
     * Read G_Colis from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = G_ColisHelper.read(istream);
    }

    /**
     * Write G_Colis into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        G_ColisHelper.write(ostream,value);
    }

    /**
     * Return the G_Colis TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return G_ColisHelper.type();
    }

}
