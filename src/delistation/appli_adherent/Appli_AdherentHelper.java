package delistation.appli_adherent;

/** 
 * Helper class for : Appli_Adherent
 *  
 * @author OpenORB Compiler
 */ 
public class Appli_AdherentHelper
{
    /**
     * Insert Appli_Adherent into an any
     * @param a an any
     * @param t Appli_Adherent value
     */
    public static void insert(org.omg.CORBA.Any a, delistation.appli_adherent.Appli_Adherent t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract Appli_Adherent from an any
     * @param a an any
     * @return the extracted Appli_Adherent value
     */
    public static delistation.appli_adherent.Appli_Adherent extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return delistation.appli_adherent.Appli_AdherentHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the Appli_Adherent TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"Appli_Adherent");
        }
        return _tc;
    }

    /**
     * Return the Appli_Adherent IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:delistation/appli_adherent/Appli_Adherent:1.0";

    /**
     * Read Appli_Adherent from a marshalled stream
     * @param istream the input stream
     * @return the readed Appli_Adherent value
     */
    public static delistation.appli_adherent.Appli_Adherent read(org.omg.CORBA.portable.InputStream istream)
    {
        return(delistation.appli_adherent.Appli_Adherent)istream.read_Object(delistation.appli_adherent._Appli_AdherentStub.class);
    }

    /**
     * Write Appli_Adherent into a marshalled stream
     * @param ostream the output stream
     * @param value Appli_Adherent value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, delistation.appli_adherent.Appli_Adherent value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to Appli_Adherent
     * @param obj the CORBA Object
     * @return Appli_Adherent Object
     */
    public static Appli_Adherent narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof Appli_Adherent)
            return (Appli_Adherent)obj;

        if (obj._is_a(id()))
        {
            _Appli_AdherentStub stub = new _Appli_AdherentStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to Appli_Adherent
     * @param obj the CORBA Object
     * @return Appli_Adherent Object
     */
    public static Appli_Adherent unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof Appli_Adherent)
            return (Appli_Adherent)obj;

        _Appli_AdherentStub stub = new _Appli_AdherentStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
