package delistation.exceptions;

/**
 * Exception definition : ExceptionTransporteurInconnu
 * 
 * @author OpenORB Compiler
 */
public final class ExceptionTransporteurInconnu extends org.omg.CORBA.UserException
{
    /**
     * Default constructor
     */
    public ExceptionTransporteurInconnu()
    {
        super(ExceptionTransporteurInconnuHelper.id());
    }

    /**
     * Full constructor with fields initialization
     */
    public ExceptionTransporteurInconnu(String orb_reason)
    {
        super(ExceptionTransporteurInconnuHelper.id() +" " +  orb_reason);
    }

}
