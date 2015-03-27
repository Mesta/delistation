package delistation.datatypes;

/**
 * Enum definition : CompteMode
 *
 * @author OpenORB Compiler
*/
public final class CompteMode implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Enum member Adherent value 
     */
    public static final int _Adherent = 0;

    /**
     * Enum member Adherent
     */
    public static final CompteMode Adherent = new CompteMode(_Adherent);

    /**
     * Enum member Transporteur value 
     */
    public static final int _Transporteur = 1;

    /**
     * Enum member Transporteur
     */
    public static final CompteMode Transporteur = new CompteMode(_Transporteur);

    /**
     * Internal member value 
     */
    private final int _CompteMode_value;

    /**
     * Private constructor
     * @param  the enum value for this new member
     */
    private CompteMode( final int value )
    {
        _CompteMode_value = value;
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
        return _CompteMode_value;
    }

    /**
     * Return a enum member from its value
     * @param  an enum value
     * @return an enum member
         */
    public static CompteMode from_int(int value)
    {
        switch (value)
        {
        case 0 :
            return Adherent;
        case 1 :
            return Transporteur;
        }
        throw new org.omg.CORBA.BAD_OPERATION();
    }

    /**
     * Return a string representation
     * @return a string representation of the enumeration
     */
    public java.lang.String toString()
    {
        switch (_CompteMode_value)
        {
        case 0 :
            return "Adherent";
        case 1 :
            return "Transporteur";
        }
        throw new org.omg.CORBA.BAD_OPERATION();
    }

}
