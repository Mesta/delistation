package delistation.exceptions;

/**
 * Holder class for : ExceptionErreurPaiement
 * 
 * @author OpenORB Compiler
 */
final public class ExceptionErreurPaiementHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ExceptionErreurPaiement value
     */
    public delistation.exceptions.ExceptionErreurPaiement value;

    /**
     * Default constructor
     */
    public ExceptionErreurPaiementHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ExceptionErreurPaiementHolder(delistation.exceptions.ExceptionErreurPaiement initial)
    {
        value = initial;
    }

    /**
     * Read ExceptionErreurPaiement from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ExceptionErreurPaiementHelper.read(istream);
    }

    /**
     * Write ExceptionErreurPaiement into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ExceptionErreurPaiementHelper.write(ostream,value);
    }

    /**
     * Return the ExceptionErreurPaiement TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ExceptionErreurPaiementHelper.type();
    }

}
