package delistation.g_transporteur;

/**
 * Holder class for : G_Transporteur
 * 
 * @author OpenORB Compiler
 */
final public class G_TransporteurHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal G_Transporteur value
     */
    public delistation.g_transporteur.G_Transporteur value;

    /**
     * Default constructor
     */
    public G_TransporteurHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public G_TransporteurHolder(delistation.g_transporteur.G_Transporteur initial)
    {
        value = initial;
    }

    /**
     * Read G_Transporteur from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = G_TransporteurHelper.read(istream);
    }

    /**
     * Write G_Transporteur into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        G_TransporteurHelper.write(ostream,value);
    }

    /**
     * Return the G_Transporteur TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return G_TransporteurHelper.type();
    }

}
