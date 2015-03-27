package delistation.datatypes;

/** 
 * Helper class for : etatColis
 *  
 * @author OpenORB Compiler
 */ 
public class etatColisHelper
{
    /**
     * Insert etatColis into an any
     * @param a an any
     * @param t etatColis value
     */
    public static void insert(org.omg.CORBA.Any a, delistation.datatypes.etatColis t)
    {
        a.type(type());
        write(a.create_output_stream(),t);
    }

    /**
     * Extract etatColis from an any
     * @param a an any
     * @return the extracted etatColis value
     */
    public static delistation.datatypes.etatColis extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        return read(a.create_input_stream());
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the etatColis TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            String []_members = new String[4];
            _members[0] = "enAttenteDeTransport";
            _members[1] = "auDepart";
            _members[2] = "enTransport";
            _members[3] = "aDestination";
            _tc = orb.create_enum_tc(id(),"etatColis",_members);
        }
        return _tc;
    }

    /**
     * Return the etatColis IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:delistation/etatColis:1.0";

    /**
     * Read etatColis from a marshalled stream
     * @param istream the input stream
     * @return the readed etatColis value
     */
    public static delistation.datatypes.etatColis read(org.omg.CORBA.portable.InputStream istream)
    {
        return etatColis.from_int(istream.read_ulong());
    }

    /**
     * Write etatColis into a marshalled stream
     * @param ostream the output stream
     * @param value etatColis value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, delistation.datatypes.etatColis value)
    {
        ostream.write_ulong(value.value());
    }

}
