package delistation.datatypes;

/** 
 * Helper class for : LColis
 *  
 * @author OpenORB Compiler
 */ 
public class LColisHelper
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
     * Insert LColis into an any
     * @param a an any
     * @param t LColis value
     */
    public static void insert(org.omg.CORBA.Any a, delistation.datatypes.Colis[] t)
    {
        a.insert_Streamable(new delistation.datatypes.LColisHolder(t));
    }

    /**
     * Extract LColis from an any
     * @param a an any
     * @return the extracted LColis value
     */
    public static delistation.datatypes.Colis[] extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if(HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof delistation.datatypes.LColisHolder)
                    return ((delistation.datatypes.LColisHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            delistation.datatypes.LColisHolder h = new delistation.datatypes.LColisHolder(read(a.create_input_stream()));
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
     * Return the LColis TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"LColis",orb.create_sequence_tc(0,delistation.datatypes.ColisHelper.type()));
        }
        return _tc;
    }

    /**
     * Return the LColis IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:delistation/LColis:1.0";

    /**
     * Read LColis from a marshalled stream
     * @param istream the input stream
     * @return the readed LColis value
     */
    public static delistation.datatypes.Colis[] read(org.omg.CORBA.portable.InputStream istream)
    {
        delistation.datatypes.Colis[] new_one;
        {
        int size7 = istream.read_ulong();
        new_one = new delistation.datatypes.Colis[size7];
        for (int i7=0; i7<new_one.length; i7++)
         {
            new_one[i7] = delistation.datatypes.ColisHelper.read(istream);

         }
        }

        return new_one;
    }

    /**
     * Write LColis into a marshalled stream
     * @param ostream the output stream
     * @param value LColis value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, delistation.datatypes.Colis[] value)
    {
        ostream.write_ulong(value.length);
        for (int i7=0; i7<value.length; i7++)
        {
            delistation.datatypes.ColisHelper.write(ostream,value[i7]);

        }
    }

}
