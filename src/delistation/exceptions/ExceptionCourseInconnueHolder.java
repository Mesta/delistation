package delistation.exceptions;

/**
 * Holder class for : ExceptionCourseInconnue
 * 
 * @author OpenORB Compiler
 */
final public class ExceptionCourseInconnueHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ExceptionCourseInconnue value
     */
    public delistation.exceptions.ExceptionCourseInconnue value;

    /**
     * Default constructor
     */
    public ExceptionCourseInconnueHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ExceptionCourseInconnueHolder(delistation.exceptions.ExceptionCourseInconnue initial)
    {
        value = initial;
    }

    /**
     * Read ExceptionCourseInconnue from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ExceptionCourseInconnueHelper.read(istream);
    }

    /**
     * Write ExceptionCourseInconnue into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ExceptionCourseInconnueHelper.write(ostream,value);
    }

    /**
     * Return the ExceptionCourseInconnue TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ExceptionCourseInconnueHelper.type();
    }

}
