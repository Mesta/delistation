package delistation.datatypes;

/** 
 * Helper class for : Transporteur
 *  
 * @author OpenORB Compiler
 */ 
public class TransporteurHelper
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
     * Insert Transporteur into an any
     * @param a an any
     * @param t Transporteur value
     */
    public static void insert(org.omg.CORBA.Any a, delistation.datatypes.Transporteur t)
    {
        a.insert_Streamable(new delistation.datatypes.TransporteurHolder(t));
    }

    /**
     * Extract Transporteur from an any
     * @param a an any
     * @return the extracted Transporteur value
     */
    public static delistation.datatypes.Transporteur extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof delistation.datatypes.TransporteurHolder)
                    return ((delistation.datatypes.TransporteurHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            delistation.datatypes.TransporteurHolder h = new delistation.datatypes.TransporteurHolder(read(a.create_input_stream()));
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
     * Return the Transporteur TypeCode
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
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[3];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "noTransporteur";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_short);
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "raisonSociale";
                _members[1].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[2] = new org.omg.CORBA.StructMember();
                _members[2].name = "MdP";
                _members[2].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _tc = orb.create_struct_tc(id(),"Transporteur",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the Transporteur IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:delistation/Transporteur:1.0";

    /**
     * Read Transporteur from a marshalled stream
     * @param istream the input stream
     * @return the readed Transporteur value
     */
    public static delistation.datatypes.Transporteur read(org.omg.CORBA.portable.InputStream istream)
    {
        delistation.datatypes.Transporteur new_one = new delistation.datatypes.Transporteur();

        new_one.noTransporteur = istream.read_short();
        new_one.raisonSociale = istream.read_string();
        new_one.MdP = istream.read_string();

        return new_one;
    }

    /**
     * Write Transporteur into a marshalled stream
     * @param ostream the output stream
     * @param value Transporteur value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, delistation.datatypes.Transporteur value)
    {
        ostream.write_short(value.noTransporteur);
        ostream.write_string(value.raisonSociale);
        ostream.write_string(value.MdP);
    }

}
