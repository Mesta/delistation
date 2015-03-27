package delistation.exceptions;

/**
 * Holder class for : ExceptionAdherentInconnu
 * 
 * @author OpenORB Compiler
 */
final public class ExceptionAdherentInconnuHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ExceptionAdherentInconnu value
     */
    public delistation.exceptions.ExceptionAdherentInconnu value;

    /**
     * Default constructor
     */
    public ExceptionAdherentInconnuHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ExceptionAdherentInconnuHolder(delistation.exceptions.ExceptionAdherentInconnu initial)
    {
        value = initial;
    }

    /**
     * Read ExceptionAdherentInconnu from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ExceptionAdherentInconnuHelper.read(istream);
    }

    /**
     * Write ExceptionAdherentInconnu into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ExceptionAdherentInconnuHelper.write(ostream,value);
    }

    /**
     * Return the ExceptionAdherentInconnu TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ExceptionAdherentInconnuHelper.type();
    }

}
