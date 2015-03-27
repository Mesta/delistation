package delistation.exceptions;

/**
 * Holder class for : ExceptionAdresseDejaPrise
 * 
 * @author OpenORB Compiler
 */
final public class ExceptionAdresseDejaPriseHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ExceptionAdresseDejaPrise value
     */
    public delistation.exceptions.ExceptionAdresseDejaPrise value;

    /**
     * Default constructor
     */
    public ExceptionAdresseDejaPriseHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ExceptionAdresseDejaPriseHolder(delistation.exceptions.ExceptionAdresseDejaPrise initial)
    {
        value = initial;
    }

    /**
     * Read ExceptionAdresseDejaPrise from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ExceptionAdresseDejaPriseHelper.read(istream);
    }

    /**
     * Write ExceptionAdresseDejaPrise into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ExceptionAdresseDejaPriseHelper.write(ostream,value);
    }

    /**
     * Return the ExceptionAdresseDejaPrise TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ExceptionAdresseDejaPriseHelper.type();
    }

}
