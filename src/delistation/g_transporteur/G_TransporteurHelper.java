package delistation.g_transporteur;

/** 
 * Helper class for : G_Transporteur
 *  
 * @author OpenORB Compiler
 */ 
public class G_TransporteurHelper
{
    /**
     * Insert G_Transporteur into an any
     * @param a an any
     * @param t G_Transporteur value
     */
    public static void insert(org.omg.CORBA.Any a, delistation.g_transporteur.G_Transporteur t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract G_Transporteur from an any
     * @param a an any
     * @return the extracted G_Transporteur value
     */
    public static delistation.g_transporteur.G_Transporteur extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return delistation.g_transporteur.G_TransporteurHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the G_Transporteur TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"G_Transporteur");
        }
        return _tc;
    }

    /**
     * Return the G_Transporteur IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:delistation/g_transporteur/G_Transporteur:1.0";

    /**
     * Read G_Transporteur from a marshalled stream
     * @param istream the input stream
     * @return the readed G_Transporteur value
     */
    public static delistation.g_transporteur.G_Transporteur read(org.omg.CORBA.portable.InputStream istream)
    {
        return(delistation.g_transporteur.G_Transporteur)istream.read_Object(delistation.g_transporteur._G_TransporteurStub.class);
    }

    /**
     * Write G_Transporteur into a marshalled stream
     * @param ostream the output stream
     * @param value G_Transporteur value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, delistation.g_transporteur.G_Transporteur value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to G_Transporteur
     * @param obj the CORBA Object
     * @return G_Transporteur Object
     */
    public static G_Transporteur narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof G_Transporteur)
            return (G_Transporteur)obj;

        if (obj._is_a(id()))
        {
            _G_TransporteurStub stub = new _G_TransporteurStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to G_Transporteur
     * @param obj the CORBA Object
     * @return G_Transporteur Object
     */
    public static G_Transporteur unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof G_Transporteur)
            return (G_Transporteur)obj;

        _G_TransporteurStub stub = new _G_TransporteurStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
