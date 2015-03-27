package delistation.exceptions;

/**
 * Holder class for : ExceptionDestinationMemeZone
 * 
 * @author OpenORB Compiler
 */
final public class ExceptionDestinationMemeZoneHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ExceptionDestinationMemeZone value
     */
    public delistation.exceptions.ExceptionDestinationMemeZone value;

    /**
     * Default constructor
     */
    public ExceptionDestinationMemeZoneHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ExceptionDestinationMemeZoneHolder(delistation.exceptions.ExceptionDestinationMemeZone initial)
    {
        value = initial;
    }

    /**
     * Read ExceptionDestinationMemeZone from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ExceptionDestinationMemeZoneHelper.read(istream);
    }

    /**
     * Write ExceptionDestinationMemeZone into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ExceptionDestinationMemeZoneHelper.write(ostream,value);
    }

    /**
     * Return the ExceptionDestinationMemeZone TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ExceptionDestinationMemeZoneHelper.type();
    }

}
