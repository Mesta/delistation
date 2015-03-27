package delistation.datatypes;

/** 
 * Helper class for : CompteMode
 *  
 * @author OpenORB Compiler
 */ 
public class CompteModeHelper
{
    /**
     * Insert CompteMode into an any
     * @param a an any
     * @param t CompteMode value
     */
    public static void insert(org.omg.CORBA.Any a, delistation.datatypes.CompteMode t)
    {
        a.type(type());
        write(a.create_output_stream(),t);
    }

    /**
     * Extract CompteMode from an any
     * @param a an any
     * @return the extracted CompteMode value
     */
    public static delistation.datatypes.CompteMode extract(org.omg.CORBA.Any a)
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
     * Return the CompteMode TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            String []_members = new String[2];
            _members[0] = "Adherent";
            _members[1] = "Transporteur";
            _tc = orb.create_enum_tc(id(),"CompteMode",_members);
        }
        return _tc;
    }

    /**
     * Return the CompteMode IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:delistation/CompteMode:1.0";

    /**
     * Read CompteMode from a marshalled stream
     * @param istream the input stream
     * @return the readed CompteMode value
     */
    public static delistation.datatypes.CompteMode read(org.omg.CORBA.portable.InputStream istream)
    {
        return CompteMode.from_int(istream.read_ulong());
    }

    /**
     * Write CompteMode into a marshalled stream
     * @param ostream the output stream
     * @param value CompteMode value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, delistation.datatypes.CompteMode value)
    {
        ostream.write_ulong(value.value());
    }

}
