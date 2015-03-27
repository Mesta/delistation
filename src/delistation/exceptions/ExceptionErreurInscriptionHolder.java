package delistation.exceptions;

/**
 * Holder class for : ExceptionErreurInscription
 * 
 * @author OpenORB Compiler
 */
final public class ExceptionErreurInscriptionHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ExceptionErreurInscription value
     */
    public delistation.exceptions.ExceptionErreurInscription value;

    /**
     * Default constructor
     */
    public ExceptionErreurInscriptionHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ExceptionErreurInscriptionHolder(delistation.exceptions.ExceptionErreurInscription initial)
    {
        value = initial;
    }

    /**
     * Read ExceptionErreurInscription from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ExceptionErreurInscriptionHelper.read(istream);
    }

    /**
     * Write ExceptionErreurInscription into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ExceptionErreurInscriptionHelper.write(ostream,value);
    }

    /**
     * Return the ExceptionErreurInscription TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ExceptionErreurInscriptionHelper.type();
    }

}
