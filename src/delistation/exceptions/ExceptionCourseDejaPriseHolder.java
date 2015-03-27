package delistation.exceptions;

/**
 * Holder class for : ExceptionCourseDejaPrise
 * 
 * @author OpenORB Compiler
 */
final public class ExceptionCourseDejaPriseHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ExceptionCourseDejaPrise value
     */
    public delistation.exceptions.ExceptionCourseDejaPrise value;

    /**
     * Default constructor
     */
    public ExceptionCourseDejaPriseHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ExceptionCourseDejaPriseHolder(delistation.exceptions.ExceptionCourseDejaPrise initial)
    {
        value = initial;
    }

    /**
     * Read ExceptionCourseDejaPrise from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ExceptionCourseDejaPriseHelper.read(istream);
    }

    /**
     * Write ExceptionCourseDejaPrise into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ExceptionCourseDejaPriseHelper.write(ostream,value);
    }

    /**
     * Return the ExceptionCourseDejaPrise TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ExceptionCourseDejaPriseHelper.type();
    }

}
