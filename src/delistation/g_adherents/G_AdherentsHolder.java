package delistation.g_adherents;

/**
 * Holder class for : G_Adherents
 * 
 * @author OpenORB Compiler
 */
final public class G_AdherentsHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal G_Adherents value
     */
    public delistation.g_adherents.G_Adherents value;

    /**
     * Default constructor
     */
    public G_AdherentsHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public G_AdherentsHolder(delistation.g_adherents.G_Adherents initial)
    {
        value = initial;
    }

    /**
     * Read G_Adherents from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = G_AdherentsHelper.read(istream);
    }

    /**
     * Write G_Adherents into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        G_AdherentsHelper.write(ostream,value);
    }

    /**
     * Return the G_Adherents TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return G_AdherentsHelper.type();
    }

}
