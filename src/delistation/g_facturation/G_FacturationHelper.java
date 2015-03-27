package delistation.g_facturation;

/** 
 * Helper class for : G_Facturation
 *  
 * @author OpenORB Compiler
 */ 
public class G_FacturationHelper
{
    /**
     * Insert G_Facturation into an any
     * @param a an any
     * @param t G_Facturation value
     */
    public static void insert(org.omg.CORBA.Any a, delistation.g_facturation.G_Facturation t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract G_Facturation from an any
     * @param a an any
     * @return the extracted G_Facturation value
     */
    public static delistation.g_facturation.G_Facturation extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return delistation.g_facturation.G_FacturationHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the G_Facturation TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"G_Facturation");
        }
        return _tc;
    }

    /**
     * Return the G_Facturation IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:delistation/g_facturation/G_Facturation:1.0";

    /**
     * Read G_Facturation from a marshalled stream
     * @param istream the input stream
     * @return the readed G_Facturation value
     */
    public static delistation.g_facturation.G_Facturation read(org.omg.CORBA.portable.InputStream istream)
    {
        return(delistation.g_facturation.G_Facturation)istream.read_Object(delistation.g_facturation._G_FacturationStub.class);
    }

    /**
     * Write G_Facturation into a marshalled stream
     * @param ostream the output stream
     * @param value G_Facturation value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, delistation.g_facturation.G_Facturation value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to G_Facturation
     * @param obj the CORBA Object
     * @return G_Facturation Object
     */
    public static G_Facturation narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof G_Facturation)
            return (G_Facturation)obj;

        if (obj._is_a(id()))
        {
            _G_FacturationStub stub = new _G_FacturationStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to G_Facturation
     * @param obj the CORBA Object
     * @return G_Facturation Object
     */
    public static G_Facturation unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof G_Facturation)
            return (G_Facturation)obj;

        _G_FacturationStub stub = new _G_FacturationStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
