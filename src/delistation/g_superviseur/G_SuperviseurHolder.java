package delistation.g_superviseur;

/**
 * Holder class for : G_Superviseur
 * 
 * @author OpenORB Compiler
 */
final public class G_SuperviseurHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal G_Superviseur value
     */
    public delistation.g_superviseur.G_Superviseur value;

    /**
     * Default constructor
     */
    public G_SuperviseurHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public G_SuperviseurHolder(delistation.g_superviseur.G_Superviseur initial)
    {
        value = initial;
    }

    /**
     * Read G_Superviseur from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = G_SuperviseurHelper.read(istream);
    }

    /**
     * Write G_Superviseur into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        G_SuperviseurHelper.write(ostream,value);
    }

    /**
     * Return the G_Superviseur TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return G_SuperviseurHelper.type();
    }

}
