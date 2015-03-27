package delistation.datatypes;

/** 
 * Helper class for : Facture
 *  
 * @author OpenORB Compiler
 */ 
public class FactureHelper
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
     * Insert Facture into an any
     * @param a an any
     * @param t Facture value
     */
    public static void insert(org.omg.CORBA.Any a, delistation.datatypes.Facture t)
    {
        a.insert_Streamable(new delistation.datatypes.FactureHolder(t));
    }

    /**
     * Extract Facture from an any
     * @param a an any
     * @return the extracted Facture value
     */
    public static delistation.datatypes.Facture extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof delistation.datatypes.FactureHolder)
                    return ((delistation.datatypes.FactureHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            delistation.datatypes.FactureHolder h = new delistation.datatypes.FactureHolder(read(a.create_input_stream()));
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
     * Return the Facture TypeCode
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
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[2];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "somme";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_short);
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "datePaiement";
                _members[1].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_short);
                _tc = orb.create_struct_tc(id(),"Facture",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the Facture IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:delistation/Facture:1.0";

    /**
     * Read Facture from a marshalled stream
     * @param istream the input stream
     * @return the readed Facture value
     */
    public static delistation.datatypes.Facture read(org.omg.CORBA.portable.InputStream istream)
    {
        delistation.datatypes.Facture new_one = new delistation.datatypes.Facture();

        new_one.somme = istream.read_short();
        new_one.datePaiement = istream.read_short();

        return new_one;
    }

    /**
     * Write Facture into a marshalled stream
     * @param ostream the output stream
     * @param value Facture value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, delistation.datatypes.Facture value)
    {
        ostream.write_short(value.somme);
        ostream.write_short(value.datePaiement);
    }

}
