package delistation.exceptions;

/**
 * Holder class for : ExceptionTransporteurInconnu
 * 
 * @author OpenORB Compiler
 */
final public class ExceptionTransporteurInconnuHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ExceptionTransporteurInconnu value
     */
    public delistation.exceptions.ExceptionTransporteurInconnu value;

    /**
     * Default constructor
     */
    public ExceptionTransporteurInconnuHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ExceptionTransporteurInconnuHolder(delistation.exceptions.ExceptionTransporteurInconnu initial)
    {
        value = initial;
    }

    /**
     * Read ExceptionTransporteurInconnu from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ExceptionTransporteurInconnuHelper.read(istream);
    }

    /**
     * Write ExceptionTransporteurInconnu into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ExceptionTransporteurInconnuHelper.write(ostream,value);
    }

    /**
     * Return the ExceptionTransporteurInconnu TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ExceptionTransporteurInconnuHelper.type();
    }

}
