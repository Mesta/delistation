package delistation.datatypes;

/** 
 * Helper class for : Adresse
 *  
 * @author OpenORB Compiler
 */ 
public class AdresseHelper
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
     * Insert Adresse into an any
     * @param a an any
     * @param t Adresse value
     */
    public static void insert(org.omg.CORBA.Any a, delistation.datatypes.Adresse t)
    {
        a.insert_Streamable(new delistation.datatypes.AdresseHolder(t));
    }

    /**
     * Extract Adresse from an any
     * @param a an any
     * @return the extracted Adresse value
     */
    public static delistation.datatypes.Adresse extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof delistation.datatypes.AdresseHolder)
                    return ((delistation.datatypes.AdresseHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            delistation.datatypes.AdresseHolder h = new delistation.datatypes.AdresseHolder(read(a.create_input_stream()));
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
     * Return the Adresse TypeCode
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
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[4];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "nom";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "numero";
                _members[1].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_short);
                _members[2] = new org.omg.CORBA.StructMember();
                _members[2].name = "rue";
                _members[2].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[3] = new org.omg.CORBA.StructMember();
                _members[3].name = "zone";
                _members[3].type = delistation.datatypes.ZoneHelper.type();
                _tc = orb.create_struct_tc(id(),"Adresse",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the Adresse IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:delistation/Adresse:1.0";

    /**
     * Read Adresse from a marshalled stream
     * @param istream the input stream
     * @return the readed Adresse value
     */
    public static delistation.datatypes.Adresse read(org.omg.CORBA.portable.InputStream istream)
    {
        delistation.datatypes.Adresse new_one = new delistation.datatypes.Adresse();

        new_one.nom = istream.read_string();
        new_one.numero = istream.read_short();
        new_one.rue = istream.read_string();
        new_one.zone = delistation.datatypes.ZoneHelper.read(istream);

        return new_one;
    }

    /**
     * Write Adresse into a marshalled stream
     * @param ostream the output stream
     * @param value Adresse value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, delistation.datatypes.Adresse value)
    {
        ostream.write_string(value.nom);
        ostream.write_short(value.numero);
        ostream.write_string(value.rue);
        delistation.datatypes.ZoneHelper.write(ostream,value.zone);
    }

}
