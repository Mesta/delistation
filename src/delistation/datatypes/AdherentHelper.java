package delistation.datatypes;

/** 
 * Helper class for : Adherent
 *  
 * @author OpenORB Compiler
 */ 
public class AdherentHelper
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
     * Insert Adherent into an any
     * @param a an any
     * @param t Adherent value
     */
    public static void insert(org.omg.CORBA.Any a, delistation.datatypes.Adherent t)
    {
        a.insert_Streamable(new delistation.datatypes.AdherentHolder(t));
    }

    /**
     * Extract Adherent from an any
     * @param a an any
     * @return the extracted Adherent value
     */
    public static delistation.datatypes.Adherent extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof delistation.datatypes.AdherentHolder)
                    return ((delistation.datatypes.AdherentHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            delistation.datatypes.AdherentHolder h = new delistation.datatypes.AdherentHolder(read(a.create_input_stream()));
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
     * Return the Adherent TypeCode
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
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[7];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "no";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_short);
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "nom";
                _members[1].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[2] = new org.omg.CORBA.StructMember();
                _members[2].name = "prenom";
                _members[2].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[3] = new org.omg.CORBA.StructMember();
                _members[3].name = "adresse";
                _members[3].type = delistation.datatypes.AdresseHelper.type();
                _members[4] = new org.omg.CORBA.StructMember();
                _members[4].name = "RIB";
                _members[4].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[5] = new org.omg.CORBA.StructMember();
                _members[5].name = "MdP";
                _members[5].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[6] = new org.omg.CORBA.StructMember();
                _members[6].name = "IORAppliCliente";
                _members[6].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _tc = orb.create_struct_tc(id(),"Adherent",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the Adherent IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:delistation/Adherent:1.0";

    /**
     * Read Adherent from a marshalled stream
     * @param istream the input stream
     * @return the readed Adherent value
     */
    public static delistation.datatypes.Adherent read(org.omg.CORBA.portable.InputStream istream)
    {
        delistation.datatypes.Adherent new_one = new delistation.datatypes.Adherent();

        new_one.no = istream.read_short();
        new_one.nom = istream.read_string();
        new_one.prenom = istream.read_string();
        new_one.adresse = delistation.datatypes.AdresseHelper.read(istream);
        new_one.RIB = istream.read_string();
        new_one.MdP = istream.read_string();
        new_one.IORAppliCliente = istream.read_string();

        return new_one;
    }

    /**
     * Write Adherent into a marshalled stream
     * @param ostream the output stream
     * @param value Adherent value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, delistation.datatypes.Adherent value)
    {
        ostream.write_short(value.no);
        ostream.write_string(value.nom);
        ostream.write_string(value.prenom);
        delistation.datatypes.AdresseHelper.write(ostream,value.adresse);
        ostream.write_string(value.RIB);
        ostream.write_string(value.MdP);
        ostream.write_string(value.IORAppliCliente);
    }

}
