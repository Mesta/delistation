package delistation.datatypes;

/**
 * Holder class for : LCourses
 * 
 * @author OpenORB Compiler
 */
final public class LCoursesHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal LCourses value
     */
    public delistation.datatypes.Course[] value;

    /**
     * Default constructor
     */
    public LCoursesHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public LCoursesHolder(delistation.datatypes.Course[] initial)
    {
        value = initial;
    }

    /**
     * Read LCourses from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = LCoursesHelper.read(istream);
    }

    /**
     * Write LCourses into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        LCoursesHelper.write(ostream,value);
    }

    /**
     * Return the LCourses TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return LCoursesHelper.type();
    }

}
