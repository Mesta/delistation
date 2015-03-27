package delistation.exceptions;

/**
 * Holder class for : ExceptionDestinataireInconnue
 * 
 * @author OpenORB Compiler
 */
final public class ExceptionDestinataireInconnueHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ExceptionDestinataireInconnue value
     */
    public delistation.exceptions.ExceptionDestinataireInconnue value;

    /**
     * Default constructor
     */
    public ExceptionDestinataireInconnueHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ExceptionDestinataireInconnueHolder(delistation.exceptions.ExceptionDestinataireInconnue initial)
    {
        value = initial;
    }

    /**
     * Read ExceptionDestinataireInconnue from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ExceptionDestinataireInconnueHelper.read(istream);
    }

    /**
     * Write ExceptionDestinataireInconnue into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ExceptionDestinataireInconnueHelper.write(ostream,value);
    }

    /**
     * Return the ExceptionDestinataireInconnue TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ExceptionDestinataireInconnueHelper.type();
    }

}
