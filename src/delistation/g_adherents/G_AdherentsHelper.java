package delistation.g_adherents;

/** 
 * Helper class for : G_Adherents
 *  
 * @author OpenORB Compiler
 */ 
public class G_AdherentsHelper
{
    /**
     * Insert G_Adherents into an any
     * @param a an any
     * @param t G_Adherents value
     */
    public static void insert(org.omg.CORBA.Any a, delistation.g_adherents.G_Adherents t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract G_Adherents from an any
     * @param a an any
     * @return the extracted G_Adherents value
     */
    public static delistation.g_adherents.G_Adherents extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return delistation.g_adherents.G_AdherentsHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the G_Adherents TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"G_Adherents");
        }
        return _tc;
    }

    /**
     * Return the G_Adherents IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:delistation/g_adherents/G_Adherents:1.0";

    /**
     * Read G_Adherents from a marshalled stream
     * @param istream the input stream
     * @return the readed G_Adherents value
     */
    public static delistation.g_adherents.G_Adherents read(org.omg.CORBA.portable.InputStream istream)
    {
        return(delistation.g_adherents.G_Adherents)istream.read_Object(delistation.g_adherents._G_AdherentsStub.class);
    }

    /**
     * Write G_Adherents into a marshalled stream
     * @param ostream the output stream
     * @param value G_Adherents value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, delistation.g_adherents.G_Adherents value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to G_Adherents
     * @param obj the CORBA Object
     * @return G_Adherents Object
     */
    public static G_Adherents narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof G_Adherents)
            return (G_Adherents)obj;

        if (obj._is_a(id()))
        {
            _G_AdherentsStub stub = new _G_AdherentsStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to G_Adherents
     * @param obj the CORBA Object
     * @return G_Adherents Object
     */
    public static G_Adherents unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof G_Adherents)
            return (G_Adherents)obj;

        _G_AdherentsStub stub = new _G_AdherentsStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
