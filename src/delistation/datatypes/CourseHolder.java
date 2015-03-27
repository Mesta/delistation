package delistation.datatypes;

/**
 * Holder class for : Course
 * 
 * @author OpenORB Compiler
 */
final public class CourseHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal Course value
     */
    public delistation.datatypes.Course value;

    /**
     * Default constructor
     */
    public CourseHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public CourseHolder(delistation.datatypes.Course initial)
    {
        value = initial;
    }

    /**
     * Read Course from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = CourseHelper.read(istream);
    }

    /**
     * Write Course into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        CourseHelper.write(ostream,value);
    }

    /**
     * Return the Course TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return CourseHelper.type();
    }

}
