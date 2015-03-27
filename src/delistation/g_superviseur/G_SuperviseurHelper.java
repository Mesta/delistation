package delistation.g_superviseur;

/** 
 * Helper class for : G_Superviseur
 *  
 * @author OpenORB Compiler
 */ 
public class G_SuperviseurHelper
{
    /**
     * Insert G_Superviseur into an any
     * @param a an any
     * @param t G_Superviseur value
     */
    public static void insert(org.omg.CORBA.Any a, delistation.g_superviseur.G_Superviseur t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract G_Superviseur from an any
     * @param a an any
     * @return the extracted G_Superviseur value
     */
    public static delistation.g_superviseur.G_Superviseur extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return delistation.g_superviseur.G_SuperviseurHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the G_Superviseur TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"G_Superviseur");
        }
        return _tc;
    }

    /**
     * Return the G_Superviseur IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:delistation/g_superviseur/G_Superviseur:1.0";

    /**
     * Read G_Superviseur from a marshalled stream
     * @param istream the input stream
     * @return the readed G_Superviseur value
     */
    public static delistation.g_superviseur.G_Superviseur read(org.omg.CORBA.portable.InputStream istream)
    {
        return(delistation.g_superviseur.G_Superviseur)istream.read_Object(delistation.g_superviseur._G_SuperviseurStub.class);
    }

    /**
     * Write G_Superviseur into a marshalled stream
     * @param ostream the output stream
     * @param value G_Superviseur value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, delistation.g_superviseur.G_Superviseur value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to G_Superviseur
     * @param obj the CORBA Object
     * @return G_Superviseur Object
     */
    public static G_Superviseur narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof G_Superviseur)
            return (G_Superviseur)obj;

        if (obj._is_a(id()))
        {
            _G_SuperviseurStub stub = new _G_SuperviseurStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to G_Superviseur
     * @param obj the CORBA Object
     * @return G_Superviseur Object
     */
    public static G_Superviseur unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof G_Superviseur)
            return (G_Superviseur)obj;

        _G_SuperviseurStub stub = new _G_SuperviseurStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
