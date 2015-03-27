package delistation.g_colis;

/** 
 * Helper class for : G_Colis
 *  
 * @author OpenORB Compiler
 */ 
public class G_ColisHelper
{
    /**
     * Insert G_Colis into an any
     * @param a an any
     * @param t G_Colis value
     */
    public static void insert(org.omg.CORBA.Any a, delistation.g_colis.G_Colis t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract G_Colis from an any
     * @param a an any
     * @return the extracted G_Colis value
     */
    public static delistation.g_colis.G_Colis extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return delistation.g_colis.G_ColisHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the G_Colis TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"G_Colis");
        }
        return _tc;
    }

    /**
     * Return the G_Colis IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:delistation/g_colis/G_Colis:1.0";

    /**
     * Read G_Colis from a marshalled stream
     * @param istream the input stream
     * @return the readed G_Colis value
     */
    public static delistation.g_colis.G_Colis read(org.omg.CORBA.portable.InputStream istream)
    {
        return(delistation.g_colis.G_Colis)istream.read_Object(delistation.g_colis._G_ColisStub.class);
    }

    /**
     * Write G_Colis into a marshalled stream
     * @param ostream the output stream
     * @param value G_Colis value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, delistation.g_colis.G_Colis value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to G_Colis
     * @param obj the CORBA Object
     * @return G_Colis Object
     */
    public static G_Colis narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof G_Colis)
            return (G_Colis)obj;

        if (obj._is_a(id()))
        {
            _G_ColisStub stub = new _G_ColisStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to G_Colis
     * @param obj the CORBA Object
     * @return G_Colis Object
     */
    public static G_Colis unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof G_Colis)
            return (G_Colis)obj;

        _G_ColisStub stub = new _G_ColisStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
