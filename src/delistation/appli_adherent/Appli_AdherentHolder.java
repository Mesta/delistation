package delistation.appli_adherent;

/**
 * Holder class for : Appli_Adherent
 * 
 * @author OpenORB Compiler
 */
final public class Appli_AdherentHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal Appli_Adherent value
     */
    public delistation.appli_adherent.Appli_Adherent value;

    /**
     * Default constructor
     */
    public Appli_AdherentHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public Appli_AdherentHolder(delistation.appli_adherent.Appli_Adherent initial)
    {
        value = initial;
    }

    /**
     * Read Appli_Adherent from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = Appli_AdherentHelper.read(istream);
    }

    /**
     * Write Appli_Adherent into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        Appli_AdherentHelper.write(ostream,value);
    }

    /**
     * Return the Appli_Adherent TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return Appli_AdherentHelper.type();
    }

}
