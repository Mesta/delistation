package delistation.g_facturation;

/**
 * Holder class for : G_Facturation
 * 
 * @author OpenORB Compiler
 */
final public class G_FacturationHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal G_Facturation value
     */
    public delistation.g_facturation.G_Facturation value;

    /**
     * Default constructor
     */
    public G_FacturationHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public G_FacturationHolder(delistation.g_facturation.G_Facturation initial)
    {
        value = initial;
    }

    /**
     * Read G_Facturation from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = G_FacturationHelper.read(istream);
    }

    /**
     * Write G_Facturation into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        G_FacturationHelper.write(ostream,value);
    }

    /**
     * Return the G_Facturation TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return G_FacturationHelper.type();
    }

}
