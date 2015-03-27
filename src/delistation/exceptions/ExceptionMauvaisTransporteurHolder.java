package delistation.exceptions;

/**
 * Holder class for : ExceptionMauvaisTransporteur
 * 
 * @author OpenORB Compiler
 */
final public class ExceptionMauvaisTransporteurHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ExceptionMauvaisTransporteur value
     */
    public delistation.exceptions.ExceptionMauvaisTransporteur value;

    /**
     * Default constructor
     */
    public ExceptionMauvaisTransporteurHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ExceptionMauvaisTransporteurHolder(delistation.exceptions.ExceptionMauvaisTransporteur initial)
    {
        value = initial;
    }

    /**
     * Read ExceptionMauvaisTransporteur from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ExceptionMauvaisTransporteurHelper.read(istream);
    }

    /**
     * Write ExceptionMauvaisTransporteur into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ExceptionMauvaisTransporteurHelper.write(ostream,value);
    }

    /**
     * Return the ExceptionMauvaisTransporteur TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ExceptionMauvaisTransporteurHelper.type();
    }

}
