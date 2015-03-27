package delistation.datatypes;

/** 
 * Helper class for : LCourses
 *  
 * @author OpenORB Compiler
 */ 
public class LCoursesHelper
{
    private static final boolean HAS_OPENORB;
    static {
        boolean hasOpenORB = false;
        try {
            Thread.currentThread().getContextClassLoader().loadClass("org.openorb.CORBA.Any");
            hasOpenORB = true;
        }
        catch(ClassNotFoundException ex) {
        }
        HAS_OPENORB = hasOpenORB;
    }
    /**
     * Insert LCourses into an any
     * @param a an any
     * @param t LCourses value
     */
    public static void insert(org.omg.CORBA.Any a, delistation.datatypes.Course[] t)
    {
        a.insert_Streamable(new delistation.datatypes.LCoursesHolder(t));
    }

    /**
     * Extract LCourses from an any
     * @param a an any
     * @return the extracted LCourses value
     */
    public static delistation.datatypes.Course[] extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if(HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof delistation.datatypes.LCoursesHolder)
                    return ((delistation.datatypes.LCoursesHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            delistation.datatypes.LCoursesHolder h = new delistation.datatypes.LCoursesHolder(read(a.create_input_stream()));
            a.insert_Streamable(h);
            return h.value;
        }
        return read(a.create_input_stream());
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the LCourses TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"LCourses",orb.create_sequence_tc(0,delistation.datatypes.CourseHelper.type()));
        }
        return _tc;
    }

    /**
     * Return the LCourses IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:delistation/LCourses:1.0";

    /**
     * Read LCourses from a marshalled stream
     * @param istream the input stream
     * @return the readed LCourses value
     */
    public static delistation.datatypes.Course[] read(org.omg.CORBA.portable.InputStream istream)
    {
        delistation.datatypes.Course[] new_one;
        {
        int size7 = istream.read_ulong();
        new_one = new delistation.datatypes.Course[size7];
        for (int i7=0; i7<new_one.length; i7++)
         {
            new_one[i7] = delistation.datatypes.CourseHelper.read(istream);

         }
        }

        return new_one;
    }

    /**
     * Write LCourses into a marshalled stream
     * @param ostream the output stream
     * @param value LCourses value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, delistation.datatypes.Course[] value)
    {
        ostream.write_ulong(value.length);
        for (int i7=0; i7<value.length; i7++)
        {
            delistation.datatypes.CourseHelper.write(ostream,value[i7]);

        }
    }

}
