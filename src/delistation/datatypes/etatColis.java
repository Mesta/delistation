package delistation.datatypes;

/**
 * Enum definition : etatColis
 *
 * @author OpenORB Compiler
*/
public final class etatColis implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Enum member enAttenteDeTransport value 
     */
    public static final int _enAttenteDeTransport = 0;

    /**
     * Enum member enAttenteDeTransport
     */
    public static final etatColis enAttenteDeTransport = new etatColis(_enAttenteDeTransport);

    /**
     * Enum member auDepart value 
     */
    public static final int _auDepart = 1;

    /**
     * Enum member auDepart
     */
    public static final etatColis auDepart = new etatColis(_auDepart);

    /**
     * Enum member enTransport value 
     */
    public static final int _enTransport = 2;

    /**
     * Enum member enTransport
     */
    public static final etatColis enTransport = new etatColis(_enTransport);

    /**
     * Enum member aDestination value 
     */
    public static final int _aDestination = 3;

    /**
     * Enum member aDestination
     */
    public static final etatColis aDestination = new etatColis(_aDestination);

    /**
     * Internal member value 
     */
    private final int _etatColis_value;

    /**
     * Private constructor
     * @param  the enum value for this new member
     */
    private etatColis( final int value )
    {
        _etatColis_value = value;
    }

    /**
     * Maintains singleton property for serialized enums.
     * Issue 4271: IDL/Java issue, Mapping for IDL enum.
     */
    public java.lang.Object readResolve() throws java.io.ObjectStreamException
    {
        return from_int( value() );
    }

    /**
     * Return the internal member value
     * @return the member value
     */
    public int value()
    {
        return _etatColis_value;
    }

    /**
     * Return a enum member from its value
     * @param  an enum value
     * @return an enum member
         */
    public static etatColis from_int(int value)
    {
        switch (value)
        {
        case 0 :
            return enAttenteDeTransport;
        case 1 :
            return auDepart;
        case 2 :
            return enTransport;
        case 3 :
            return aDestination;
        }
        throw new org.omg.CORBA.BAD_OPERATION();
    }

    /**
     * Return a string representation
     * @return a string representation of the enumeration
     */
    public java.lang.String toString()
    {
        switch (_etatColis_value)
        {
        case 0 :
            return "enAttenteDeTransport";
        case 1 :
            return "auDepart";
        case 2 :
            return "enTransport";
        case 3 :
            return "aDestination";
        }
        throw new org.omg.CORBA.BAD_OPERATION();
    }

}
