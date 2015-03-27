package delistation.exceptions;

/** 
 * Helper class for : ExceptionErreurInscription
 *  
 * @author OpenORB Compiler
 */ 
public class ExceptionErreurInscriptionHelper
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
     * Insert ExceptionErreurInscription into an any
     * @param a an any
     * @param t ExceptionErreurInscription value
     */
    public static void insert(org.omg.CORBA.Any a, delistation.exceptions.ExceptionErreurInscription t)
    {
        a.insert_Streamable(new delistation.exceptions.ExceptionErreurInscriptionHolder(t));
    }

    /**
     * Extract ExceptionErreurInscription from an any
     * @param a an any
     * @return the extracted ExceptionErreurInscription value
     */
    public static delistation.exceptions.ExceptionErreurInscription extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof delistation.exceptions.ExceptionErreurInscriptionHolder)
                    return ((delistation.exceptions.ExceptionErreurInscriptionHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            delistation.exceptions.ExceptionErreurInscriptionHolder h = new delistation.exceptions.ExceptionErreurInscriptionHolder(read(a.create_input_stream()));
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
     * Return the ExceptionErreurInscription TypeCode
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

                _tc = orb.create_exception_tc(id(),"ExceptionErreurInscription",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the ExceptionErreurInscription IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:delistation/ExceptionErreurInscription:1.0";

    /**
     * Read ExceptionErreurInscription from a marshalled stream
     * @param istream the input stream
     * @return the readed ExceptionErreurInscription value
     */
    public static delistation.exceptions.ExceptionErreurInscription read(org.omg.CORBA.portable.InputStream istream)
    {
        delistation.exceptions.ExceptionErreurInscription new_one = new delistation.exceptions.ExceptionErreurInscription();

        if (!istream.read_string().equals(id()))
         throw new org.omg.CORBA.MARSHAL();

        return new_one;
    }

    /**
     * Write ExceptionErreurInscription into a marshalled stream
     * @param ostream the output stream
     * @param value ExceptionErreurInscription value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, delistation.exceptions.ExceptionErreurInscription value)
    {
        ostream.write_string(id());
    }

}
