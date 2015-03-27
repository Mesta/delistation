package delistation.exceptions;

/**
 * Holder class for : ExceptionColisInconnu
 * 
 * @author OpenORB Compiler
 */
final public class ExceptionColisInconnuHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ExceptionColisInconnu value
     */
    public delistation.exceptions.ExceptionColisInconnu value;

    /**
     * Default constructor
     */
    public ExceptionColisInconnuHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ExceptionColisInconnuHolder(delistation.exceptions.ExceptionColisInconnu initial)
    {
        value = initial;
    }

    /**
     * Read ExceptionColisInconnu from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ExceptionColisInconnuHelper.read(istream);
    }

    /**
     * Write ExceptionColisInconnu into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ExceptionColisInconnuHelper.write(ostream,value);
    }

    /**
     * Return the ExceptionColisInconnu TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ExceptionColisInconnuHelper.type();
    }

}
