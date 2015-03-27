package delistation.exceptions;

/** 
 * Helper class for : ExceptionTransporteurInconnu
 *  
 * @author OpenORB Compiler
 */ 
public class ExceptionTransporteurInconnuHelper
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
     * Insert ExceptionTransporteurInconnu into an any
     * @param a an any
     * @param t ExceptionTransporteurInconnu value
     */
    public static void insert(org.omg.CORBA.Any a, delistation.exceptions.ExceptionTransporteurInconnu t)
    {
        a.insert_Streamable(new delistation.exceptions.ExceptionTransporteurInconnuHolder(t));
    }

    /**
     * Extract ExceptionTransporteurInconnu from an any
     * @param a an any
     * @return the extracted ExceptionTransporteurInconnu value
     */
    public static delistation.exceptions.ExceptionTransporteurInconnu extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof delistation.exceptions.ExceptionTransporteurInconnuHolder)
                    return ((delistation.exceptions.ExceptionTransporteurInconnuHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            delistation.exceptions.ExceptionTransporteurInconnuHolder h = new delistation.exceptions.ExceptionTransporteurInconnuHolder(read(a.create_input_stream()));
            a.insert_Streamable(h);
            return h.value;
        }
        return read(a.create_input_stream());
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;
    private static boolean _working = false;

    /**
     * Return the ExceptionTransporteurInconnu TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            synchronized(org.omg.CORBA.TypeCode.class) {
                if (_tc != null)
                    return _tc;
                if (_working)
                    return org.omg.CORBA.ORB.init().create_recursive_tc(id());
                _working = true;
                org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[0];

                _tc = orb.create_exception_tc(id(),"ExceptionTransporteurInconnu",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the ExceptionTransporteurInconnu IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:delistation/ExceptionTransporteurInconnu:1.0";

    /**
     * Read ExceptionTransporteurInconnu from a marshalled stream
     * @param istream the input stream
     * @return the readed ExceptionTransporteurInconnu value
     */
    public static delistation.exceptions.ExceptionTransporteurInconnu read(org.omg.CORBA.portable.InputStream istream)
    {
        delistation.exceptions.ExceptionTransporteurInconnu new_one = new delistation.exceptions.ExceptionTransporteurInconnu();

        if (!istream.read_string().equals(id()))
         throw new org.omg.CORBA.MARSHAL();

        return new_one;
    }

    /**
     * Write ExceptionTransporteurInconnu into a marshalled stream
     * @param ostream the output stream
     * @param value ExceptionTransporteurInconnu value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, delistation.exceptions.ExceptionTransporteurInconnu value)
    {
        ostream.write_string(id());
    }

}
