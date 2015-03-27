package delistation.exceptions;

/**
 * Exception definition : ExceptionMauvaisTransporteur
 * 
 * @author OpenORB Compiler
 */
public final class ExceptionMauvaisTransporteur extends org.omg.CORBA.UserException
{
    /**
     * Default constructor
     */
    public ExceptionMauvaisTransporteur()
    {
        super(ExceptionMauvaisTransporteurHelper.id());
    }

    /**
     * Full constructor with fields initialization
     */
    public ExceptionMauvaisTransporteur(String orb_reason)
    {
        super(ExceptionMauvaisTransporteurHelper.id() +" " +  orb_reason);
    }

}
