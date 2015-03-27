package delistation.datatypes;

/** 
 * Helper class for : LAdresses
 *  
 * @author OpenORB Compiler
 */ 
public class LAdressesHelper
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
     * Insert LAdresses into an any
     * @param a an any
     * @param t LAdresses value
     */
    public static void insert(org.omg.CORBA.Any a, delistation.datatypes.Adresse[] t)
    {
        a.insert_Streamable(new delistation.datatypes.LAdressesHolder(t));
    }

    /**
     * Extract LAdresses from an any
     * @param a an any
     * @return the extracted LAdresses value
     */
    public static delistation.datatypes.Adresse[] extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if(HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof delistation.datatypes.LAdressesHolder)
                    return ((delistation.datatypes.LAdressesHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            delistation.datatypes.LAdressesHolder h = new delistation.datatypes.LAdressesHolder(read(a.create_input_stream()));
            a.insert_Streamable(h);
            return h.value;
        }
        return read(a.create_input_stream());
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the LAdresses TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"LAdresses",orb.create_sequence_tc(0,delistation.datatypes.AdresseHelper.type()));
        }
        return _tc;
    }

    /**
     * Return the LAdresses IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:delistation/LAdresses:1.0";

    /**
     * Read LAdresses from a marshalled stream
     * @param istream the input stream
     * @return the readed LAdresses value
     */
    public static delistation.datatypes.Adresse[] read(org.omg.CORBA.portable.InputStream istream)
    {
        delistation.datatypes.Adresse[] new_one;
        {
        int size7 = istream.read_ulong();
        new_one = new delistation.datatypes.Adresse[size7];
        for (int i7=0; i7<new_one.length; i7++)
         {
            new_one[i7] = delistation.datatypes.AdresseHelper.read(istream);

         }
        }

        return new_one;
    }

    /**
     * Write LAdresses into a marshalled stream
     * @param ostream the output stream
     * @param value LAdresses value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, delistation.datatypes.Adresse[] value)
    {
        ostream.write_ulong(value.length);
        for (int i7=0; i7<value.length; i7++)
        {
            delistation.datatypes.AdresseHelper.write(ostream,value[i7]);

        }
    }

}
