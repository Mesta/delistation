package delistation.datatypes;

/** 
 * Helper class for : LFactures
 *  
 * @author OpenORB Compiler
 */ 
public class LFacturesHelper
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
     * Insert LFactures into an any
     * @param a an any
     * @param t LFactures value
     */
    public static void insert(org.omg.CORBA.Any a, delistation.datatypes.Facture[] t)
    {
        a.insert_Streamable(new delistation.datatypes.LFacturesHolder(t));
    }

    /**
     * Extract LFactures from an any
     * @param a an any
     * @return the extracted LFactures value
     */
    public static delistation.datatypes.Facture[] extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if(HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof delistation.datatypes.LFacturesHolder)
                    return ((delistation.datatypes.LFacturesHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            delistation.datatypes.LFacturesHolder h = new delistation.datatypes.LFacturesHolder(read(a.create_input_stream()));
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
     * Return the LFactures TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"LFactures",orb.create_sequence_tc(0,delistation.datatypes.FactureHelper.type()));
        }
        return _tc;
    }

    /**
     * Return the LFactures IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:delistation/LFactures:1.0";

    /**
     * Read LFactures from a marshalled stream
     * @param istream the input stream
     * @return the readed LFactures value
     */
    public static delistation.datatypes.Facture[] read(org.omg.CORBA.portable.InputStream istream)
    {
        delistation.datatypes.Facture[] new_one;
        {
        int size7 = istream.read_ulong();
        new_one = new delistation.datatypes.Facture[size7];
        for (int i7=0; i7<new_one.length; i7++)
         {
            new_one[i7] = delistation.datatypes.FactureHelper.read(istream);

         }
        }

        return new_one;
    }

    /**
     * Write LFactures into a marshalled stream
     * @param ostream the output stream
     * @param value LFactures value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, delistation.datatypes.Facture[] value)
    {
        ostream.write_ulong(value.length);
        for (int i7=0; i7<value.length; i7++)
        {
            delistation.datatypes.FactureHelper.write(ostream,value[i7]);

        }
    }

}
